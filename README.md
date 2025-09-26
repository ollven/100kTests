# 100,000 tests (10% fail) — Maven + JUnit 5, no parallel

- 100 classes (`DynBatch001Test` … `DynBatch100Test`), 1,000 dynamic tests in each.
- 10% fail, the rest pass.
- Parallel execution is disabled: src/test/resources/junit-platform.properties contains
  junit.jupiter.execution.parallel.enabled=false

Run:
mvn -q test

Re-enable parallelism (no commit needed):
mvn -q test -Djunit.jupiter.execution.parallel.enabled=true -Djunit.jupiter.execution.parallel.mode.default=concurrent -Djunit.jupiter.execution.parallel.config.strategy=fixed -Djunit.jupiter.execution.parallel.config.fixed.parallelism=8


