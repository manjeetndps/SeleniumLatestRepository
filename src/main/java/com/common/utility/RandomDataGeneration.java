/**
 * Author:- Manjeet Kumar
 */

package com.common.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.github.javafaker.Faker;

public class RandomDataGeneration {
	
	private static Faker faker;
	
	 private static final String CHAR_LIST = 
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    private static final int RANDOM_STRING_LENGTH = 7;
		    private static final int RANDOM_EMAIL_LENGTH = 5;
	
	public int  getRandomNuber()
	{
		  Random ran=new Random();
		  int num=ran.nextInt(9999999);
		  return num;
	}
	
	public String getToDayDate()
	{
		
		
		SimpleDateFormat formatToday = new SimpleDateFormat("MMddyy");
		String date=formatToday.format(new Date());
		System.out.println("To Day Date ::"+date);
		
		return date;
		
	}
	
	public String getDateAndTime()
	{
		SimpleDateFormat scrShot = new SimpleDateFormat("MMddyyHHmmss");
		String dateandtime = scrShot.format(new Date());
		System.out.println("Date And Time ::"+dateandtime);
		return  dateandtime;
		
	}
	
	
	public static void main(String[] args) {
		
		RandomDataGeneration ran=new RandomDataGeneration();
		ran.getDateAndTime();
	}
	
	private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random(); 
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
	
	 public String generateRandomString(boolean isName){
         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            
	            if(isName){
	            	randStr = randStr.append(ch);
	            } 
	            else {
	            	randStr.append(ch);
	            }
	        }
	        return "Folder " +  randStr.toString();
	    }
	 
	public String generateRandomEmail(String emailDomain) {

		StringBuffer randStr = new StringBuffer();

		if (emailDomain != null || emailDomain != StringUtils.EMPTY) {
			for (int i = 0; i < RANDOM_EMAIL_LENGTH; i++) {
				int number = getRandomNumber();
				char ch = CHAR_LIST.charAt(number);
				randStr.append(ch);

			}
			return "Email" + randStr.toString() + emailDomain;
		} else {
			return "Email" + randStr.toString() + "@gmail.com";
		}
	}
	
	public String randomFirstName() {

		faker = new Faker();

		String firstName = faker.name().firstName();
		return firstName;
	}

	public String randomLastName() {

		faker = new Faker();

		String lastName = faker.name().lastName();
		return lastName;
	}
	
	public String randomFullName() {

		faker = new Faker();

		String firstName = faker.name().fullName();
		return firstName;
	}
	
	public String randomPrefixe() {

		faker = new Faker();

		String firstName = faker.name().prefix();
		return firstName;
	}
	
	public String randomSuffixe() {

		faker = new Faker();

		String firstName = faker.name().suffix();
		return firstName;
	}

	public String randomStreetAddress() {

		faker = new Faker();
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}
}
