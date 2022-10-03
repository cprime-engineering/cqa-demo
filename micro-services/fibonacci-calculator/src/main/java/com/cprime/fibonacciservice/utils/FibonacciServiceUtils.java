package com.cprime.fibonacciservice.utils;

import com.cprime.fibonacciservice.exceptions.FibonacciIndexOutOfBoundsException;
import com.cprime.fibonacciservice.exceptions.FibonacciIndexWrongTypeException;

/**
 * Utility call to validate arguements passed to the fibonacci service.
 *
 * @author @devopskev
 */
public final class FibonacciServiceUtils {

  private FibonacciServiceUtils() {
    throw new IllegalStateException("Utility class");
  }

  /** Validate that arguement passed is an integer. */
  public static void validateInteger(final String fibonacciIndex)
      throws FibonacciIndexWrongTypeException {

    Exception parseException = null;

    try {
      Integer.parseInt(fibonacciIndex);
    } catch (NumberFormatException formatException) {
      parseException = formatException;
    }

    if (parseException != null) {
      throw new FibonacciIndexWrongTypeException();
    }
  }

  /** Validate that arguement passed is an integer between 0 and 75. */
  public static void validateIntegerIndexBounds(final int fibonacciIndex)
      throws FibonacciIndexOutOfBoundsException {

    if (fibonacciIndex < 0 || fibonacciIndex > 75) {
      throw new FibonacciIndexOutOfBoundsException();
    }
  }
}
