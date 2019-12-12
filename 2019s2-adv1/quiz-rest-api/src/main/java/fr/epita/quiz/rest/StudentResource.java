package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.StudentDAO;

@Path("/student/")
/**
 * 
 * @author sravannallala
 * This is for student Controller
 */
public class StudentResource {
	
	
	@Inject
	StudentDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(StudentResource.class);
	
	/**
	 * 
	 * @param student
	 * @return
	 * @throws URISyntaxException
	 * For Saving Student Details
	 */
	
	@POST
	@Path("/savStd")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStudent(@RequestBody Student student) throws URISyntaxException {
		LOGGER.debug("entering => savestudent() with parameters : {} ", student);
		//create a student register 
		dao.create(student);
		LOGGER.info("received cStudents details : {}",  student);
		return Response.created(new URI("student/"  + String.valueOf(student.getId()))).build();
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 * For Student Login
	 */
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginStudent(@RequestBody Student student) {
		//Check Student Login 
		List<Student> studList = dao.loginStudent(student);
		return Response.ok(studList).build();
	}
	

}
