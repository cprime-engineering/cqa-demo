package com.cprime.fibonacciservice.health;

/**
 * Service health status handler.
 *
 * @author @devopskev
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class FibonacciServiceStatus {

  /** For this example always return status up and let server handle other errors. */
  /* default */ static final String STATUS = "UP";

  /** Return the health status of the fibonaccu service. */
  public String getStatus() {
    return STATUS;
  }
}
