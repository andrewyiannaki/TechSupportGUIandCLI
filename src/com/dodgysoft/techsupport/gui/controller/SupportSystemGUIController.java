package com.dodgysoft.techsupport.gui.controller;

import com.dodgysoft.techsupport.cli.SupportSystemCLIController;
import com.dodgysoft.techsupport.controller.InputHandler;
import com.dodgysoft.techsupport.controller.SupportSystem;
import com.dodgysoft.techsupport.gui.view.SupportSystemUI;

/**
 *
 * @author Dionisis Dimakopoulos
 */
public class SupportSystemGUIController extends SupportSystem
{

    private SupportSystemUI ui;
    private UIController uiControl;
    private InputHandler handler;
    
    //a private static field that hold the ONLY instance of this class
    private static SupportSystemGUIController instance;

    /**
     * Creates the SupportSystem GUI and GUI controller.
     * 
     * the constructor is private to fit the singleton design pattern
     */
    private SupportSystemGUIController()
    {
        super();
        ui = new SupportSystemUI();
        uiControl = new UIController(ui);
        ui.addBtnSendActionListener(uiControl);
        ui.addTxtInputKeyListener(uiControl);
        
        handler = new InputHandler();
        uiControl.addPropertyChangeListener(handler);
        handler.addPropertyChangeListener(this);
    }
    
    /**
     * getInstance() Gets an instance of this class. Requirement of the Singleton
     * design pattern
     * 
     * @return An instance of SupportSystemGUIController
     */
    public static SupportSystemGUIController getInstance()
    {
        if (instance == null)
        {
            instance = new SupportSystemGUIController();
        }
        
        return instance;
    }

    @Override
    public void start()
    {
        java.awt.EventQueue.invokeLater(
            new Runnable()
            {
                public void run()
                {
                    ui.setVisible(true);
                }
            });
        printWelcome();
    }

    @Override
    protected void print(final String txt)
    {
        java.awt.EventQueue.invokeLater(
            new Runnable()
            {
                public void run()
                {
                    ui.appendText(txt);
                }
        });
    }
}
