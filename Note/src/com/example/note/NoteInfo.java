package com.example.note;
//노트인포 객체 를 정의하기위한 클래스이다.
public class NoteInfo {
	private String title;

	public NoteInfo(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
