package com.example.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;

public class DynBatch097Test {
  private static final int START = 96001; // inclusive, 1-based
  private static final int COUNT = 1000;          // 1,000 tests per class

  @TestFactory
  Stream<DynamicTest> dynamicTests() {
    return IntStream.range(0, COUNT).mapToObj(i -> {
      final int id = START + i; // global id 1..100000
      return dynamicTest("case-" + id, () -> {
        if (id % 10 == 0) {
          fail("Intentional fail for id=" + id);
        } else {
          assertTrue(id > 0);
        }
      });
    });
  }
}
