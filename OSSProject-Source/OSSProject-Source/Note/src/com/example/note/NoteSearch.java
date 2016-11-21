package com.example.note;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class NoteSearch extends Activity {
	EditText sEdt;
	private NotesDbAdapter mDbHelper;
	SQLiteDatabase database;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_search);
		
		sEdt = (EditText) findViewById(R.id.searchEdt);
		Button sBtn = (Button) findViewById(R.id.searchBtn);
		ListView rList = (ListView) findViewById(R.id.resultList);
		mDbHelper = new NotesDbAdapter(this);
		mDbHelper.open();
		
		sBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Cursor cursor = queryData();
				if(cursor != null){
					startManagingCursor(cursor);
					String[] columns = {"_id","title"};
					int [] resIds = {};
				}
			}
		});
		//리스트 아이템 만들기 부터 계속...
	}

	private Cursor queryData(){
		String str = sEdt.getText().toString();
		String sql = "select _id, title where "+str;
		Cursor cursor = database.rawQuery(sql, null);
		return cursor;
	}
}
