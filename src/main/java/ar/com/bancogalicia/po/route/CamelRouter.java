package ar.com.bancogalicia.po.route;

import ar.com.bancogalicia.po.model.Greetings;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel REST DSL route that implement the greetings bean.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {

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
        
        rest("/greetings/").description("Greeting to {name}")
            .get("/{name}").outType(Greetings.class)
                .route().routeId("greeting-api")
                .to("direct:greetingsImpl");

        from("direct:greetingsImpl")
                .streamCaching()
                .to("bean:greetingsService?method=getGreetings");
    }

}