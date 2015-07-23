package com.dodgysoft.techsupport.cli.view;

import com.dodgysoft.techsupport.model.AppConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. Uses a
 * PropertyChangeSupport object to notify for the new input entered by the user.
 * 
 * @author     Michael Kolling, David J. Barnes and Dionisis Dimakopoulos
 * @version    1.0
 */
public class InputReader
{
    private Scanner reader;
    public static final String PROMPT = "> ";

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void fire(String propertyName, Object old, Object nue)
    {
        propertyChangeSupport.firePropertyChange(propertyName, old, nue);
    }
    
    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and notify the observers of the new input entered by the user.
     */
    public void getInput() 
    {
        System.out.print(PROMPT);                // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();
        fire(AppConstants.ACTION_USER_INPUT,null,inputLine);
    }
}
