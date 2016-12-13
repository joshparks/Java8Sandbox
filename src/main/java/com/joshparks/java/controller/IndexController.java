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

import com.joshparks.java.service.IndexService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private IndexService svc;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLandingPage(ModelMap model) {
		model.addAttribute("pageTitle", "Java 8 Page");
		return "index";
	}
	
	@RequestMapping(value = "/stream/basics", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamBasics() {
		Map<String, String> response = svc.testStreamBasics();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stream/reuse", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamReuse() {
		Map<String, String> response = svc.testStreamReuse();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stream/maps", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamMaps() {
		Map<String, String> response = svc.testStreamMaps();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stream/filters", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamFilters() {
		Map<String, String> response = svc.testStreamFilters();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stream/collectors", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamCollectors() {
		Map<String, String> response = svc.testStreamCollectors();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stream/predicates", method = RequestMethod.GET, headers={"Accept=*/*","Content-Type=*/*"})
	public @ResponseBody ResponseEntity<Map<String, String>> testStreamPredicates() {
		Map<String, String> response = svc.testStreamPredicates();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
