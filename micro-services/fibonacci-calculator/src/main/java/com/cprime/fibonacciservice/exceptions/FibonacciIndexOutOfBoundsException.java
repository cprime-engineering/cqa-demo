package com.cprime.fibonacciservice.exceptions;

/**
 * Error to thrown when a requested fibonacci index falls outside the bounds that can be calculated
 * by this service.
 *
 * @author @devopskev
 */
@SuppressWarnings("PMD.CommentSize")
public class FibonacciIndexOutOfBoundsException extends Exception {

  public static final long serialVersionUID = 42L;

  /** Default constructor. */
  public FibonacciIndexOutOfBoundsException() {
    super(
        "The minimum index this service can calculate a Fibonacci number for is '0' and maximum"
            + " index this service can calculate a Fibonacci number for is '75'.");
  }
}
