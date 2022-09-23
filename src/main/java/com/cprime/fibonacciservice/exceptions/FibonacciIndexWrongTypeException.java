package com.cprime.fibonacciservice.exceptions;

/**
 * Error to thrown when a requested fibonacci index can not be parsed to an integer.
 *
 * @author @devopskev
 */
@SuppressWarnings("PMD.CommentSize")
public class FibonacciIndexWrongTypeException extends Exception {

  public static final long serialVersionUID = 42L;

  /** Error to thrown when a requested fibonacci index can not be parsed to an integer. */
  public FibonacciIndexWrongTypeException() {
    super("Index value must be an integer.");
  }
}
