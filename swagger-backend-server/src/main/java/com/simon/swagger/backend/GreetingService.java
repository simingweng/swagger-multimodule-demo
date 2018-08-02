package com.simon.swagger.backend;

import com.simon.swagger.backend.api.BackendApiDelegate;
import com.simon.swagger.backend.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementation of the backend service. It only logs whatever greeting text it receives from its RESTful API
 */
@Service
public class GreetingService implements BackendApiDelegate {
    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    /**
     * log the greeting text and return 200 OK
     *
     * @param greeting the greeting
     * @return 200 OK
     */
    @Override
    public ResponseEntity<Void> addGreeting(Greeting greeting) {
        logger.info("{} is received and added to backend", greeting.getText());
        return ResponseEntity.ok(null);
    }
}
