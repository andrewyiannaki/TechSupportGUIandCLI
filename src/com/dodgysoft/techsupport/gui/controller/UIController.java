package com.dodgysoft.techsupport.gui.controller;

import com.dodgysoft.techsupport.gui.view.SupportSystemUI;
import com.dodgysoft.techsupport.model.AppConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A controller of the UI that listens for mouse clicks and keyboard usage.
 * @author Dionisis Dimakopoulos
 */
public class UIController implements ActionListener, KeyListener
{
    private SupportSystemUI ui;
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
    
    public UIController(SupportSystemUI ui)
    {
        this.ui=ui;
    }

    
    
    /*
     ************************************
     * 
     * All methods below run on the EDT
     * 
     ************************************ 
     */
    
    /**
     * Listens for the click event of the button Send 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if("Send".equals(e.getActionCommand()))
        {
            processInput();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //Not used
    }

    /**
     * Listens for the Return key pressed in the input text field.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==e.VK_ENTER)
        {
            processInput();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //Not used
    }
    
    /**
     * Retrieves the input from the UI and informs that new user input has been
     * entered.
     */
    public void processInput()
    {
        final String inputLine = ui.getInput();
        if(!inputLine.isEmpty())
        {
            ui.appendInput(true); 
            fire(AppConstants.ACTION_USER_INPUT,null, inputLine);
        }
    }
}
