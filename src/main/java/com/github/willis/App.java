package com.github.willis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Sion Williams
 */
public class App extends Application<HelloWorldConfiguration>{
    private static final Logger LOGGER = LoggerFactory.getLogger( App.class );

    @Override
    public void initialize( Bootstrap<HelloWorldConfiguration> bootstrap ) {

    }

    @Override
    public void run( HelloWorldConfiguration configuration, Environment environment ) throws Exception {
        LOGGER.info( "Method App#run() called" );
        System.out.println( "Hello World, by Dropwizard!" );
        for ( int i=0; i < configuration.getMessageRepetition(); i++ ) {
            System.out.println( configuration.getMessage() );
        }
    }

    public static void main( String[] args ) throws Exception {
        new App().run( args );
    }
}
