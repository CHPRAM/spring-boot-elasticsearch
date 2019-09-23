package com.journaldev.elasticsearch.controller;

import com.journaldev.elasticsearch.bean.Book;
import com.journaldev.elasticsearch.bean.IP;
import com.journaldev.elasticsearch.dao.CurrentRequestDao;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
//@RequestMapping("/books")
public class CurrentRequestController {

    private CurrentRequestDao bookDao;

    public CurrentRequestController(CurrentRequestDao bookDao) {
        this.bookDao = bookDao;
    }
    
     
    @RequestMapping("/currentRequest/{ip}/{city}/{postal}")
    @PostMapping
    public Book hitTrack(@PathVariable String ip,@PathVariable String city,@PathVariable String postal, HttpServletRequest request,HttpSession session) throws Exception{
    	//com.journaldev.elasticsearch.bean.IP ip= new com.journaldev.elasticsearch.bean.IP();
    	//ip.getIPInfo(request);
    	//String urll ="http://api.ipstack.com/"+getClientIP(request)+"?access_key=52bc9ce9aea4d1b0ab3225d21e3bb5ca";
    	//String urll ="http://api.ipstack.com/"+getClientIP(request)+"?access_key=52bc9ce9aea4d1b0ab3225d21e3bb5ca";
    	//http://ip-api.com/json/24.48.0.1?fields=status,message,country,countryCode,region,regionName,city,zip,lat,lon,timezone,isp,org,as,query
    	/* try {

    			URL url = new URL(urll);
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			conn.setRequestMethod("GET");
    			conn.setRequestProperty("Accept", "application/json");

    			if (conn.getResponseCode() != 200) {
    				throw new RuntimeException("Failed : HTTP error code : "
    						+ conn.getResponseCode());
    			}

    			BufferedReader br = new BufferedReader(new InputStreamReader(
    				(conn.getInputStream())));

    			String output;

    			List<String> list = new ArrayList<String>();
    			System.out.println("Output from Server .... \n");
    			JSONParser parse = new JSONParser(); 
    			
    			while ((output = br.readLine()) != null) {
    				System.out.println(output);
    				//JSONObject obj = new JSONObject(output);
    				JSONObject jobj = (JSONObject)parse.parse(output); 
    				if((String)jobj.get("ip")!=null)
    				book.setIp((String)jobj.get("ip"));
    				if((String)jobj.get("city")!=null)
    				book.setCity((String)jobj.get("city"));
    				if((String)jobj.get("latitude")!=null)
    				book.setLatitude((Double)jobj.get("latitude"));
    				if((String)jobj.get("latitude")!=null)
    				book.setLongitude((Double)jobj.get("latitude"));
    				if((String)jobj.get("region_name")!=null)
    				book.setRegion_name((String)jobj.get("region_name"));
    				if((String)jobj.get("region_code")!=null)
    				book.setRegion_code((String)jobj.get("region_code"));
    				if((String)jobj.get("area_code")!=null)
    				book.setArea_code((String)jobj.get("area_code"));
    				
    			}

    			conn.disconnect();

    		  } catch (MalformedURLException e) {

    			e.printStackTrace();

    		  } catch (IOException e) {

    			e.printStackTrace();

    		  }*/
    	
    	session.setAttribute("ip", ip);
    	Book requestbook=new Book();
    	requestbook.setCity(postal);
    	requestbook.setArea_code(city);
    	requestbook.setIp(ip);
        System.out.println(request);
        request.getSession().setAttribute("POSTAL", postal);
        request.getSession().setAttribute("CITY", city);
        request.getSession().setAttribute("IP", ip);
    	 return bookDao.insertBook(requestbook);
    	
    }

    public static String getClientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");

        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id){
        return bookDao.getBookById(id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id){
        return bookDao.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
         bookDao.deleteBookById(id);
    }
}
