package org.comstudy.model;

public class Saram {
	int idx;
	String id;
	String name;
	
	
	
	public Saram() {

		this(0,"","");
	}



	public Saram(int idx, String id, String name) {
		
		this.idx = idx;
		this.id = id;
		this.name = name;
	}



	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Saram [idx=" + idx + ", id=" + id + ", name=" + name + "]";
	}
	
	
}
