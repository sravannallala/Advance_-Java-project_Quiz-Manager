package fr.epita.quiz.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Admin;
import fr.epita.quiz.services.AdminDAO;

@Path("/admin/")

/**
 * 
 * @author sravannallala
 * This class is used for admin controller
 * 
 */

public class AdminResource {
	
	
	@Inject
	AdminDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(AdminResource.class);
	
	
	

	/**
	 * 
	 * @param admin
	 * @return
	 * This method is used for admin login
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginAdmin(@RequestBody Admin admin) {
		//Check Admin Login 
		List<Admin> admList = dao.loginAdmin(admin);
		return Response.ok(admList).build();
	}
	

}
