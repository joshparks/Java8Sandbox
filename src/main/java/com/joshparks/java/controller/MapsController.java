package com.joshparks.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joshparks.java.service.MapsService;

@Controller
@RequestMapping("/maps")
public class MapsController {

	@Autowired
	private MapsService svc;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLandingPage(ModelMap model) {
		model.addAttribute("pageTitle", "Java 8 Page");
		return "maps";
	}
	
	@RequestMapping(value = "/basics", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testBasicMaps() {
		Map<String, String> response = svc.testBasicMaps();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
