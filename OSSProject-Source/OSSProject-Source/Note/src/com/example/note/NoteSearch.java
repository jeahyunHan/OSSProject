package com.example.note;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class NoteSearch extends Activity {
	EditText sEdt;
	TextView te;
	ListView list;
	TextView ttv,itv;
	
	
	private NotesDbAdapter mDbHelper;
	SQLiteDatabase database;
	
	ListAdapter adapter;
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_search);
		
		sEdt = (EditText) findViewById(R.id.searchEdt);
//		te = (TextView) findViewById(R.id.tv);
		list = (ListView) findViewById(R.id.list);
		Button sBtn = (Button) findViewById(R.id.searchBtn);
		
		
		mDbHelper = new NotesDbAdapter(this);
		mDbHelper.open();
		database = mDbHelper.getReadable();
		
		
		sBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				String title = sEdt.getText().toString();
//				te.setText(mDbHelper.PrintData(title));
				String hash = sEdt.getText().toString();
//				String str = "";
				Cursor cursor = database.rawQuery("select * from notes where hash = '"+hash+"';", null);
				
		
	  
	            //화면에 보여주기 위해 Listview에 연결합니다.  
				while(cursor.moveToNext()){
					System.out.println("4545454545");
					//String body = cursor.getString(2);
					//te.setText(body);
//					str += 
//			    			cursor.getInt(0)
//			    			+ ":_id"
//			    			+ cursor.getString(1)
//			    			+ " : title "
//			    			+cursor.getString(2)
//			    			+ " : body";
//					te.setText(str);
					String id = cursor.getString(cursor.getColumnIndex("_id"));
					String title = cursor.getString(cursor.getColumnIndex("title"));
					
	
				}
				
				
			}
		});
		//리스트 아이템 만들기 부터 계속...
	}
	
	
	
	
	
	
	
}
