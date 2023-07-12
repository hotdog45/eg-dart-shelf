import 'package:eg_dart_shelf/common/exceptions/argument_exception.dart';
import 'package:eg_dart_shelf/common/exceptions/not_found_exception.dart';
import 'package:eg_dart_shelf/profiles/model/follow.dart';
import 'package:eg_dart_shelf/users/users_service.dart';
import 'package:postgres_pool/postgres_pool.dart';

class ProfilesService {
  static String followsTable = 'follows';

  final PgPool connectionPool;
  final UsersService usersService;

  ProfilesService({required this.connectionPool, required this.usersService});

  Future<Follow> createFollow(
      {required String followerId, required String followeeId}) async {
    if (followerId == followeeId) {
      throw ArgumentException(message: 'Cannot follow own user');
    }

    final follower = await usersService.getUserById(followerId);

    if (follower == null) {
      throw NotFoundException(message: 'Follower not found');
    }

    final followee = await usersService.getUserById(followeeId);

    if (followee == null) {
      throw NotFoundException(message: 'Followee not found');
    }

    final existingFollow = await getFollowByFollowerAndFollowee(
        followerId: follower.id, followeeId: followee.id);

    if (existingFollow != null) {
      return existingFollow;
    }

    final hasDeletedFollowSql =
        'SELECT EXISTS(SELECT 1 FROM $followsTable WHERE follower_id = @followerId AND followee_id = @followeeId AND deleted_at IS NOT NULL);';

    final hasDeletedFollowResult =
        await connectionPool.query(hasDeletedFollowSql, substitutionValues: {
      'followerId': follower.id,
      'followeeId': followee.id,
    });

    var hasDeletedFollow = hasDeletedFollowResult[0][0];

    String sql;
    if (hasDeletedFollow) {
      sql =
          'UPDATE $followsTable SET deleted_at = NULL, updated_at = current_timestamp WHERE follower_id = @followerId AND followee_id = @followeeId RETURNING id, created_at, updated_at, deleted_at';
    } else {
      sql =
          'INSERT INTO $followsTable(follower_id, followee_id) VALUES (@followerId, @followeeId) RETURNING id, created_at, updated_at, deleted_at;';
    }

    final result = await connectionPool.query(sql, substitutionValues: {
      'followerId': follower.id,
      'followeeId': followee.id,
    });

    final followRow = result[0];

    final followId = followRow[0];
    final createdAt = followRow[1];
    final updatedAt = followRow[2];
    final deletedAt = followRow[3];

    return Follow(
        id: followId,
        followerId: follower.id,
        followeeId: followee.id,
        createdAt: createdAt,
        updatedAt: updatedAt,
        deletedAt: deletedAt);
  }

  Future<Follow?> getFollowById(String followId) async {
    final sql =
        'SELECT follower_id, followee_id, created_at, updated_at, deleted_at FROM $followsTable WHERE id = @followId AND deleted_at IS NULL;';

    final result = await connectionPool
        .query(sql, substitutionValues: {'followId': followId});

    if (result.isEmpty) {
      return null;
    }

    final followRow = result[0];

    final followerId = followRow[0];
    final followeeId = followRow[1];
    final createdAt = followRow[2];
    final updatedAt = followRow[3];
    final deletedAt = followRow[4];

    return Follow(
        id: followId,
        followerId: followerId,
        followeeId: followeeId,
        createdAt: createdAt,
        updatedAt: updatedAt,
        deletedAt: deletedAt);
  }

  Future<Follow?> getFollowByFollowerAndFollowee(
      {required String followerId, required String followeeId}) async {
    final follower = await usersService.getUserById(followerId);

    if (follower == null) {
      throw ArgumentException(
          message: 'Follower not found', parameterName: 'followerId');
    }

    final followee = await usersService.getUserById(followeeId);

    if (followee == null) {
      throw ArgumentException(
          message: 'Followee not found', parameterName: 'followeeId');
    }

    final sql =
        'SELECT id FROM $followsTable WHERE follower_id = @followerId AND followee_id = @followeeId AND deleted_at IS NULL;';

    final result = await connectionPool.query(sql, substitutionValues: {
      'followerId': follower.id,
      'followeeId': followee.id
    });

    if (result.isEmpty) {
      return null;
    }

    final followId = result[0][0];

    return await getFollowById(followId);
  }

  Future deleteFollowByFollowerAndFollowee(
      {required String followerId, required String followeeId}) async {
    if (!(await isFollowing(followerId: followerId, followeeId: followeeId))) {
      throw ArgumentException(message: 'Follow was not found');
    }

    final sql =
        "UPDATE $followsTable SET deleted_at = current_timestamp WHERE follower_id = @followerId AND followee_id = @followeeId;";

    await connectionPool.query(sql, substitutionValues: {
      'followerId': followerId,
      'followeeId': followeeId,
    });
  }

  Future<bool> isFollowing(
      {required String followerId, required String followeeId}) async {
    return await getFollowByFollowerAndFollowee(
            followerId: followerId, followeeId: followeeId) !=
        null;
  }
}
