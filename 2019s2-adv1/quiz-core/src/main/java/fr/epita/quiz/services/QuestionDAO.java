package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Question;

/**
 * 
 * @author sravannallala
 * DAO layer for Question
 */
@Repository
public class QuestionDAO extends DAO<Question>{

	
	@Override
	protected String getQueryString() {
		return "from Question q where q.questionContent like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String,Object> map, Question question) {
		map.put("pContent", "%" + question.getQuestionContent() + "%");

	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	public List<Question> loadNextQuestion(Question question) {
		String hql = "from Question q where q.id > "+question.getId()+" order by q.id ASC";
		Query searchQuery = em.createQuery(hql);
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		fillParametersMap(parameters,question);
		
		parameters.forEach((k,v) -> searchQuery.setParameter(k,v));
		
		return (List<Question>) searchQuery.getResultList();
	}




}
