package com.uniovi.sdi.endpoints;

import com.uniovi.sdi.repositories.MarksRepository;
import com.uniovi.sdi.soap.ws.GetMarksRequest;
import com.uniovi.sdi.soap.ws.GetMarksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MarksEndpoint {
    private static final String NAMESPACE_URI = "http://uniovi.com/sdi/soap/ws";
    private final MarksRepository marksRepository;

    @Autowired
    public MarksEndpoint(MarksRepository markRepository) {
        this.marksRepository = markRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMarksRequest")
    @ResponsePayload
    public GetMarksResponse getMarks(@RequestPayload GetMarksRequest request) {
        GetMarksResponse response = new GetMarksResponse();
        response.setUser(marksRepository.findAllByUser(request.getDni()));
        return response;
    }
}