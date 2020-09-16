package com.hcid.partner.auth.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by yusep.maulana07 on 20/07/2018.
 */
public class HelperUtil {

	private static final Logger LOGGER = LogManager.getLogger(HelperUtil.class);
    public HelperUtil() {
    }
    
    public static void main(String[] args) {
    	try {
    		String a = convertToMd5("p@ssw0rd");
			LOGGER.info(generateMD5("p@ssw0rd"));
			String b = generateMD5("p@ssw0rd");
			LOGGER.info(convertToMd5("p@ssw0rd"));
			
			
			if(a.equals(b)) {
				LOGGER.info("cocok");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			LOGGER.error(convertStacktraceToString(e));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(convertStacktraceToString(e));
		}
	}

    public static String convertStacktraceToString(Exception e) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        sb.append(e.getClass().getName() + " : " + e.getMessage() + "\n");

        for(int i = 0; i < stackTrace.length; ++i) {
            sb.append("\t at " + stackTrace[i].toString() + "\n");
        }

        return sb.toString();
    }
    
    public static String convertToMd5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        System.out.println(md);
        md.update(data.getBytes());
        byte[] digest = md.digest();
        System.out.println(digest);
        System.out.println(DatatypeConverter.printHexBinary(digest));
        return DatatypeConverter.printHexBinary(digest);
    }
    
    public static String generateMD5 (String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
    
    public static String generateRandomNumber (int min, int max, int loop) {
    	
  		String randomNumber = "";
      	for(int i = 0; i<loop; i++){
      		randomNumber += randomNumber(min, max);
      	}
      	
      	return randomNumber;
      }

      @SuppressWarnings("static-access")
  	private static String randomNumber (int min, int max){
      	String result = null;
      	Integer number = 0;
      	if(min >= max){
      		throw new IllegalArgumentException();
      	}
      	Random r = new Random();
      	number = r.nextInt((max - min) + 1);
      	return String.valueOf(number);
      }
      
      private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
      		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
      
      public static boolean validateEmail(String emailStr) {
  		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
  		return matcher.find();
  	}
      
      public static String exceptionDescHandling(String exception, Integer limit) {
  		String exceptionResult = exception;
  		if(exception.length() >= limit){
  			exceptionResult = exception.substring(0, limit - 1);
  		}
  		return exceptionResult;
  	}
      public static String getAbsoluteDate (){
  		Date date = new Date();
  		Calendar calendar = new GregorianCalendar();
  		calendar.setTime(date);
  		int year = calendar.get(Calendar.YEAR);
  		//Add one to month {0 - 11}
  		int month = calendar.get(Calendar.MONTH) + 1;
  		int day = calendar.get(Calendar.DAY_OF_MONTH);
  		int hours = calendar.get(Calendar.HOUR_OF_DAY);
  		int minutes = calendar.get(Calendar.MINUTE);
  		int seconds = calendar.get(Calendar.SECOND);
  		String absolute = String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hours) + String.valueOf(minutes) + String.valueOf(seconds);
  		return absolute;
  	}

}
