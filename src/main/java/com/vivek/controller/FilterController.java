package com.vivek.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vivek.dao.SomeBean;

@RestController
public class FilterController {
	
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mapping.setFilters(filters);		
		return  someBean;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBeans(){
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value12","value22","value32"));
	}

}
