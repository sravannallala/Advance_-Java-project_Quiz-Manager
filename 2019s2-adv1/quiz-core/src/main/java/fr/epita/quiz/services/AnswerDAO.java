package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Answer;

/**
 * 
 * @author sravannallala
 * DAO Layer for Answer
 */
@Repository
public class AnswerDAO extends DAO<Answer>{

	@Override
	protected String getQueryString() {
		return "from Answer a where a.answer like :answer";
	}

	@Override
	protected void fillParametersMap(Map<String,Object> map, Answer answer) {
		map.put("answer", "%" + answer.getAnswer() + "%");

	}
 
	/**
	 * 
	 * @param answer
	 * @return
	 */
	public List<Answer> searchAnswer(Answer answer) {
		Query searchQuery = em.createQuery(getQueryString());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		fillParametersMap(parameters,answer);
		
		parameters.forEach((k,v) -> searchQuery.setParameter(k,v));
		
		return (List<Answer>) searchQuery.getResultList();
	}




}
