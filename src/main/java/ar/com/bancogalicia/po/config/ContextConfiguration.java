package ar.com.bancogalicia.po.config;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

@Configuration
public class ContextConfiguration {
    @Value("${calculator.endpoint.address}")
    private String endpointAddress;
    @Value("${calculator.endpoint.wsdl-url}")
    private String endpoWsdlURL;
    @Value("${calculator.endpoint.operation-name}")
    private String endpointOperationName;
    @Value("${calculator.endpoint.user}")
    private String endpointUser;
    @Value("${calculator.endpoint.password}")
    private String endpointPassword;


    @Bean("cxfEndpoint")
    public CxfEndpoint cxfEndpoint(){
        CxfEndpoint endpoint = new CxfEndpoint();
        endpoint.setAddress(endpointAddress);
        endpoint.setWsdlURL(endpoWsdlURL);
        endpoint.setServiceClass(CalculatorSoap.class);
        endpoint.setDefaultOperationName(endpointOperationName);
        endpoint.setUsername(endpointUser);
        endpoint.setPassword(endpointPassword);
        endpoint.setSynchronous(true);

        return endpoint;
    }

}
