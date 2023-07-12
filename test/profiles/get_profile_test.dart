import 'dart:convert';

import 'package:eg_dart_shelf/common/errors/dtos/error_dto.dart';
import 'package:eg_dart_shelf/users/dtos/user_dto.dart';
import 'package:test/test.dart';

import '../helpers/profiles_helper.dart';
import '../helpers/users_helper.dart';
import '../test_fixtures.dart';

void main() {
  late UserDto profileUser;

  setUp(() async {
    profileUser = (await registerRandomUserAndUpdateBioAndImage()).user;
  });

  group('Caller not authenticated', () {
    test('Should return 200', () async {
      final profile = await getProfileByUsernameAndDecode(profileUser.username);

      expect(profile.username, profileUser.username);
      expect(profile.bio, profileUser.bio);
      expect(profile.image, profileUser.image);
      expect(profile.following, false);
    });

    test('Given profile does not exist should return 404', () async {
      final username = faker.internet.userName();

      final response = await getProfileByUsername(username);

      expect(response.statusCode, 404);

      final responseJson = jsonDecode(response.body);

      final errorDto = ErrorDto.fromJson(responseJson);

      expect(errorDto.errors[0], 'User not found');
    });
  });

  group('Caller authenticated', () {
    test('Given caller is following the profile should return 200', () async {
      final caller = await registerRandomUser();

      await followUserByUsername(profileUser.username,
          token: caller.user.token);

      final profile = await getProfileByUsernameAndDecode(profileUser.username,
          token: caller.user.token);

      expect(profile.username, profileUser.username);
      expect(profile.bio, profileUser.bio);
      expect(profile.image, profileUser.image);
      expect(profile.following, true);
    });

    test('Given caller is not following the profile should return 200',
        () async {
      final caller = await registerRandomUser();

      final profile = await getProfileByUsernameAndDecode(profileUser.username,
          token: caller.user.token);

      expect(profile.username, profileUser.username);
      expect(profile.bio, profileUser.bio);
      expect(profile.image, profileUser.image);
      expect(profile.following, false);
    });

    test('Given profile does not exist should return 404', () async {
      final caller = await registerRandomUser();

      final username = faker.internet.userName();

      final response =
          await getProfileByUsername(username, token: caller.user.token);

      expect(response.statusCode, 404);

      final responseJson = jsonDecode(response.body);

      final errorDto = ErrorDto.fromJson(responseJson);

      expect(errorDto.errors[0], 'User not found');
    });
  });
}
