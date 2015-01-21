package com.sow.biblio.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

  public class RegexTest {

/*	public static void main(String args[]) {
	//String patternStr = "b";
	//String patternStr = "^(?s)(?u)(?i)Y.*";
	//String patternStr = "^(?s)(?u)(?i)(re:|)Y.*";
	String patternStr = "^(?s)(?u)(?i)REBATE";
	Pattern pattern = Pattern.compile(patternStr);
	
	CharSequence inputStr = "REBATe ";
	Matcher matcher = pattern.matcher(inputStr);
	boolean matchFound = matcher.matches(); // false
	System.out.println ("\nmatchFound:" + matchFound + ":");
  } */
	  
		public static void main(String args[]) {
			
			String smsMsg1 = "+Savings: Does Medicare/Medcaid cover your prescription? Reply Y or N.";
			String smsMsg2 = "+Savings: Yr copay info is BIN xxxxxx GROUP xxxxxxxx ID xxxxxxxxxxxx. Pls give this info 2 yr pharmacist. Reply YES for monthly refill reminders.";
			//String regex = "\\+Savings: Does Medicare/Medcaid cover your prescription\\? Reply Y or N.";
			
			String regex1 = ".*Medicare.*"; 
			String regex2 = ".*Yr copay.*";
			
			String keyword1 = "GETAPP"; 
			String keyword2 = "GET APP"; 
			String keyword3 = "GET  APP"; 
			String keyword4 = "GET	             APP"; 
			String keyword5 = "get app"; 
			
			String keywordRegEx = "^(?u)(?i)GET[\\s++]*APP$";
						
			//System.out.println ("\nmatchFound1:" + smsMsg1.matches(regex1) + ":");
			
			//System.out.println ("\nmatchFound2:" + smsMsg2.matches(regex2) + ":");
			
			System.out.println ("\nmatchFound:" + keyword1.matches(keywordRegEx) + ":");
			System.out.println ("\nmatchFound:" + keyword2.matches(keywordRegEx) + ":");
			System.out.println ("\nmatchFound:" + keyword3.matches(keywordRegEx) + ":");
			System.out.println ("\nmatchFound:" + keyword4.matches(keywordRegEx) + ":");
			System.out.println ("\nmatchFound:" + keyword5.matches(keywordRegEx) + ":");
			
		  }
}