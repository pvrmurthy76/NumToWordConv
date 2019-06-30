package com.example.numtoword.util;

/**
 * Utility Class for conversion of number to words
 * @author Ramamurthy
 *
 */
public class TranslateUtil {

	private static final String[] units = {"Zero","One","Two","Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private static final String[] tensMultiple = {"Ten","Twenty","Thirty","Forty",
			"Fifty","Sixty","Seventy","Eighty","Ninty"};
	private static final String[] teenValues = {"Eleven","Twelve","Thirteen","Fourteen",
			"Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	private  static final String[] hundreds = {"Hundred","Thousand","Million"};
	
	/*
	 * Method that validates the input and converts the number to word 
	 * format
	 * @Param integer input
	 * @return String with word format of a number or erro message 
	 */
	public String translateToWords(int input) {
		
		logMessageToConsole("Number to Convert : "+ input);
		
		String strInput = String.valueOf(input).trim();
		StringBuilder result = new StringBuilder();
	
		String validateResp = validateInput(strInput);
		
		if(validateResp.equalsIgnoreCase("success")) {
			try {
				if(strInput.length() > 6 && strInput.length() <= 9) {
					int millionPlaceValue = input / 1000000;
					result.append(getHundredsPlaceValueWords(millionPlaceValue));
					input = input % 1000000;
					result.append(hundreds[2]);
					result.append(" ");
				}
				if(String.valueOf(input).length() > 3 && String.valueOf(input).length() <= 6) {
					int thousandsPlaceValue = input/1000;
					result.append(getHundredsPlaceValueWords(thousandsPlaceValue));
					input = input % 1000;
					result.append(hundreds[1]);
					result.append(" ");
				}
				result.append(getHundredsPlaceValueWords(input));
			
			}catch(Exception e) {
				logMessageToConsole("Exception:"+e.getMessage());
				return "error: Invalid request";
			}
			
			return result.toString();
		}else {
			return validateResp;
		}
	}
	
	/*
	 *Following method does null and empty check validation for input argument
	 *@Param String
	 *@return String with error details if any else success  
	 */
	private String validateInput(String strInput) {
		
		if("".equals(strInput.trim()) || null == strInput) {
			logMessageToConsole("Invalid request received");
			return "error: blank input";
		}
		
		if(null != strInput && !"".equals(strInput.trim())) {
			if(strInput.contains("-")) {
				logMessageToConsole("Invalid request received: Cannot validate negative numbers");
				return "error: input value is negative";
			}
			if(strInput.length() > 9) {
				logMessageToConsole("Invalid request received: Cannot validate more than 9 digits");
				return "error: input length is more than 9 digits";
			}
		}
		return "success";
	}
	
	/*
	 *Following method returns hundreds place value in word format
	 *@Param integer input
	 *@return String word format of hundreds place
	 */
	private String getHundredsPlaceValueWords(int input) {
		
		StringBuilder result = new StringBuilder();
		if(String.valueOf(input).length() == 3){
			result.append(getNumValInWords(String.valueOf(input / 100)));
			input = input % 100;
			result.append(hundreds[0]);
			result.append(" and ");
		}
		if(String.valueOf(input).length() < 3){
			result.append(getNumValInWords(String.valueOf(input)));
		}
		
		return result.toString();
	}
	
	/*
	 *Following method returns units and tens place value in word format
	 *@Param integer input
	 *@return String word format of units and tens place values
	 */
	private  String getNumValInWords(String strInput) {
		StringBuilder response = new StringBuilder();
		int quotient = 0;
		int remainder = 0;
		if(strInput.length() == 2) {
			quotient = getQuotient(strInput, 10);
			remainder = getRemainder(strInput , 10);
			if(remainder == 0){
				response.append(tensMultiple[quotient-1]);
			}else  {
				if(quotient > 1){
					response.append(tensMultiple[quotient-1]);
					response.append(" ");
					response.append(units[remainder]);
				}else {
					response.append(teenValues[remainder-1]);
				}
			}
		}
		
		if(strInput.length() == 1) {
			response.append(units[Integer.parseInt(strInput)]);
		}
		response.append(" ");
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
	private  int getQuotient(String input,int base) {
		return Integer.parseInt(input) / base;
	}
	

	/*
	 *Following method returns remainder value 
	 *@Param integer input, @Param integer divisor value
	 *@return integer remainder value after dividing the dividend with divisor
	 */
	private  int getRemainder(String input, int base) {
		return Integer.parseInt(input) % base;
	}


}
