package com.leeholdcraft.routing;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
	
	@RestController
	@RequestMapping("/coding")
    public class CodingController{ // 3
		@RequestMapping("")
        // 3. Method that maps to the request route above
        public String home() { // 3
                return "Hello Coding Dojo!";
        }
		@RequestMapping("/python")
        // 3. Method that maps to the request route above
        public String python() { // 3
                return "Python/django was great!";
        }
		@RequestMapping("/java")
        // 3. Method that maps to the request route above
        public String java() { // 3
                return "Java/Spring is better!";
        }
	}
	
	@RestController
	public class DojoController{
	@RequestMapping("/{location}")
    	public String location(@PathVariable("location") String location) {
           	if(location.equals("dojo")) {
           		return "Dojo is awesome!";
           	}
           	else if(location.equals("burbank-dojo")) {
           		return "Burbank Dojo is in SoCal";
           	}
           	else if(location.equals("san-jose")) {
        	   return "SJ dojo is headquarters";
           	}
           	else {
           		return "Please use either /coding, /coding/python, /coding/java or /dojo, /burbank/dojo, /san-jose";
           	}
    	}
	}
}
