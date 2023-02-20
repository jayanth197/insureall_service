package com.insureall.util;
import java.time.Instant;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InsureAllUtil {

	public static String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(),"");

	}
	// Generate random password
	public static String generatePassword()
	{
		int len = 8;
		String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String smallChars = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 
		String symbols = "!@#$%^&*_=.)"; 
		char[] password=null;
		try {
			String values = capitalChars + smallChars + numbers + symbols; 
			// Using random method 
			Random random = new Random(); 
			password = new char[len]; 
			for (int i = 0; i < len; i++) 
			{ 
				password[i] = values.charAt(random.nextInt(values.length())); 
			} 
		}catch (Exception e) {
			//log.info("Unable to generate password {} ",e);
		}
		return String.valueOf(password);
	}

	public static int generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		return m + new Random().nextInt(9 * m);
	}

	public static String getCurrentDateTime() {
		return Instant.now().toString();
		/*DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern(PartnerConstants.DATE_YYYY_MM_DD_HH_MM_SS); 
				LocalDateTime datetime = LocalDateTime.now();
				return datetime.format(oldPattern);*/
	}

	public static String convertObjectToJson(Object object) //throws JsonProcessingException 
	{
		try {
			ObjectMapper obj = new ObjectMapper(); 
			return obj.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		} 
	}
	public String fetchIPAddress(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		if (ipAddress == null) {  
			ipAddress = request.getRemoteAddr();  
		}
		//    log.info("CommonBpiServiceHandler : FetchIPAddress - Request received from IP Address : "+ipAddress);
		return ipAddress;
	}

}


