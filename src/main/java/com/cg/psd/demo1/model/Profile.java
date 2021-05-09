package com.cg.psd.demo1.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name="profile", propOrder={"id", "name"})
@Document(collection = "profile")
public class Profile {

	@Id
	@JsonIgnore
//	@NotNull
	private String id;
	
	@JsonProperty
//	@XmlElement
//	@Size(min = 3)
	private String name;

	public Profile(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profile() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.name.equals(((Profile)obj).getName());
	}

}
