package com.msy.travel.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {

	 @ExceptionHandler
	 public String handleException(Exception ex,HttpServletRequest request,HttpServletResponse response) {     
	        if(ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException){  
	        	System.out.println("大小超过限制");
	        	return "index";
	        }  
	        
	        return "userlist";
	    }  

}
