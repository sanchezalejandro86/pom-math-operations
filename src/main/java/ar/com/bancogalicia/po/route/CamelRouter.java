package ar.com.bancogalicia.po.route;

import ar.com.bancogalicia.po.api.model.OperationResult;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.tempuri.AddResponse;

import java.math.BigDecimal;

/**
 * A simple Camel REST DSL route that implement the greetings bean.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        JacksonDataFormat operationResults = new JacksonDataFormat(OperationResult.class);
        operationResults.disableFeature(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        restConfiguration()
                .apiContextPath("/api-docs")
                .apiProperty("api.title", "pom-math-operations")
                .apiProperty("api.description", "REST API exposed by Springboot & Fuse compatible with RHOAR")
                .apiProperty("api.version", "1.0-SNAPSHOT")
                .apiProperty("cors", "true")
                .apiProperty("base.path", "camel/")
                .apiProperty("api.path", "/")
                .apiProperty("host", "")
                .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json);
        
        from("activemq:queue:math/calculate")
                .routeId("WebserviceRoute")
                .log("Lei de la cola: ${body}" )
                //.unmarshal(operationResults)
                .unmarshal().json(JsonLibrary.Jackson, OperationResult.class)
                .log("Objeto Unmarsalled: ${body}" )
                .to("bean:calculatorService?method=generateAddRequest")
                .log("Calling WebService Calculator...")
                .to("cxf:bean:cxfEndpoint")
                .log("Processing WebService Response... ${body}")
                .process(exchange -> {
                    Integer addResponse = exchange.getIn().getBody(Integer.class);
                    OperationResult o = exchange.getProperty("result", OperationResult.class);
                    o.setResult(BigDecimal.valueOf(addResponse));
                    exchange.getIn().setBody(o);
                })
                .marshal().json(JsonLibrary.Jackson)
                .to(ExchangePattern.InOnly, "activemq:queue:math/operations");
    }

}
