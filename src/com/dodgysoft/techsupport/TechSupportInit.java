package com.dodgysoft.techsupport;

import com.dodgysoft.techsupport.cli.SupportSystemCLIController;
import com.dodgysoft.techsupport.gui.controller.SupportSystemGUIController;
/**
 *
 * @author Dionisis Dimakopoulos
 */
public class TechSupportInit {

    /**
     * Starts the application using the correct view (UI or CLI)
     * depending on the first argument passed. If the argument is --cli it starts
     * the CLI. If there is no argument it starts the GUI. If the argument
     * passed is --help then it shows the help file.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        if(args.length>0)
        {
            if("--cli".equals(args[0]))
            {
                //start the CLI
                new SupportSystemCLIController().start();
            }
            else if("--help".equals(args[0]))
            {
                //show help on the command line
                System.out.println("DodgySoft Technical Support System");
                System.out.println("Help");
                System.out.println("");
                System.out.println("This software launches the technical support "+
                                   "system. If called without command line arguments "+
                                   "the graphical user interface will launch.");
                System.out.println("--cli \t starts the command line interface");
                System.out.println("--help \t shows this information");
            }
        }
        else
        {
            //start the GUI
            new SupportSystemGUIController().start();
        }
    }
}
