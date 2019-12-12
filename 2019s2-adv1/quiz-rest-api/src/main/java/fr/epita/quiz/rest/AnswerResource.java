package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.AnswerDAO;

@Path("/answer/")
/**
 * 
 * @author sravannallala
 * This class is used for updating the answers.
 *
 */

public class AnswerResource {
	
	
	@Inject
	AnswerDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(AnswerResource.class);
	
	/**
	 * 
	 * @param answer
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/createA")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAnswer(@RequestBody Answer answer) throws URISyntaxException {
		LOGGER.debug("entering => Answers() with parameters : {} ", answer);
		//create a answer 
		dao.create(answer);
		LOGGER.info("received creation order for question : {}",  answer);
		return Response.created(new URI("answer/"  + String.valueOf(answer.getId()))).build();
	}
	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * 
	 */
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		//create a AnswerID 
		
		Answer answer = dao.getById(id, Answer.class);
		
		return Response.ok(answer).build();
	}

	
	@GET
	@Path("/searchA")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAnswer(@QueryParam("answer") String answer) {
		//search answer 
		List<Answer> searchList = dao.searchAnswer(new Answer(answer));
		return Response.ok(searchList).build();
	}
	
	
	
	
	

}
