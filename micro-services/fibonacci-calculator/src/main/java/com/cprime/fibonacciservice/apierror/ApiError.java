package com.cprime.fibonacciservice.apierror;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

/**
 * Handle custom errors to provide meaningful error responses to API consumers.
 *
 * @author @devopskev
 */
@SuppressWarnings("PMD.DataClass")
public class ApiError {

  /** Status of the http request. */
  private final HttpStatus status;
  /** Timestamo for when the error was thrown. */
  private final LocalDateTime timestamp;
  /** Meaningful message for the error. */
  private final String message;
  /** Meaningful debug message for the error. */
  private final String debugMessage;

  public HttpStatus getStatus() {
    return status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDebugMessage() {
    return debugMessage;
  }

  /** Handle custom errors to provide meaningful error responses to API consumers */
  public ApiError(
      final HttpStatus status, final String message, final Throwable internalException) {
    this.status = status;
    this.message = message;
    this.debugMessage = internalException.getLocalizedMessage();
    this.timestamp = LocalDateTime.now();
  }
}
