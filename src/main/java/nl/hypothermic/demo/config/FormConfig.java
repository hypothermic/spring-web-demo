package nl.hypothermic.demo.config;

import nl.hypothermic.demo.api.model.Form;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormConfig {

    @Bean
    public Form getForm() {
        return new Form();
    }
}
