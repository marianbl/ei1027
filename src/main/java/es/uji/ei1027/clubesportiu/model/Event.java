package es.uji.ei1027.clubesportiu.model;


import java.util.Set;
import java.util.HashSet;

public class Event {
    
	String name;
    String description;
    String type;
    Set<Standing> standings = new HashSet<Standing>();

	public String getName() { return name; }
	public void setName(String name) { this.name = name; } 
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; } 
	public String getType() { return type; }
	public void setType(String type) { this.type = type; } 

    @Override
	public String toString() {
		return "Prova [name=" + name + ", description=" + description + ", type="
				+ type + ", standings=" + standings + "]";
	}

}
