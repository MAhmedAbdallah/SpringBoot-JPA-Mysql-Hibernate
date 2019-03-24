package com.hibernate.test.doc.mysqldoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/")
public class ServletInitializer extends SpringBootServletInitializer {

        @Autowired
        private CustomerInterface customerCrud ;
    
    @GetMapping(value = "customer")
    public Customer getUser() {
        Customer c = new Customer();
        c.setEmail("3amer");
        c.setFirstName("3amer");
        c.setLastName("3amer");
        customerCrud.save(c);
        return c;
    }
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MysqldocApplication.class);
	}

}
