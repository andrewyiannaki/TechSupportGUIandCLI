/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodgysoft.techsupport.factory.ui;

import com.dodgysoft.techsupport.cli.view.*;
import com.dodgysoft.techsupport.gui.view.*;

/**
 *
 * @author Andrew
 */
public class UIFactory {
    public static InputReader getInputReader()
    {
        return new InputReader();
    }
    
    public static SupportSystemUI getSupportSystemUI()
    {
        return new SupportSystemUI();
    }
}
