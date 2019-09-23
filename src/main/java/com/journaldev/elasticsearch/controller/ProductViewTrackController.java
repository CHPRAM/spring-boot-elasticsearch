package com.journaldev.elasticsearch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDateTime;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.elasticsearch.bean.Book;
import com.journaldev.elasticsearch.bean.ProductView;
import com.journaldev.elasticsearch.dao.CurrentRequestDao;
import com.journaldev.elasticsearch.dao.ProductViewDao;

@RestController
@CrossOrigin(origins="*")
public class ProductViewTrackController {
	
	     private ProductViewDao productVDao;

         public ProductViewTrackController(ProductViewDao  productVDao) {
	        this.productVDao = productVDao;
	    }
         
         
         @RequestMapping("/productRequest/{prSku}/{prName}")
         @PostMapping
         public ProductView hitTrack(@PathVariable String prSku,@PathVariable int prName,HttpServletRequest request) throws Exception{
       
        	String  postal=(String)request.getSession().getAttribute("POSTAL");
        	String  city=(String)request.getSession().getAttribute("CITY");
        	String ip=(String)request.getSession().getAttribute("IP");
        	 ProductView productView=new ProductView();
             productView.setCity(postal);
             productView.setArea_code(city);
             productView.setDtr(LocalDateTime.now());
             productView.setProductId(String.valueOf(prName));
             productView.setProductname(prSku);
         //System.out.println(request);
     	 return productVDao.insertProductView(productView);
     	
     }     
    
}
