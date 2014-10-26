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

    /**
     * This is a default message, so if nothing is set in the config.yml this will be used.
     */
    @JsonProperty
    private String additionalMessage = "This is optional";

    public String getMessage() {
        return message;
    }

    public int getMessageRepetition() {
        return messageRepetitions;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }
}
