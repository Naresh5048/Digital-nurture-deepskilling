package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        displayDate();
        displayCountry();
        displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START - Initializing XML parse tracking validation pipelines");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat targetFormatter = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date analyticalParsedDate = targetFormatter.parse("31/12/2018");
            LOGGER.debug("Analytical Runtime Processed Date: {}", analyticalParsedDate);
        } catch (Exception e) {
            LOGGER.error("Structural schema mapping constraint variations detected on parameters");
        }
    }

    @SuppressWarnings("unchecked")
    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Object> list = context.getBean("countryList", ArrayList.class);
        if(!list.isEmpty()) {
            LOGGER.debug("Country : {}", list.get(0));
        }
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START - Bulk Array parsing strategies initialized");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<com.cognizant.springlearn.model.Country> bulkCountriesList = context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Countries Inventory context trace mappings payload: {}", bulkCountriesList);
    }
}