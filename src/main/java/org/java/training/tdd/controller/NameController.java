
package org.java.training.tdd.controller;

import org.java.training.tdd.service.NameService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
	@Autowired(required=false)
	private NameService nameService;
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/names/getJSON", produces = "application/json")
	public JSONObject getJSONDetails() {
		JSONObject obj = new JSONObject();
		try {
		obj = nameService.resultByJSON();
		if (obj == null) {
			obj = new JSONObject();
			obj.put("status", "failure");
			obj.put("data", "Sorry Unable to process Please contact admin");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@GetMapping("/names/{name}")
	public String getNameDetails(@PathVariable String name) {
		Object nameGiven = nameService.getNameById();
		if (nameGiven == null) {
			nameGiven = "EMPTY";
		}
		return nameGiven.toString();
	}

}
