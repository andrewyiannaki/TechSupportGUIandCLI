package com.dodgysoft.techsupport.controller;

import com.dodgysoft.techsupport.model.AppConstants;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.HashSet;

/**
 * A controller that breaks down the input received by the user.
 * It is notified by a call from a PropertyChangeSupport object when
 * new input is entered by the user. 
 * @author Dionisis Dimakopoulos
 */
public class InputHandler implements PropertyChangeListener
{
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
    
    public InputHandler()
    {
        // nothing to initialise
    }

    /**
     * Listens to AppConstants.ACTION_USER_INPUT events and processes the input
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if(AppConstants.ACTION_USER_INPUT.equals(evt.getPropertyName()))
        {
            String input = (String) evt.getNewValue();
            processInput(input);
        }
    }
    
    private void processInput(String inputLine)
    {
        String[] wordArray = inputLine.split(" ");  // split at spaces

        // add words from array into hashset 
        HashSet<String> words = new HashSet<String>();
        words.addAll(Arrays.asList(wordArray));
        fire(AppConstants.INPUT_WORDS_GENERATED, null, words);
    }
    
}
