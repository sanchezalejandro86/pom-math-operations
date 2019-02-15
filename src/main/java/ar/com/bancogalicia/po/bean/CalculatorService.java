package ar.com.bancogalicia.po.bean;

import org.apache.camel.Exchange;
import org.tempuri.Add;

import java.util.List;

/**
 * Service interface for name bean.
 * 
 */
public interface CalculatorService {

    /**
     * Generate Greetings
     *
     * @return a string greetings
     */
    List<Integer> generateAddRequest(Exchange exchange);


}
