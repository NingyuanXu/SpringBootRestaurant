package com.in28minutes.database.databasedemo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_restaurants", query="select r from Restaurant r")
public class Restaurant  {

	@Id
	@GeneratedValue
	private int id;
    private String name;
    private int star_level;
    private String address;

	public Restaurant() {

	}
	
	public Restaurant(int id, String name, int star_level, String address) {
        super();
		this.id = id;
        this.name = name;
        this.star_level = star_level;
        this.address = address;
    }

	public Restaurant(String name, int star_level, String address) {
        super();
        this.name = name;
        this.star_level = star_level;
        this.address = address;
    }
	
	@Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", star_level=" + star_level +
                ", address='" + address + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar_level() {
        return star_level;
    }

    public void setStar_level(int star_level) {
        this.star_level = star_level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}