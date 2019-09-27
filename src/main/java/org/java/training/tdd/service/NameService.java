package org.java.training.tdd.service;

import org.java.training.tdd.model.NameModel;
import org.java.training.tdd.repository.NameDAO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class NameService {
	private NameDAO dao;

	public NameService(NameDAO dao) {
		this.dao = dao;
	}

	public Object getNameById() {
		return null;
	}

//	public JSONObject resultByJSON() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public JSONObject resultByJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		Integer idValue = dao.getDocumentId();
		// String nameAsString=(String) dao.getNameFromTableAsString();
		// System.out.println(nameAsString+"$$$$$");
		if (idValue != 0) {
			NameModel name = dao.getNameFromTableAsBean(idValue);
			if (name != null) {
				obj.put("name", "sanjay");
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
