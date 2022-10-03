package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.apierror.ApiError;
import com.cprime.fibonacciservice.exceptions.FibonacciIndexOutOfBoundsException;
import com.cprime.fibonacciservice.exceptions.FibonacciIndexWrongTypeException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handle custom exceptions to provide meaningful error responses to API consumers.
 *
 * @author @devopskev
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.CommentSize"})
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Object> buildResponseEntity(final ApiError apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  /**
   * Handle wrong type of object being passed to API such as a string that can not be parsed to an
   * integer.
   */
  @ExceptionHandler(FibonacciIndexWrongTypeException.class)
  protected ResponseEntity<Object> handleIndexWrongType(
      final FibonacciIndexWrongTypeException typeException) {
    final ApiError apiError =
        new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, typeException.getMessage(), typeException);
    return buildResponseEntity(apiError);
  }

  /**
   * Handle indexes that fall outside the range this API can handle these are values below 0 and
   * above 75.
   */
  @ExceptionHandler(FibonacciIndexOutOfBoundsException.class)
  protected ResponseEntity<Object> handleIndexOutOfBounds(
      final FibonacciIndexOutOfBoundsException indexException) {
    final ApiError apiError =
        new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, indexException.getMessage(), indexException);
    return buildResponseEntity(apiError);
  }
}
