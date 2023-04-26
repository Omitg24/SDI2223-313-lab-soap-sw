package com.uniovi.sdi.services;
import com.uniovi.sdi.wsdl.GetMarksRequest;
import com.uniovi.sdi.wsdl.GetMarksResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
public class MarksSoapService extends WebServiceGatewaySupport {
    @Value("${service.endpoint}")
    private String serviceEndpoint;
    @Value("${service.soap.action}")
    private String serviceSoapAction;
    public GetMarksResponse getMarks(String dni) {
        GetMarksRequest request = new GetMarksRequest();
        request.setDni(dni);
        return (GetMarksResponse)
                getWebServiceTemplate().marshalSendAndReceive(serviceEndpoint,
                        request, new SoapActionCallback(serviceSoapAction));
    }
}