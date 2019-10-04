
package org.java.training.tdd.controller;

import org.java.training.tdd.service.NameService;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
	private NameService nameService;
	public NameController(NameService nameService) {
        this.nameService = nameService;
    }

	@GetMapping(value = "/names/getJSON", produces = "application/json")
	public String getJSONDetails() throws JSONException {
		JSONObject obj = new JSONObject();
		obj = (JSONObject) nameService.resultByJSON();
		if (obj == null) {
			obj = new JSONObject();
			obj.put("status", "failure");
			obj.put("data", "Sorry Unable to process Please contact admin");
		}
		return obj.toString();
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
