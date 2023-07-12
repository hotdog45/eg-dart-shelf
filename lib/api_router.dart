import 'package:eg_dart_shelf/articles/articles_router.dart';
import 'package:eg_dart_shelf/common/middleware/json_content_type_response.dart';
import 'package:eg_dart_shelf/profiles/profiles_router.dart';
import 'package:eg_dart_shelf/users/users_router.dart';
import 'package:shelf/shelf.dart';
import 'package:shelf_cors_headers/shelf_cors_headers.dart';
import 'package:shelf_router/shelf_router.dart';

class ApiRouter {
  final UsersRouter usersRouter;
  final ProfilesRouter profilesRouter;
  final ArticlesRouter articlesRouter;

  ApiRouter(
      {required this.usersRouter,
      required this.profilesRouter,
      required this.articlesRouter});

  Handler get router {
    final router = Router();
    final prefix = '/api';

    router.mount(prefix, usersRouter.router);
    router.mount(prefix, profilesRouter.router);
    router.mount(prefix, articlesRouter.router);

    return Pipeline()
        .addMiddleware(corsHeaders())
        .addMiddleware(jsonContentTypeResponse())
        .addHandler(router);
  }
}
