package com.joshparks.java.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.joshparks.java.model.Person;

public class CollectionUtil {

	public static List<Person> getPersonList() {
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(10, "Steve", "Steverson", 100, "Juneau", "AK", "M"));
		persons.add(new Person(20, "Josh", "Josherson", 200, "Portland", "OR", "F"));
		persons.add(new Person(30, "Mike", "Mikerson", 300, "Victor", "CO", "M"));
		persons.add(new Person(40, "Jim", "Jimerson", 400, "Gardiner", "MT", "F"));
		persons.add(new Person(50, "Scooby", "Doo", 500, "Westminster", "CA", "M"));
		persons.add(new Person(60, "NotJosh", "NotJosherson", 600, "Portland", "MA", "F"));
		
		return persons;
	}
	
	public static Map<String, Person> getPersonMap() {
		//Map<String, Person> personMap = new HashMap<String, Person>();
		List<Person> persons = getPersonList();
		//IntStream.range(0,persons.size()).boxed().collect(Collectors.toMap (i -> i, i -> persons.get(i)));
		Map<String, Person> personMap = persons.stream().collect(Collectors.toMap (person -> person.getFirstName(), person -> person));
		return personMap;
	}
	
}
