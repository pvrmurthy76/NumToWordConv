/**
 * 
 */
package com.example.numtoword.service;

import com.example.numtoword.exception.NumToWordException;
import static com.example.numtoword.util.NumTWordConstants.UNITS;
import static com.example.numtoword.util.NumTWordConstants.TENS_MULTIPLE;
import static com.example.numtoword.util.NumTWordConstants.TEEN_VALUES;
import static com.example.numtoword.util.NumTWordConstants.HUNDRED;
import static com.example.numtoword.util.NumTWordConstants.PLACE_VALUE_WORDS;
import static com.example.numtoword.util.NumTWordConstants.PLACE_VALUES;
import static com.example.numtoword.util.NumTWordConstants.ZERO;
import static com.example.numtoword.util.NumTWordConstants.ONE;
import static com.example.numtoword.util.NumTWordConstants.TENS_PLACE_VALUE;
import static com.example.numtoword.util.NumTWordConstants.MAX_VALUE;
import static com.example.numtoword.util.NumTWordConstants.NUMBER_FORMAT_ERROR_MSG;
import static com.example.numtoword.util.NumTWordConstants.MAX_ALLOWED_ERROR_MSG;
import static com.example.numtoword.util.NumTWordConstants.NEGATIVE_NUMBER_ERROR_MSG;




/**
 * Implementation class to define business logic 
 * @author Ramamurthy
 *
 */
public class NumToWordConvertImpl implements NumToWordConvert {
	
	
	/*
	 *Following method returns word format for a given number
	 *@Param integer input
	 *@return String word format of a given number
	 */	
	public String convertToWord(int faceValue) {
		StringBuilder wordFormatResp = new StringBuilder();
		int quotient = ZERO;
		int index = ZERO;
		try {
			validateInput(faceValue);
			for(int placeValue: PLACE_VALUES) {
				quotient = getQuotient(faceValue, placeValue); 
				if(quotient > ZERO){
					wordFormatResp.append(getHundredsPlaceValueWords(quotient));
					wordFormatResp.append(PLACE_VALUE_WORDS[index]);
					faceValue = faceValue % placeValue;
				}
				index++;
			}
			wordFormatResp.append(getNumValInWords(faceValue));
		}catch(NumToWordException ntwEx){
			logMessageToConsole(ntwEx.getMessage());
			return ntwEx.getMessage();
		}
		return wordFormatResp.toString();
	}
	
	/*
	 *Following method does validation for input argument
	 *@Param integer
	 *@return Custom Exception class  with error details if any   
	 */
	private void validateInput(int faceValue) throws  NumToWordException{
		
		try{
			if(faceValue > MAX_VALUE) {
				throw new NumToWordException(MAX_ALLOWED_ERROR_MSG);
			}
			if(faceValue < ZERO) {
				throw new NumToWordException(NEGATIVE_NUMBER_ERROR_MSG);
			}
		}catch(NumberFormatException nfEx) {
			throw new NumToWordException(NUMBER_FORMAT_ERROR_MSG, nfEx);
		}
	}
	/*
	 *Following method returns hundreds place value in word format
	 *@Param integer input
	 *@return String word format of hundreds place
	 */
	private String getHundredsPlaceValueWords(int faceValue) throws NumToWordException{
		
		StringBuilder result = new StringBuilder();
		try {
			int quotient = getQuotient(faceValue, HUNDRED); 
			if(quotient > ZERO){
				result.append(getNumValInWords(quotient));
				faceValue = faceValue % HUNDRED;
				result.append(PLACE_VALUE_WORDS[PLACE_VALUE_WORDS.length - ONE]);
			}
			result.append(getNumValInWords(faceValue));
		}catch(NumberFormatException nfEx) {
			throw new NumToWordException(NUMBER_FORMAT_ERROR_MSG, nfEx);
		}catch(ArrayIndexOutOfBoundsException arrayEx) {
			throw new NumToWordException(NUMBER_FORMAT_ERROR_MSG, arrayEx);
		}
		return result.toString();
	}
	
	/*
	 *Following method returns units and tens place value in word format
	 *@Param integer input
	 *@return String word format of units and tens place values
	 */
	private  String getNumValInWords(int faceValue) throws NumToWordException{
		StringBuilder response = new StringBuilder();
		try {
			if( faceValue > TENS_PLACE_VALUE) {
				int quotient = getQuotient(faceValue, TENS_PLACE_VALUE);
				int remainder = getRemainder(faceValue , TENS_PLACE_VALUE);
				
				if(remainder == ZERO){
					response.append(TENS_MULTIPLE[quotient-ONE]);
				}else  {
					if(quotient > ONE){
						response.append(TENS_MULTIPLE[quotient-ONE]);
						response.append(UNITS[remainder]);
					}else {
						response.append(TEEN_VALUES[remainder-ONE]);
					}
				}
			}else {
				response.append(UNITS[faceValue]);
			}
		}catch(NumberFormatException nfEx) {
			throw new NumToWordException(NUMBER_FORMAT_ERROR_MSG, nfEx);
		}catch(ArrayIndexOutOfBoundsException arrayEx) {
			throw new NumToWordException(NUMBER_FORMAT_ERROR_MSG, arrayEx);
		}
		return response.toString();
	}
	
	/*
	 *Following method logs the messages to console
	 *@Param String msg to be logged
	 *@return void
	 */
	private void logMessageToConsole(String msg) {
		System.out.println("");
		System.out.printf("%s", msg);
		System.out.println("");
	}
	
	/*
	 *Following method returns quotient value 
	 *@Param integer input, @Param integer divisor value
	 *@return integer quotient value after dividing the dividend with divisor
	 */
	private  int getQuotient(int input,int base) {
		return input / base;
	}
	

	/*
	 *Following method returns remainder value 
	 *@Param integer input, @Param integer divisor value
	 *@return integer remainder value after dividing the dividend with divisor
	 */
	private  int getRemainder(int input, int base) {
		return input % base;
	}
	
	

}
