# 100,000 tests (10% fail) — Maven + JUnit 5, no parallel

- 100 классов (`DynBatch001Test` … `DynBatch100Test`), по 1000 динамических тестов в каждом.
- 10% фейлятся, остальные проходят.
- Параллельный запуск **выключен**: `src/test/resources/junit-platform.properties` содержит
  `junit.jupiter.execution.parallel.enabled=false`.

## Запуск
```bash
mvn -q test
```

## Как снова включить параллель при необходимости (без коммита)
```bash
mvn -q test -Djunit.jupiter.execution.parallel.enabled=true   -Djunit.jupiter.execution.parallel.mode.default=concurrent   -Djunit.jupiter.execution.parallel.config.strategy=fixed   -Djunit.jupiter.execution.parallel.config.fixed.parallelism=8
```
