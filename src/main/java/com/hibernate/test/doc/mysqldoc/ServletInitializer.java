package com.hibernate.test.doc.mysqldoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ServletInitializer extends SpringBootServletInitializer {

    @Autowired
    private CustomerInterface customerCrud;

    @GetMapping(value = "customer")
    public Customer getUser() {
        Customer c = new Customer();
        c.setEmail("3amer");
        c.setFirstName("3amer");
        c.setLastName("3amer");
        customerCrud.save(c);
        System.out.println(customerCrud.count());
        return c;
    }

    @PostMapping(value = "insert", consumes = "application/json")

    public void saveCustomer(@RequestBody Customer customer) {
        try {
            System.out.println("Hello from Servlet Iam inside Try .........");
            customerCrud.save(customer);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MysqldocApplication.class);
    }

}
