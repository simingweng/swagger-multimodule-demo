package com.simon.swagger.frontend;

import com.simon.swagger.backend.client.api.BackendApi;
import com.simon.swagger.backend.model.Greeting;
import com.simon.swagger.frontend.api.FrontendApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RelayGreetingService implements FrontendApiDelegate {

    private BackendApi backendApi;

    @Autowired
    public RelayGreetingService(BackendApi backendApi) {
        this.backendApi = backendApi;
    }

    @Override
    public ResponseEntity<Void> addGreeting(Greeting greeting) {
        backendApi.addGreeting(greeting);
        return ResponseEntity.ok(null);
    }
}
