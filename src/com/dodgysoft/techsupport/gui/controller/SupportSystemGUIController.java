package com.dodgysoft.techsupport.gui.controller;

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

    public SupportSystemGUIController()
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
