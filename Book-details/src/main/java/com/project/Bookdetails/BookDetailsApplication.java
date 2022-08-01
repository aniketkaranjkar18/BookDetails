package com.project.Bookdetails;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.Bookdetails.service.BookRepoService;


@SpringBootApplication
public class BookDetailsApplication {
	
	 
	public static void main(String[] args) {
		
		ApplicationContext ctx =  SpringApplication.run(BookDetailsApplication.class, args);
		BookRepoService bookRepoService = ctx.getBean(BookRepoService.class);	
		bookRepoService.addAllBooks("C:\\Users\\891043\\OneDrive - Cognizant\\Desktop\\BooksXmlToDb\\books.xml");	
			
	}


}
