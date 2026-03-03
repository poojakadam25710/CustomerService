# M7G Large – Vehicle Voice Assistant Integration

Multi-module Spring Boot backend for controlling vehicles via Alexa voice commands.

## Modules

- `m7g-common` – shared DTOs and enums (e.g. `VoiceCommandRequest`, `VehicleCommandType`).
- `m7g-auth-service` – authentication and JWT service for drivers.
- `m7g-voice-gateway` – public API for Alexa callbacks and mobile apps, publishes commands to Kafka and reads from Redis.
- `m7g-command-service` – consumes vehicle command events, applies business rules, persists to MySQL, and talks to vehicle/OEM gateway.
- `m7g-status-service` – consumes vehicle status events, updates MySQL and Redis, exposes status/history APIs.

## Build

From the `m7g-voice-assistant` folder:

```bash
mvn clean install
```

