package localhost.sailsAPIProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

/**
 * Sample class that makes a simple request to Google Maps Directions
 * 
 * @author Jacob Chmielewski
 * @since 2016-09-07
 *
 */

public class GetSailsAPI {

	/*
	 * The URL of the API we want to connect to
	 */
	protected static String endpoint = "http://localhost:1337/employee/";
	
	/*
	 * The character set to use when encoding URL parameters
	 */
	protected static String charset = "UTF-8";
	
public static void main(String[] args) {
	
	try{
		
		//The firstname field
		String firstName = "Jacob";
		
		//The lastname field
		String lastName = "Chmielewski";
		
		//The email field
		String email = "jakec202@yahoo.com";
		
		// homephone field
		String homePhone = "410-288-2359";
		
		// cellphone field
		String cellPhone = "410-804-5069";
		
		//password field
		String password = "Bigby410";
		
		//active field
		String active = "1";
		
	//creates the URL parameters as a string encoding them with the defined charset
	String queryString = String.format("firstName=%s&lastName=%s&email=%s&homephone=%s&cellPhone=%s&password=%s&active=%s",
			URLEncoder.encode(firstName, charset),
			URLEncoder.encode(lastName, charset),
			URLEncoder.encode(email, charset),
			URLEncoder.encode(homePhone, charset),
			URLEncoder.encode(cellPhone, charset),
			URLEncoder.encode(password, charset),
			URLEncoder.encode(active, charset)
			);
		
	//creates a new URL out of the endpoint and queryString
	URL apiTesting = new URL(endpoint + "?" );
	HttpURLConnection connection = (HttpURLConnection) apiTesting.openConnection();
	connection.setRequestMethod("GET");
	
	//if we did not get a 201 (success) throw and exception
	if (connection.getResponseCode() !=200){
		throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode());
	}
	
	//read response into buffer
	BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
	
	//loop of buffer line by line until it returns null meaning no more lines
	while(br.readLine() !=null){
		//print out eac line to the screen
		System.out.println(br.readLine());
	}
	
	//close connection to API
	connection.disconnect();
	
	}catch (MalformedURLException e){
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();
	}
	
	
	
}
	
}
