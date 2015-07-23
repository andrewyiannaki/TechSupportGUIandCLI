package com.dodgysoft.techsupport.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Dionisis Dimakopoulos
 */
public class KeyBasedResponsesRetriever
{
    private HashMap<String, String> responseMap;
    public static final String KEYWORD_RESPONSES_PATH="staticdata/keywordResponses.properties";
    
    public KeyBasedResponsesRetriever()
    {
        responseMap = new HashMap<String, String>();
        readResponseMap();
    }
    
    private void readResponseMap()
    {
        Properties props = new Properties();
        try
        {
            InputStream keywordResponsesStream = getClass().getResourceAsStream(KEYWORD_RESPONSES_PATH);
            props.load(new InputStreamReader(keywordResponsesStream));
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
            fillResponseMap();
        }
        finally
        {
            if(!props.isEmpty())
            {
                for(Object key:props.keySet())
                {
                    responseMap.put(key.toString(), props.getProperty(key.toString()));
                }
            }
        }
    }

    /**
     * Enter all the known keywords and their associated responses
     * into our response map.
     */
    private void fillResponseMap()
    {
        responseMap.put("crash", 
                        "Well, it never crashes on our system. It must have something\n" +
                        "to do with your system. Tell me more about your configuration.");
        responseMap.put("crashes", 
                        "Well, it never crashes on our system. It must have something\n" +
                        "to do with your system. Tell me more about your configuration.");
        responseMap.put("slow", 
                        "I think this has to do with your hardware. Upgrading your processor\n" +
                        "should solve all performance problems. Have you got a problem with\n" +
                        "our software?");
        responseMap.put("performance", 
                        "Performance was quite adequate in all our tests. Are you running\n" +
                        "any other processes in the background?");
        responseMap.put("bug", 
                        "Well, you know, all software has some bugs. But our software engineers\n" +
                        "are working very hard to fix them. Can you describe the problem a bit\n" +
                        "further?");
        responseMap.put("buggy", 
                        "Well, you know, all software has some bugs. But our software engineers\n" +
                        "are working very hard to fix them. Can you describe the problem a bit\n" +
                        "further?");
        responseMap.put("windows", 
                        "This is a known bug to do with the Windows operating system. Please\n" +
                        "report it to Microsoft. There is nothing we can do about this.");
        responseMap.put("macintosh", 
                        "This is a known bug to do with the Mac operating system. Please\n" +
                        "report it to Apple. There is nothing we can do about this.");
        responseMap.put("expensive", 
                        "The cost of our product is quite competitive. Have you looked around\n" +
                        "and really compared our features?");
        responseMap.put("installation", 
                        "The installation is really quite straight forward. We have tons of\n" +
                        "wizards that do all the work for you. Have you read the installation\n" +
                        "instructions?");
        responseMap.put("memory", 
                        "If you read the system requirements carefully, you will see that the\n" +
                        "specified memory requirements are 1.5 giga byte. You really should\n" +
                        "upgrade your memory. Anything else you want to know?");
        responseMap.put("linux", 
                        "We take Linux support very seriously. But there are some problems.\n" +
                        "Most have to do with incompatible glibc versions. Can you be a bit\n" +
                        "more precise?");
        responseMap.put("bluej", 
                        "Ahhh, BlueJ, yes. We tried to buy out those guys long ago, but\n" +
                        "they simply won't sell... Stubborn people they are. Nothing we can\n" +
                        "do about it, I'm afraid.");
    }
    
    public HashMap<String, String> getResponses()
    {
        return responseMap;
    }
}
