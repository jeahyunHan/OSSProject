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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
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
 	ArrayAdapter<NoteInfo> noteAdapter;
 	
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_search);
		
		
		sEdt = (EditText) findViewById(R.id.searchEdt);
		list = (ListView) findViewById(R.id.list);
		Button sBtn = (Button) findViewById(R.id.searchBtn);
		
		
		mDbHelper = new NotesDbAdapter(this);
		mDbHelper.open();
		database = mDbHelper.getReadable();
		
//		te = (TextView) findViewById(R.id.tv);
	
		
		sBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				String title = sEdt.getText().toString();
//				te.setText(mDbHelper.PrintData(title));
				String hash = sEdt.getText().toString();
				String str = "";
				Cursor cursor = database.rawQuery("select * from notes where hash = '"+hash+"';", null);
				
		
	  
				while(cursor.moveToNext()){
					////////////////////////////////중간
					str += 
			    			cursor.getInt(0)
			    			+ ":_id"
			    			+ cursor.getString(1)
			    			+ " : title "
			    			+cursor.getString(2)
			    			+ " : body"
							+cursor.getString(3)
							+ ":hash";
					te.setText(str);
					//////////////////////////////////////					
					
					
//					System.out.println("4545454545");
//					String body = cursor.getString(2);
//					te.setText(body);
//					String id = cursor.getString(cursor.getColumnIndex("_id"));
//					String title = cursor.getString(cursor.getColumnIndex("title"));
					
	
					list.setOnItemClickListener(new OnItemClickListener() {
						
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
							
							
							
							
						}
					});
				}
				
				
			}
		});
		//리스트 아이템 만들기 부터 계속...
	}
	
	
	
	
	
	
	
}
