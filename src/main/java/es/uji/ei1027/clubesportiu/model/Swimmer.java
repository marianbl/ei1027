package es.uji.ei1027.clubesportiu.model;

import java.util.Set;
import java.util.HashSet;


public class Swimmer implements Comparable<Swimmer>{

	String name;
	String fedId;
	String country;
	int age;
	String sex;
	Set<Standing> standings = new HashSet<Standing>();
		
	public String getName() { return name; }
	public void setName(String name) { this.name = name; } 
	public String getFedId() { return fedId; }
	public void setFedId(String fedId) { this.fedId = fedId; } 
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; } 
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; } 
	public String getSex() { return sex; }
	public void setSex(String sex) { this.sex = sex; } 
	public Category getCategory () {
		Category category;
		if (age < 12) 
			category = Category.ALEVI;
		else if (age < 14) 
			category = Category.JUVENIL;
		else if (age < 16)
			category = Category.CADET;
		else if (age < 18) 
			category = Category.JUNIOR;
		else 
			category = Category.SENIOR; 
 		return category;
	}
	
	@Override
	public String toString() {
		return "Swimmer [name=" + name + ", fedId=" + fedId + ", age="
				+ age + ", sex=" + sex + ", standings="
				+ standings + "]";
	} 
	
	public int compareTo(Swimmer other) {
	    return this.getName().compareTo(other.getName());    
	}

}
