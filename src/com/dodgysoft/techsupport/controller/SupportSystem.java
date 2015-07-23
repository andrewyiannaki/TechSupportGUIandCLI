package com.dodgysoft.techsupport.controller;

import com.dodgysoft.techsupport.model.AppConstants;
import com.dodgysoft.techsupport.model.Responder;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;

/**
 *
 * @author Dionisis Dimakopoulos
 */
public abstract class SupportSystem implements PropertyChangeListener
{
    private Responder responder;
    private static SupportSystem instance;
    
    public SupportSystem()
    {
        responder = new Responder();
    }
    
    /**
     * Called when the application starts.
     */
    public abstract void start();
    
    /**
     * Redirects the text to the selected output
     * @param txt The text to be shown/printed
     */
    protected abstract void print(String txt);
    
    /**
     * Print a welcome message to the screen.
     */
    protected void printWelcome()
    {
        println("Welcome to the DodgySoft Technical Support System.");
        println("");
        println("Please tell us about your problem.");
        println("We will assist you with any problem you might have.");
        println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    protected void printGoodbye()
    {
        println("Nice talking to you. Bye...");
    }    
    
    /** 
     * Helper method that adds a new line after the text to be printed/shown
     * @param txt The text to be printed/shown
     */
    protected void println(String txt)
    {
        print(txt + System.getProperty("line.separator"));
    }

    /**
     * Helper method to print/show an empty new line.
     */
    {
        println("");
    }

    /**
     * Listens for an AppConstants.INPUT_WORDS_GENERATED message and decides 
     * what to do next, whether to end the conversation or to send a new response.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (AppConstants.INPUT_WORDS_GENERATED.equals(evt.getPropertyName()))
        {
            HashSet<String> input = (HashSet<String>) evt.getNewValue();
            if (input.contains("bye"))
            {
                printGoodbye();
            } 
            else
            {
                String response = responder.generateResponse(input);
                println(response);
                doAfterResponse();
            }
        }
    }
    
    /**
     * Is called after a response is shown to the user. No need to override if
     * nothing needs to be done after the response is shown.
     */
    public void doAfterResponse()
    {
    }
}
