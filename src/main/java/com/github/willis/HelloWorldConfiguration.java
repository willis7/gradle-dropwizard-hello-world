package com.github.willis;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * @author Sion Williams
 */
public class HelloWorldConfiguration extends Configuration {
    @JsonProperty
    private String message;

    @JsonProperty
    private int messageRepetitions;

    public String getMessage() {
        return message;
    }

    public int getMessageRepetition() {
        return messageRepetitions;
    }
}
