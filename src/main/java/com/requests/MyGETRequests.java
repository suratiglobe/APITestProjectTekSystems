package com.requests;

import java.util.Scanner;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class MyGETRequests {

	public static void main(String[] args) {
			
		Scanner input;
		String country;
		int countryLength = 3;
		String url;
		char choice;

		do{							
			input = new Scanner(System.in); 		
			System.out.println("Enter Country Name: ");
			country = input.nextLine();  
			
			if(country.length() <= countryLength) {		
				url = "https://restcountries.eu/rest/v2/alpha/"+country;
			} else {
				url = "https://restcountries.eu/rest/v2/name/"+country;
			}

		    Response response = given().get(url);	     	     
		    JsonPath json = response.jsonPath();
		    
		    try {
		    	if(json.getString("capital") == null) {	    		
		    		System.out.println("Country does not exist");
		    	} else {	    		
		    		System.out.println("Capital City is: " +json.getString("capital").replaceAll("\\p{P}",""));			    		    
		    	}		
		    } catch (Exception e) {
		    	System.out.println("Invalid Input");
		    }
		    	System.out.println("Enter Y to Continue");
		        choice =  input.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
		
		input.close();
	}
}
