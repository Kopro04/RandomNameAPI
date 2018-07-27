package org.koprowski.RandomNameAPI.Models;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Default data structure for a Name object
 * @author Michael Koprowski
 *
 */

@XmlRootElement
public class Name {
	private String name;	// First name
	private String surname;	// Last name
	private String gender;	// Gender associated with the name
	private String region;	// Country where the name is from
	
	public Name() {
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.region = "";
	}
	
	public Name(String name, String surname, String gender, String region) {
		this.name = name;
		this.surname = surname;
		this.gender =gender;
		this.region = region;				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof Name)) return false;
		
		Name other = (Name) obj;
		if(!this.name.equals(other.name) || 
				!this.surname.equals(other.surname)||
				!this.gender.equals(other.gender) || 
				!this.region.equals(other.region))
			return false;
		return true;
	}
}
