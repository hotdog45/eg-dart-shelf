import 'dart:convert';

import 'package:eg_dart_shelf/common/errors/dtos/error_dto.dart';
import 'package:eg_dart_shelf/users/dtos/user_dto.dart';
import 'package:slugify/slugify.dart';
import 'package:test/test.dart';

import '../helpers/articles_helper.dart';
import '../helpers/profiles_helper.dart';
import '../helpers/users_helper.dart';
import '../test_fixtures.dart';

void main() {
  late UserDto author;

  setUp(() async {
    author = (await registerRandomUserAndUpdateBioAndImage()).user;
  });

  group('Given caller not authenticated', () {
    test('Should return 200', () async {
      final createdArticle = await createRandomArticleAndDecode(author,
          tagList: faker.lorem.words(faker.randomGenerator.integer(5, min: 1)));

      final article = await getArticleAndDecodeBySlug(createdArticle.slug);

      expect(article.favorited, false);
      expect(article.author.following, false);
      expect(article.toJson(), createdArticle.toJson());
    });
  });

  group('Given caller authenticated', () {
    test('Given caller follows the author should return 200', () async {
      final caller = await registerRandomUser();

      await followUserByUsernameAndDecode(author.username,
          token: caller.user.token);

      final createdArticle = await createRandomArticleAndDecode(author,
          tagList: faker.lorem.words(faker.randomGenerator.integer(5, min: 1)));

      final article = await getArticleAndDecodeBySlug(createdArticle.slug,
          token: caller.user.token);

      expect(article.author.following, true);
      expect(article.slug, createdArticle.slug);
    });

    test('Given caller does not follow the author should return 200', () async {
      final caller = await registerRandomUser();

      final createdArticle = await createRandomArticleAndDecode(author);

      final article = await getArticleAndDecodeBySlug(createdArticle.slug,
          token: caller.user.token);

      expect(article.author.following, false);
      expect(article.toJson(), createdArticle.toJson());
    });

    test('Given caller has favorited the article should return 200', () async {
      final caller = await registerRandomUser();

      final createdArticle = await createRandomArticleAndDecode(author);

      await favoriteArticleBySlug(createdArticle.slug,
          token: caller.user.token);

      final article = await getArticleAndDecodeBySlug(createdArticle.slug,
          token: caller.user.token);

      expect(article.favorited, true);
    });

    test('Given caller has not favorited the article should return 200',
        () async {
      final caller = await registerRandomUser();

      final createdArticle = await createRandomArticleAndDecode(author);

      final article = await getArticleAndDecodeBySlug(createdArticle.slug,
          token: caller.user.token);

      expect(article.favorited, false);
    });
  });

  test('Given article does not exist should return 404', () async {
    final slug = slugify(faker.lorem.sentence());

    final response = await getArticleBySlug(slug);

    expect(response.statusCode, 404);

    final responseJson = jsonDecode(response.body);

    final error = ErrorDto.fromJson(responseJson);

    expect(error.errors[0], 'Article not found');
  });
}
