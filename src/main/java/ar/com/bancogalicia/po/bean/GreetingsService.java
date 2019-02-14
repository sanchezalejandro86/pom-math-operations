package ar.com.bancogalicia.po.bean;

import ar.com.bancogalicia.po.model.Greetings;

/**
 * Service interface for name bean.
 * 
 */
public interface GreetingsService {

    /**
     * Generate Greetings
     *
     * @return a string greetings
     */
    Greetings getGreetings(String name);

}