################################################################################################
##### DART
################################################################################################
run:
	dart ./bin/server.dart

run-test:
	dart test

dep-installer:
	dart pub get

formatter:
	dart format --output=none --set-exit-if-changed .

analyzer:
	dart analyze

exec:
	dart compile exe ./bin/server.dart
	
################################################################################################
##### DOCKER
################################################################################################
container-dev:
	docker compose -f docker-compose-dev.yml up

container:
	docker compose -f docker-compose.yml up

image:
	docker build -f eg-dart-shelf .