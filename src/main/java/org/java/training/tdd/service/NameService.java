package org.java.training.tdd.service;

import org.java.training.tdd.model.StudentNames;
import org.java.training.tdd.repository.NameDAO;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameService {
	@Autowired
	private NameDAO dao;

	public Object getNameById() {
		return null;
	}


	@SuppressWarnings("unchecked")
	public JSONObject resultByJSON() {
		JSONObject obj = new JSONObject();
		Integer idValue = dao.getDocumentId();
		if (idValue != 0) {
			StudentNames name = dao.getNameFromTableAsBean(idValue);
			if (name != null) {
				obj.put("name", name.getFirstName());
				obj.put("status", "success");
			} else {
				obj.put("name", "");
				obj.put("status", "failure");
			}
		} else {
			obj.put("name", "");
			obj.put("status", "failure");
		}
		return obj;
	}

}
