package com.example.note;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;

public class NoteList extends ListActivity {
	private NoteListViewAdapter adapter;
	EditText editsearch;
	private static final int ACTIVITY_CREATE=0;
    private static final int ACTIVITY_EDIT=1;
    SQLiteDatabase database;
    ListView listView;
    
    List<Note> noteList;
    Cursor cursor;
    EditText searchInput;
    Button searchButton;
	
    private static final int DELETE_ID = Menu.FIRST;
	private int mNoteNumber = 1;
	ArrayAdapter<Note> noteAdapter;
	private NotesDbAdapter mDbHelper;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notelist);
		init();
		editsearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	
		mDbHelper = new NotesDbAdapter (this);
		mDbHelper.open();
		fillData();			
		database = mDbHelper.getReadable();
		registerForContextMenu(getListView());
		Button addnote = (Button)findViewById(R.id.addnotebutton);
		searchButton=(Button)findViewById(R.id.searchBtn);
		searchInput=(EditText)findViewById(R.id.searchInput);
		addnote.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				createNote();
				}
		});
		
	}
	
	public void init(){
		noteList = new List<Note>();
		adapter=new NoteListViewAdapter(this,noteList);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notelist_menu, menu);
		return true;		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_about:
	          
	           AlertDialog.Builder dialog = new AlertDialog.Builder(NoteList.this);
	           dialog.setTitle("About");
	           dialog.setMessage("Hello! I'm Heng, the creator of this application. This application is created based on learning." +
	           		" Used it on trading or any others activity that is related to business is strictly forbidden."
	        		   +"If there is any bug is found please freely e-mail me. "+
	           			"\n\tedisonthk@gmail.com"
	        		   );
	           dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
	        	   @Override
	        	   public void onClick(DialogInterface dialog, int which) {
	        		   dialog.cancel();
					
	        	   }
	           });
	           dialog.show();	           
	           return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	
	private void createNote() {
		Intent i = new Intent(this, NoteEdit.class);
        startActivityForResult(i, ACTIVITY_CREATE);    	
    }
	
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, NoteEdit.class);
        i.putExtra(NotesDbAdapter.KEY_ROWID, id);
        startActivityForResult(i, ACTIVITY_EDIT);
    }

	private void fillData() {
        // Get all of the notes from the database and create the item list
        Cursor notesCursor = mDbHelper.fetchAllNotes();
        startManagingCursor(notesCursor);
        

        String[] from = new String[] { NotesDbAdapter.KEY_TITLE ,NotesDbAdapter.KEY_DATE};
        int[] to = new int[] { R.id.no_title ,R.id.date_row};
        
        // Now create an array adapter and set it to display using our row
        SimpleCursorAdapter notes =
            new SimpleCursorAdapter(this, R.layout.notes_row, notesCursor, from, to);
        setListAdapter(notes);
    }
//	private void SearchedFillData() {
//        // Get all of the notes from the database and create the item list
//        Cursor notesCursor = mDbHelper.fetchAllNotes();
//        startManagingCursor(notesCursor);
//        
//
//        String[] from = new String[] { NotesDbAdapter.KEY_TITLE ,NotesDbAdapter.KEY_DATE};
//        int[] to = new int[] { R.id.text1 ,R.id.date_row};
//        
//        // Now create an array adapter and set it to display using our row
//        SimpleCursorAdapter notes =
//            new SimpleCursorAdapter(this, R.layout.notes_row, notesCursor, from, to);
//        setListAdapter(notes);
//    }
//	
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, R.string.menu_delete);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case DELETE_ID:
                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
                mDbHelper.deleteNote(info.id);
                fillData();
                return true;
        }
        return super.onContextItemSelected(item);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        fillData();        
    }   

    
}
