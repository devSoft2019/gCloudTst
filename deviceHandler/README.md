#

This app is an API backend, which exposes methods to handle information related to devices.

## Prerequisites
```
java8
google-cloud-sdk
gcloud beta emulators
```

## Installation
#### Usage in local

Start DataStore emulator

```
gcloud beta emulators datastore start

```
Run application

```
./mvnw -DskipTests spring-boot:run

```
## Deploy application

```gcloud app create --region us-central```

```./mvnw -DskipTests appengine:deploy```

## Usage

Save device

```
curl -d '{"idDevice":0001, "macAdress":"FF:FF:FF:FF:FF:FF", , "timestamp":1549044171}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/device
```

Get device by macAdress

```
curl -d -H "Content-Type: application/json" -X GET http://localhost:8080/api/device/macAdress?macAdress=FF:FF:FF:FF:FF:FF
```

Get device by idDevice

```
curl -d -H "Content-Type: application/json" -X GET http://localhost:8080/api/device/id?idDevice=1
```

Get all devices

```
curl -d -H "Content-Type: application/json" -X GET http://localhost:8080/api/devices
```

