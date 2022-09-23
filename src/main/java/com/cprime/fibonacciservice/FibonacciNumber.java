package com.cprime.fibonacciservice;

/**
 * Object to represent a fidonacci number and its index in the fibonacci sequence.
 *
 * @author @devopskev
 */
@SuppressWarnings({"PMD.DataClass", "PMD.AtLeastOneConstructor"})
public class FibonacciNumber {

  /** Index of this number in the fibonacci sequence. */
  private long fibonacciIndex;
  /** The value of this fibonacci number. */
  private long fibonacciValue;

  public long getFibonacciIndex() {
    return fibonacciIndex;
  }

  public void setFibonacciIndex(final long index) {
    this.fibonacciIndex = index;
  }

  public long getFibonacciValue() {
    return fibonacciValue;
  }

  public void setFibonacciValue(final long fibValue) {
    this.fibonacciValue = fibValue;
  }
}
