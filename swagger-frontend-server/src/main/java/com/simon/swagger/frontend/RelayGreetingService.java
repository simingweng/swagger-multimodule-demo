package com.simon.swagger.frontend;

import com.simon.swagger.backend.client.api.BackendApi;
import com.simon.swagger.frontend.api.FrontendApiDelegate;
import com.simon.swagger.frontend.model.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementation of the front end service. It receives a conversation via its RESTful API and relay the greeting text portion of the conversation to the backend service
 */
@Service
public class RelayGreetingService implements FrontendApiDelegate {

    private BackendApi backendApi;

    @Autowired
    public RelayGreetingService(BackendApi backendApi) {
        this.backendApi = backendApi;
        /*
          usually the base path would be externalized as start up parameters if we rely on external service discovery mechanism such as Kubernetes, or if client side load balancing mechanism, such as Ribbon and Eureka, is used, we can also generate Feign-based client library
         */
        backendApi.getApiClient().setBasePath("http://localhost:9090");
    }


    /**
     * pass the greeting text onto backend service
     *
     * @param conversation a conversation
     * @return 200 OK
     */
    @Override
    public ResponseEntity<Void> addConversation(Conversation conversation) {
        backendApi.addGreeting(conversation.getGreet());
        return ResponseEntity.ok(null);
    }
}
