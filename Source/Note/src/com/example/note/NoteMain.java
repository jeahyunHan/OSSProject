package com.example.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NoteMain extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_main);
		Button sBtn = (Button) findViewById(R.id.searchBtn);
		Button mBtn = (Button) findViewById(R.id.memoBtn);
		
		
		sBtn.setOnClickListener(new View.OnClickListener() {
			Intent i1;
			@Override
			public void onClick(View v) {
				i1 = new Intent(NoteMain.this,NoteSearch.class);
				startActivity(i1);
			}
		});
		mBtn.setOnClickListener(new View.OnClickListener() {
			Intent i2;
			@Override
			public void onClick(View v) {
				i2 = new Intent(NoteMain.this,NoteList.class);
				startActivity(i2);
			}
		});
		
	}
	
}
