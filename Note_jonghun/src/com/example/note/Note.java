package com.example.note;

public class Note {
private String KEY_TITLE;
private String KEY_DATE;
public Note(String kEY_TITLE, String kEY_DATE) {
	super();
	KEY_TITLE = kEY_TITLE;
	KEY_DATE = kEY_DATE;
}
public String getKEY_TITLE() {
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
