/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodgysoft.techsupport.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Dionisis Dimakopoulos
 */
public class DefaultResponsesRetriever
{
    public static final String DEFAULT_RESPONSES_PATH="staticdata/defaultResponses";
    private ArrayList<String> defaultResponses;
    
    public DefaultResponsesRetriever()
    {
        defaultResponses = new ArrayList<String>();
        readDefaultResponses();
    }
    
    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("No other customer has ever complained about this before. \n" +
                             "What is your system configuration?");
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                             "there with you who could describe this more precisely?");
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }
    
    private void readDefaultResponses()
    {
        BufferedReader br = null;
        try
        {
            InputStream defaultResponsesStream = getClass().getResourceAsStream(DEFAULT_RESPONSES_PATH);
            br = new BufferedReader(new InputStreamReader(defaultResponsesStream));
            
            String line = br.readLine();
            while(line!=null)
            {
                defaultResponses.add(line);
                line = br.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            fillDefaultResponses();
        }
        finally
        {
            try { br.close(); } catch(IOException e) {e.printStackTrace();}
        }
    }
    
    public ArrayList<String> getDefaultResponses()
    {
        return defaultResponses;
    }
}
