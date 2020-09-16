package com.hcid.partner.auth.utility;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;





public abstract class ConnectorUtil {
	
	public ResponseEntity<String> postA (String url, Object param){
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, param, String.class);
	    return result;
	}
	
	public void postB (String url, Map<String, Object> param){
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	     restTemplate.postForEntity(uri, param, String.class);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static Map getA (String url, Map<String, Object> param){
		RestTemplate restTemplate = null;
		RestTemplateBuilder restTemplateBuilder = null;
	    Map response = null;
		try {
			response = new HashMap<String, Object>();
			restTemplate = new RestTemplate();
			restTemplateBuilder = new RestTemplateBuilder();
			
			restTemplate = restTemplateBuilder.basicAuthorization(param.get("username").toString() ,param.get("pass").toString()).build();
			response = restTemplate.getForObject(url,Map.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	     return (Map)response;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static Map getB (String url, Map<String, Object> param){
		RestTemplate restTemplate = null;
		RestTemplateBuilder restTemplateBuilder = null;
	    Map<String, Object> response = null;
	    String resp = null;
		try {
			response = new HashMap<String, Object>();
			restTemplate = new RestTemplate();
			restTemplateBuilder = new RestTemplateBuilder();
			
			restTemplate = restTemplateBuilder.basicAuthorization(param.get("username").toString() ,param.get("pass").toString()).build();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			resp = restTemplate.getForObject(url,String.class);
			response.put("result", resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	     return (Map)response;
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	public static Map postA (String url, Map<String, Object> param, String username, String pass) throws Exception {
		RestTemplate restTemplate = null;
		RestTemplateBuilder restTemplateBuilder = null;
	    Map response = null;
		try {
			response = new HashMap<String, Object>();
			restTemplate = new RestTemplate();
			restTemplateBuilder = new RestTemplateBuilder();
			
			restTemplate = restTemplateBuilder.basicAuthorization(username ,pass).build();
			response = restTemplate.postForObject(url, param, Map.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	 
	     return (Map)response;
	}
	
	
	//Sorry Berantakan Ngoding Udah Jam 5 Pagi hehehehe
			@SuppressWarnings("unchecked")
			public static Map <String, Object> postC (String url, Map<String, Object> param){
				RestTemplate restTemplate = new RestTemplate();
			    URI uri = null;
			    Map <String, Object>response = null;
			    ResponseEntity resp = null;
			  
				try {
					
					uri = new URI(url);
					resp =  restTemplate.postForEntity(uri, param, Map.class);
					response = (Map<String, Object>) resp.getBody();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 return response;
				
				
			}
			
		
			public static void postC2 (String url, Map<String, Object> param){
				RestTemplate restTemplate = new RestTemplate();
			    URI uri = null;
			   
			  
			  
				try {
					
					uri = new URI(url);
					restTemplate.postForEntity(uri, param, Map.class);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 
				
				
			}
			
			@SuppressWarnings("unchecked")
			public static ResponseEntity postD (String url, Map<String, Object> param){
				RestTemplate restTemplate = new RestTemplate();
			    URI uri = null;
			    ResponseEntity resp = null;
			  
				try {
					
					uri = new URI(url);
					resp =  restTemplate.postForEntity(uri, param, Map.class);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 return resp;
				
				
			}

	public static ResponseEntity getD (String url, Map<String, Object> param){
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		ResponseEntity resp = null;

		try {

			uri = new URI(url);
			resp =  restTemplate.getForEntity(uri, Map.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;


	}

}
