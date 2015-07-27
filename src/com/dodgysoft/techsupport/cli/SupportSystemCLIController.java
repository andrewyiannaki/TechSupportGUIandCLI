package com.dodgysoft.techsupport.cli;

import com.dodgysoft.techsupport.cli.view.InputReader;
import com.dodgysoft.techsupport.controller.InputHandler;
import com.dodgysoft.techsupport.controller.SupportSystem;
import com.dodgysoft.techsupport.factory.ui.UIFactory;

/**
 * This class implements the controller of the CLI (Command Line Interface) 
 * environment of the technical support system. The support system communicates 
 * via text input/output in the text terminal.
 *
 * This class uses an object of class InputReader to read input from the user,
 * and an object of class InputHandler to process the user input. Using the 
 * method doAfterResponse the system is looping by asking the user to type 
 * another input after a response is given.
 *
 * @author Michael Kolling, David J. Barnes and Dionisis Dimakopoulos
 * @version 1.0
 */
public class SupportSystemCLIController extends SupportSystem
{

    private InputReader reader;
    private InputHandler handler;
    
    //a private static field that hold the ONLY instance of this class
    private static SupportSystemCLIController instance;

    /**
     * Creates the InputReader and InputHandler objects and plugs the InputHandler
     * to listen to InputReader messages.
     * 
     * the constructor is private to fit the singleton design pattern
     */
    private SupportSystemCLIController()
    {
        super();
        //reader = new InputReader();
        reader = UIFactory.getInputReader();
        handler = new InputHandler();
        reader.addPropertyChangeListener(handler);
        handler.addPropertyChangeListener(this);
    }
    
    /**
     * getInstance() Gets an instance of this class. Requirement of the Singleton
     * design patter
     * 
     * @return An instance of SupportSystemCLIController
     */
    public static SupportSystemCLIController getInstance()
    {
        if (instance == null)
        {
            instance = new SupportSystemCLIController();
        }
        
        return instance;
    }

    /**
     * Start the technical support system. This will print a welcome message and
     * enter into a dialog with the user.
     */
    @Override
    public void start()
    {
        printWelcome();
        reader.getInput();
    }

    
    /**
     * An implementation of the print abstract method in SupportSystem. Plugs 
     * the export to the System.out
     * @param txt The text to be printed
     */
    @Override
    protected void print(String txt)
    {
        System.out.print(txt);
    }

    /**
     * Is called after a response is given to the user.
     */
    @Override
    public void doAfterResponse()
    {
        reader.getInput();
    }
}
