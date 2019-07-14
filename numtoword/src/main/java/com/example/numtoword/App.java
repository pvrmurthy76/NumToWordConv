package com.example.numtoword;

import com.example.numtoword.service.NumToWordConvert;
import com.example.numtoword.service.NumToWordConvertImpl;

/**
 * Convert To Word main class
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	NumToWordConvert util = new NumToWordConvertImpl();
    	System.out.println(util.convertToWord(56));
    	System.out.println(util.convertToWord(56945781));
    	System.out.println(util.convertToWord(999999999));
    }
}
