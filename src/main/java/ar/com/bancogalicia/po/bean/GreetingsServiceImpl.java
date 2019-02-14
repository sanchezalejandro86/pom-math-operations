package ar.com.bancogalicia.po.bean;

import org.apache.camel.Header;
import org.springframework.stereotype.Service;
import ar.com.bancogalicia.po.model.Greetings;

@Service("greetingsService")
public class GreetingsServiceImpl implements GreetingsService {

    private static final String THE_GREETINGS = "Hello, ";

    @Override
    public Greetings getGreetings(@Header("name") String name ) {
        return new Greetings( THE_GREETINGS + name );
    }

}