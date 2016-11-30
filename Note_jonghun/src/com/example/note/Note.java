package com.example.note;

public class Note {  // 노트 클래스 생성
private String KEY_TITLE; //변수선언
private String KEY_DATE;  // 변수선언
public Note(String kEY_TITLE, String kEY_DATE) {
	super();
	KEY_TITLE = kEY_TITLE;
	KEY_DATE = kEY_DATE;
}
public String getKEY_TITLE() { //  겟셋 
	return KEY_TITLE;
}
public void setKEY_TITLE(String kEY_TITLE) {
	KEY_TITLE = kEY_TITLE;
}
public String getKEY_DATE() {
	return KEY_DATE;
}
public void setKEY_DATE(String kEY_DATE) {
	KEY_DATE = kEY_DATE;
}

 
}
