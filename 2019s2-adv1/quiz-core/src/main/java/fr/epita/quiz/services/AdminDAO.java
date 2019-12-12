package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Admin;

/**
 * 
 * @author sravannallala
 * DAO Layer for ADMIN
 */
@Repository
public class AdminDAO extends DAO<Admin> {

	@Override
	protected String getQueryString() {
		return "from Admin aa where aa.uname like :uname";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Admin admin) {
		map.put("uname", "%" + admin.getUname() + "%");

	}

	/**
	 * 
	 * @param admin
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Admin> loginAdmin(Admin admin) {
		Query admDtls = em.createQuery(getQueryString());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		fillParametersMap(parameters, admin);
		parameters.forEach((k, v) -> admDtls.setParameter(k, v));
		List<Admin> admList = admDtls.getResultList();
		return admList;
	}

}
