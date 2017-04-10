package com.kiran.webapp;

import com.kiran.service.HelloService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kiran.model.UserDetails;
import com.kiran.model.Address;

@Path("/hello")
public class HelloWebapp {
	private static HelloService helloService = new HelloService();

	@GET()
	@Produces("text/plain")
	public String sayHello() {
		return helloService.sayHello();
	}

	@GET()
	@Path("/user")
	public String save() {
		UserDetails ud = new UserDetails();
		ud.setId(1);
		ud.setName("First user");
        
        Address addr1 = new Address();
        addr1.setState("state");
        addr1.setCity("city");
        addr1.setStreet("street");
        addr1.setPinCode("pincode");
        
        //ud.setAddress(addr1);
		ud.getAddresses().add(addr1);

		try {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ud);
		tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return "User info persisted!";
	}
}
