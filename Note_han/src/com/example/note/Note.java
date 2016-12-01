package com.example.note;

public class Note {
	private String ntitle;
	private String nbody;
	private String firstT;
	private String secondT;
	private String thirdT;
	
	public Note(){}
	
	public Note(String ntitle, String nbody, String firstT, String secondT, String thirdT) {
		super();
		this.ntitle = ntitle;
		this.nbody = nbody;
		this.firstT = firstT;
		this.secondT = secondT;
		this.thirdT = thirdT;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNbody() {
		return nbody;
	}
	public void setNbody(String nbody) {
		this.nbody = nbody;
	}
	public String getFirstT() {
		return firstT;
	}
	public void setFirstT(String firstT) {
		this.firstT = firstT;
	}
	public String getSecondT() {
		return secondT;
	}
	public void setSecondT(String secondT) {
		this.secondT = secondT;
	}
	public String getThirdT() {
		return thirdT;
	}
	public void setThirdT(String thirdT) {
		this.thirdT = thirdT;
	}
	
	
}
