package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Student;

/**
 * 
 * @author sravannallala
 * DAO layer for student
 */
@Repository
public class StudentDAO extends DAO<Student> {

	@Override
	protected String getQueryString() {
		return "from Student s where s.name like :name";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Student student) {
		map.put("name", "%" + student.getName() + "%");

	}

	/**
	 * 	
	 * @param student
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loginStudent(Student student) {
		Query studDtls = em.createQuery(getQueryString());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		fillParametersMap(parameters, student);
		parameters.forEach((k, v) -> studDtls.setParameter(k, v));
		List<Student> studList = studDtls.getResultList();
		return studList;
	}

}
