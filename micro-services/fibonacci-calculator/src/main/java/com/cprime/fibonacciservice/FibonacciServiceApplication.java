package com.cprime.fibonacciservice;

import com.cprime.fibonacciservice.exceptions.FibonacciIndexOutOfBoundsException;
import com.cprime.fibonacciservice.exceptions.FibonacciIndexWrongTypeException;
import com.cprime.fibonacciservice.health.FibonacciServiceStatus;
import com.cprime.fibonacciservice.utils.FibonacciServiceUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Boot Aplication to serve the fibonacci calculator REST microservice.
 *
 * @author @devopskev
 */
@SpringBootApplication
@RestController
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class FibonacciServiceApplication {

  /** Default contructor. */
  public static void main(final String[] args) {
    SpringApplication.run(FibonacciServiceApplication.class, args);
  }

  /** Add cors mappings. */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/").allowedOrigins("*");
        registry.addMapping("/**").allowedOrigins("*");
      }
    };
  }

  /** Request handler for root http requests. */
  @GetMapping
  public FibonacciServiceStatus root() {
    return new FibonacciServiceStatus();
  }

  /** Request handler for /health http requests. */
  @GetMapping(path = "/health")
  public FibonacciServiceStatus health() {
    return new FibonacciServiceStatus();
  }

  /** Request handler for /fibonacci/ http requests. */
  @GetMapping(path = "/fibonacci/{fibonacciIndex}")
  public FibonacciNumber fibonacci(final @PathVariable("fibonacciIndex") String fibonacciIndex)
      throws FibonacciIndexOutOfBoundsException, FibonacciIndexWrongTypeException {

    FibonacciServiceUtils.validateInteger(fibonacciIndex);

    return FibonacciCalculator.calculateFiboacciNumberByIndex(Integer.parseInt(fibonacciIndex));
  }
}
