package org.comstudy.myweb.model;

public class Saram {
	private int idx;
	private String name;
	
	public Saram() {
		// TODO Auto-generated constructor stub
	}
	
	public Saram(int idx, String name) {
		this.idx = idx;
		this.name = name;
	}
	
	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Saram [idx=" + idx + ", name=" + name + "]";
	}
}
