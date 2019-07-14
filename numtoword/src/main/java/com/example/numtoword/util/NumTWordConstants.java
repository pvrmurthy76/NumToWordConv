package com.example.numtoword.util;

/**
 * Class that holds constants utilized in the project
 * @author Ramamurthy
 *
 */
public class NumTWordConstants {


	public static final String[] UNITS = {"Zero ","One ","Two ","Three ",
			"Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
	public static final String[] TENS_MULTIPLE = {"Ten ","Twenty ","Thirty ","Forty ",
			"Fifty ","Sixty ","Seventy ","Eighty ","Ninty "};
	public static final String[] TEEN_VALUES = {"Eleven ","Twelve ","Thirteen ","Fourteen ",
			"Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
	
	public static final String HUNDRED_WORD = "Hundred and ";
	
	public static final int HUNDRED = 100;
	
	public  static final String[] PLACE_VALUE_WORDS = {"Million ","Thousand ",HUNDRED_WORD};
	
	public static final int[] PLACE_VALUES = {1000000,1000,HUNDRED};
	
	public static final int ZERO = 0;
	
	public static final int ONE = 1;
	
	public static final int TENS_PLACE_VALUE = 10; 
	
	public static final int MAX_VALUE = 999999999;
	
	public static final String NUMBER_FORMAT_ERROR_MSG = "Invalid number ";
	
	public static final String MAX_ALLOWED_ERROR_MSG = "Invalid request received: Cannot validate more than "+ MAX_VALUE +" digits";
	
	public static final String NEGATIVE_NUMBER_ERROR_MSG = "Invalid request received: Cannot validate negative numbers";

}
