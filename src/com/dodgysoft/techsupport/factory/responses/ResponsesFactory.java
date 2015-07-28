/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodgysoft.techsupport.factory.responses;

import com.dodgysoft.techsupport.model.*;

/**
 *
 * @author Andrew
 */
public class ResponsesFactory {
    public static DefaultResponsesRetriever getDefaultResponseRetriever()
    {
        return new DefaultResponsesRetriever();
    }
    
    public static KeyBasedResponsesRetriever getKeyBasedResponsesRetriever()
    {
        return new KeyBasedResponsesRetriever();
    }
}
