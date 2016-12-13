package com.joshparks.java.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.joshparks.java.model.Person;
import com.joshparks.java.util.CollectionUtil;

@Service
public class MapsService {

	public Map<String, String> testBasicMaps() {

		Map<String, Person> personMap = CollectionUtil.getPersonMap();

		System.out.println("***** MAP => values() *****");
		Collection<Person> personValCollection = personMap.values();
		personValCollection.forEach(p -> System.out.println("LIST - Person: " + p.toString()));

		System.out.println("***** MAP => entrySet() *****");
		Set<Entry<String, Person>> personEntrySet = personMap.entrySet();
		// personValSet.forEach(p -> System.out.println("SET - Person: " + p.toString()));
		personEntrySet.forEach(entry -> {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		});
		
		System.out.println("***** MAP => keySet() *****");
		Set<String> personKeySet = personMap.keySet();
		personKeySet.forEach(entry -> {
			System.out.println("Key: " + entry.toString());
		});

		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Maps - Basic");
		return response;

	}

}
