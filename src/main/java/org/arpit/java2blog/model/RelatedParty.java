package org.arpit.java2blog.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedParty{
    @JsonProperty("Name") 
    public String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@JsonProperty("age") 
	public int age;
}

