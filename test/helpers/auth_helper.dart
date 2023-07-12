import 'package:eg_dart_shelf/users/jwt_service.dart';

import '../test_fixtures.dart';

Map<String, String> makeHeadersWithAuthorization(String token) {
  return {'Authorization': 'Token $token'};
}

String makeTokenWithEmail(String email) {
  final jwtService = JwtService(issuer: issuer, secretKey: secretKey);
  return jwtService.getToken(email);
}
