package models;

import java.util.Date;

public class GuestBookEntry {
	static int count = 0;
	String name; 
	String message;
	String host;
	int id;
	Date created;
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.created = new Date();
		this.id = count++;
	}
	
	public GuestBookEntry(int id, String name, String message) {
		this.id = id;
		this.name = name;
    this.message = message;
    this.created = new Date();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
