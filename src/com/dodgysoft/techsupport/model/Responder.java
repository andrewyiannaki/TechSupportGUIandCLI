package com.dodgysoft.techsupport.model;

import java.io.*;
import java.util.*;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the responder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognised, one of the default responses is randomly chosen.
 * 
 * @version    1.0
 * @author     Michael Kolling, David J. Barnes and Dionisis Dimakopoulos
 */
public class Responder
{
//    public static final String MAP_RESPONSES_URL="http://www.staff.city.ac.uk/~ddimak/Java2/files/keywordResponses.properties";
//    public static final String MAP_RESPONSES_URL="http://www.staff.city.ac.uk/~ddimak/Java2/files/delaykeyword.properties.php";
//    public static final String DEFAULT_RESPONSES_URL="http://www.staff.city.ac.uk/~ddimak/Java2/files/delayDefaultResponse.php";
    
    
    // Used to map key words to responses.
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        KeyBasedResponsesRetriever keyBasedRetriever = new KeyBasedResponsesRetriever();
        responseMap = keyBasedRetriever.getResponses();
        DefaultResponsesRetriever defRetriever = new DefaultResponsesRetriever();
        defaultResponses = defRetriever.getDefaultResponses();//new ArrayList<String>();
        randomGenerator = new Random();
    }

    /**
     * Generate a response from a given set of input words.
     * 
     * @param words  A set of words entered by the user
     * @return       A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String word = it.next();
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        // If we get here, none of the words from the input line was recognized.
        // In this case we pick one of our default responses (what we say when
        // we cannot think of anything else to say...)
        return pickDefaultResponse();//pickDefaultResponseFromWeb();
    }
    
    

    
    
//    private void readResponseMapFromWeb()
//    {
//        Properties props = new Properties();
//        //We need access to the stream content of   //raw bytes
//        URL url = null;
//        try 
//        {
//            url = new URL(MAP_RESPONSES_URL);
//            props.load(url.openStream());
//        }
//        catch(MalformedURLException e) {}
//        catch(IOException e) { e.printStackTrace(); }
//        responseMap = new HashMap<String, String>((Map) props);
//    }
    
    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
    
//    private String pickDefaultResponseFromWeb()
//    {
//        URL url = null;
//        String response="";
//        try
//        {
//            url = new URL(DEFAULT_RESPONSES_URL);
//            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//            response=in.readLine();
//            in.close();
//        }
//        catch(MalformedURLException e)
//        {
//            e.printStackTrace();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        return response;
//    }

}
