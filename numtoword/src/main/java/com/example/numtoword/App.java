package com.example.numtoword;

import com.example.numtoword.util.TranslateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TranslateUtil util = new TranslateUtil();
    	System.out.println(util.translateToWords(56));
    	System.out.println(util.translateToWords(56945781));
    	System.out.println(util.translateToWords(999999999));
    }
}
