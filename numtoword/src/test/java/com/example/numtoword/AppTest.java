package com.example.numtoword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.numtoword.util.TranslateUtil;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	TranslateUtil util = new TranslateUtil();
	
    @Test
	public void getWordFormatForCorrectNumber() {
		int numVal = 1234;
		assertEquals("One Thousand Two Hundred and Thirty Four ", util.translateToWords(numVal));
	}
    
    @Test
	public void validateInputLength() {
		int numVal = 1234567890;
		String resp = util.translateToWords(numVal);
		assertTrue(resp.contains("error"));
	}
   
    @Test
	public void validateNegativeNumbers() {
		int numVal = -12345678;
		String resp = util.translateToWords(numVal);
		assertTrue(resp.contains("error"));
	}
    
    @Test
    public void validateSingleDigits() {
    	int numVal = 1;
    	assertEquals("One ", util.translateToWords(numVal));
    }
    
    @Test
    public void validateForZero() {
    	int numVal = 0000000;
    	assertEquals("Zero ", util.translateToWords(numVal));
    }
    
    @Test
    public void validateForTeenDigits() {
    	int numVal = 16;
    	assertEquals("Sixteen ", util.translateToWords(numVal));
    }
    
    @Test
    public void validateForHundreds() {
    	int numVal = 102;
    	assertEquals("One Hundred and Two ", util.translateToWords(numVal));
    }
    
    @Test
    public void validateForMillions() {
    	int numVal = 56945781;
    	assertEquals("Fifty Six Million Nine Hundred and Forty Five Thousand Seven Hundred and Eighty One ", util.translateToWords(numVal));
    }
	
}
