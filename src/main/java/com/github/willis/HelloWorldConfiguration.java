package com.github.willis;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

/**
 * @author Sion Williams
 */
public class HelloWorldConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty

    @Max( 10 )
    private int messageRepetitions;

    public String getMessage() {
        return message;
    }

    public int getMessageRepetition() {
        return messageRepetitions;
    }
}
