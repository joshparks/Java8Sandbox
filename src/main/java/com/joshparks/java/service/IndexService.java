package com.joshparks.java.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.joshparks.java.model.Person;
import com.joshparks.java.util.CollectionUtil;
import com.joshparks.java.util.PersonPredicates;

@Service
public class IndexService {

	public Map<String, String> testStreamBasics() {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		System.out.println("Stream => Starts with C...");
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		System.out.println("Stream => Find First...");
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1

		System.out.println("Stream => Range(1,4)...");
		IntStream.range(1, 4).forEach(System.out::println);

		System.out.println("Stream => MapToInt...");
		Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println); // 3

		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "It Worked Again!");
		return response;

	}

	public Map<String, String> testStreamReuse() {
		
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

		stream.anyMatch(s -> true); // ok

		try {
			stream.noneMatch(s -> true); // exception
		} catch (Exception e) {
			System.out.println("Stream => Reuse Exception => Cant use terminated stream...");
			e.printStackTrace();
		}

		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Stream => Test Re-Use");
		return response;
	}
	
	public Map<String, String> testStreamMaps() {
			
		System.out.println("Stream => Maps => FirstName (forEach)...");
		List<Person> persons = CollectionUtil.getPersonList();
		persons.stream().map(Person::getFirstName).forEach(System.out::println);
		
		System.out.println("Stream => Maps => FirstName (forEach/lambda)...");
		List<Person> persons2 = CollectionUtil.getPersonList();
		persons2.stream().map(p -> p.getFirstName()).forEach(System.out::println);
		
		System.out.println("Stream => Maps => Sorted...");
		List<Person> persons3 = CollectionUtil.getPersonList();
		List<String> fNmList = persons3.stream().map(Person::getFirstName).sorted().collect(Collectors.toList());
		System.out.println(fNmList.toString());
		
		System.out.println("Stream => Maps => Sorted(reverse)...");
		List<Person> persons4 = CollectionUtil.getPersonList();
		List<String> fNmListRev = persons4.stream().map(Person::getFirstName).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(fNmListRev.toString());
		
		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Stream => Test Maps");
		return response;
	}
	
	public Map<String, String> testStreamFilters() {
		
		System.out.println("Stream => Filter => Over 20...");
		List<Person> persons = CollectionUtil.getPersonList();
		persons.stream().filter(p -> p.getAge() > 20).forEach(per -> System.out.println(per.getFirstName()));
		
		System.out.println("Stream => Filter => Not Josh...");
		List<Person> persons1 = CollectionUtil.getPersonList();
		persons1.stream().filter(p -> !p.getFirstName().equals("Josh")).forEach(per -> System.out.println(per.getFirstName()));
		
		System.out.println("Stream => Filter => Starts With J...");
		List<Person> persons3 = CollectionUtil.getPersonList();
		persons3.stream().filter(p -> p.getFirstName().startsWith("J")).forEach(per -> System.out.println(per.getFirstName()));
		
		System.out.println("Stream => Filter => Contains Josh...");
		List<Person> persons4 = CollectionUtil.getPersonList();
		boolean hasJosh = persons4.stream().filter(p -> p.getFirstName().startsWith("J")).anyMatch(p -> p.getFirstName().equals("Josh"));
		System.out.println(hasJosh);
		
		System.out.println("Stream => Filter => Contains Josh (filtered)...");
		List<Person> persons5 = CollectionUtil.getPersonList();
		boolean hasJoshFiltered = persons5.stream().filter(p -> !p.getFirstName().startsWith("J")).anyMatch(p -> p.getFirstName().equals("Josh"));
		System.out.println(hasJoshFiltered);		
		
		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Stream => Test Filters");
		return response;
	}
	
	public Map<String, String> testStreamCollectors() {
		
		System.out.println("Stream => Collectors => toList...");
		List<Person> persons = CollectionUtil.getPersonList();
		List<String> cityList = persons.stream().map(p -> p.getCity()).distinct().collect(Collectors.toList());
		System.out.println(cityList.toString());

		System.out.println("Stream => Collectors => toSet...");
		List<Person> persons1 = CollectionUtil.getPersonList();
		Set<String> citySet = persons1.stream().map(p -> p.getCity()).distinct().collect(Collectors.toSet());
		System.out.println(citySet.toString());

		System.out.println("Stream => Collectors => toMap...");
		List<Person> persons2 = CollectionUtil.getPersonList();
		Map<String, String> cityPersonMap = persons2.stream().collect(Collectors.toMap(Person::getFirstName,Person::getCity));
		System.out.println(cityPersonMap.toString());
		
		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Stream => Test Collectors");
		return response;
	}
	
	public Map<String, String> testStreamPredicates() {
		
		List<Person> persons = CollectionUtil.getPersonList();
		
		System.out.println("Stream => Predicates => Adult-Male...");
		List<Person> adultMales = PersonPredicates.filterEmployees(persons, PersonPredicates.isAdultMale());
		adultMales.forEach(p -> System.out.println(p.getFirstName() + ", " + p.getGender()));
        
		System.out.println("Stream => Predicates => Adult-Female...");
		List<Person> adultFemales = PersonPredicates.filterEmployees(persons, PersonPredicates.isAdultFemale());
		adultFemales.forEach(p -> System.out.println(p.getFirstName() + ", " + p.getGender()));
         
        System.out.println("Stream => Predicates => Over 35...");
        List<Person> over35 = PersonPredicates.filterEmployees(persons, PersonPredicates.isAgeMoreThan(35));
		over35.forEach(p -> System.out.println(p.getFirstName() + ", " + p.getAge()));
     		
		Map<String, String> response = new HashMap<String, String>();
		response.put("Test", "Stream => Test Predicates");
		return response;
	}

}
