package com.example.demo;

import localhost._8080.webservice.GetGuestRequest;
import localhost._8080.webservice.GetGuestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GuestEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/webservice";

    private GuestRepository guestRepository;

    @Autowired
    public GuestEndpoint(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGuestRequest")
    @ResponsePayload
    public GetGuestResponse getGuest(@RequestPayload GetGuestRequest request){
        GetGuestResponse response = new GetGuestResponse();
        response.setGuest(guestRepository.findGuest(request.getName()));

        return response;
    }

}
