package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.exceptions.FibonacciIndexOutOfBoundsException;
import com.cprime.fibonacciservice.utils.FibonacciServiceUtils;

/**
 * Calculates a fidonacci number given an index between 0 and 75.
 *
 * @author @devopskev
 */
final class FibonacciCalculator {

  /** An index of 0 or 1 returns a fibonacci value of 0 so no need to calculate. */
  private static final int MIN_CALC_INDEX = 1;

  private FibonacciCalculator() {
    throw new IllegalStateException("Utility class");
  }

  /** Calculates a fidonacci number given an index between 0 and 75. */
  public static FibonacciNumber calculateFiboacciNumberByIndex(final int fibonacciIndex)
      throws FibonacciIndexOutOfBoundsException {

    FibonacciServiceUtils.validateIntegerIndexBounds(fibonacciIndex);

    final FibonacciNumber fibonacciNumber = new FibonacciNumber();

    if (fibonacciIndex <= MIN_CALC_INDEX) {
      fibonacciNumber.setFibonacciValue(fibonacciIndex);
      fibonacciNumber.setFibonacciIndex(fibonacciIndex);
    } else {

      long[] fibNums = new long[fibonacciIndex + 1];
      fibNums[0] = 0;
      fibNums[1] = 1;
      for (int index = 2; index <= fibonacciIndex; index++) {
        fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
      }

      fibonacciNumber.setFibonacciValue(fibNums[fibonacciIndex]);
      fibonacciNumber.setFibonacciIndex(fibonacciIndex);
    }

    return fibonacciNumber;
  }
}
