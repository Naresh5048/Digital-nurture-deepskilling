package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(" Testing Annotation-Driven Auto-Scanned Bean Mapping ");
        // Look up by explicit name ID string to avoid conflicts with XML-defined beans
        BookService scannedService = (BookService) context.getBean("bookService");
        System.out.println("Books Inventory: " + scannedService.getAvailableBooks());

        System.out.println(" Testing Explicit Constructor Injection Configuration XML ");
        BookService constructorInjectedService = (BookService) context.getBean("bookServiceConstructor");
        System.out.println("Books Inventory: " + constructorInjectedService.getAvailableBooks());

        System.out.println(" Testing Explicit Setter Injection Configuration XML ");
        BookService setterInjectedService = (BookService) context.getBean("bookServiceSetter");
        System.out.println("Books Inventory: " + setterInjectedService.getAvailableBooks());
    }
}