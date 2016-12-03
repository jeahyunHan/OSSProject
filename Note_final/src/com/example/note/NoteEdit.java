package com.example.note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

//lkkkkk
public class NoteEdit extends Activity {
	
	public static int numTitle = 1;	
	public static String curDate = "";
	public static String curText = "";	
    private EditText mTitleText;
    private EditText mBodyText;
    private TextView mDateText;
    private Long mRowId;
    private EditText edittext1;
    private EditText edittext2;
    private EditText edittext3;
	Typeface face;

    
    private Cursor note;

    private NotesDbAdapter mDbHelper;
	ArrayList<String> arrayFontlist;
	ArrayList<String> arrayColorlist;

    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();        
        
        setContentView(R.layout.note_edit);
        setTitle(R.string.app_name);

        mTitleText = (EditText) findViewById(R.id.title);
        mBodyText = (EditText) findViewById(R.id.body);
        mDateText = (TextView) findViewById(R.id.notelist_date);
        edittext1=(EditText)findViewById(R.id.edt1);
        edittext2=(EditText)findViewById(R.id.edt2);
        edittext3=(EditText)findViewById(R.id.edt3);
		
        arrayFontlist = new ArrayList<String>();
        arrayFontlist.add("MALGUN");
        arrayFontlist.add("GABRIOLA");
        arrayFontlist.add("IMPACT");

        arrayColorlist = new ArrayList<String>();
        arrayColorlist.add("Black");
        arrayColorlist.add("Red");
       
        arrayColorlist.add("Blue");
        ArrayAdapter<String> Cadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayColorlist);
        ArrayAdapter<String> Fadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayFontlist);
        
        
        
        Spinner Csp = (Spinner)this.findViewById(R.id.colorspin);
		Csp.setPrompt("color");
		//力格
		Csp.setAdapter(Cadapter);
		Csp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				if(arrayColorlist.get(position) == "Black"){
					mBodyText.setTextColor(Color.BLACK);
				}else if(arrayColorlist.get(position) == "Red"){
					mBodyText.setTextColor(Color.RED);
				}else if(arrayColorlist.get(position) == "Blue"){
					mBodyText.setTextColor(Color.BLUE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
        Spinner Fsp = (Spinner)this.findViewById(R.id.fontspin);
		Fsp.setPrompt("font");
		//力格
		Fsp.setAdapter(Fadapter);
		Fsp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				face = Typeface.createFromAsset(getAssets(), "fonts/"+arrayFontlist.get(position)+".TTF");
				mBodyText.setTypeface(face);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
        
        long msTime = System.currentTimeMillis();  
        Date curDateTime = new Date(msTime);
 	
        SimpleDateFormat formatter = new SimpleDateFormat("d'/'M'/'y");  
        curDate = formatter.format(curDateTime);        
        
        mDateText.setText(""+curDate);
        

        mRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(NotesDbAdapter.KEY_ROWID);
        if (mRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRowId = extras != null ? extras.getLong(NotesDbAdapter.KEY_ROWID)
                                    : null;
        }

        populateFields();
        
 
        
        
    }
	
	  public static class LineEditText extends EditText{
			// we need this constructor for LayoutInflater
			public LineEditText(Context context, AttributeSet attrs) {
				super(context, attrs);
					mRect = new Rect();
			        mPaint = new Paint();
			        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			        mPaint.setColor(Color.BLUE);
			}

			private Rect mRect;
		    private Paint mPaint;	    
		    
		    @Override
		    protected void onDraw(Canvas canvas) {
		  
		        int height = getHeight();
		        int line_height = getLineHeight();

		        int count = height / line_height;

		        if (getLineCount() > count)
		            count = getLineCount();

		        Rect r = mRect;
		        Paint paint = mPaint;
		        int baseline = getLineBounds(0, r);

		        for (int i = 0; i < count; i++) {

		            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
		            baseline += getLineHeight();

		        super.onDraw(canvas);
		    }

		}
	  }
	  
	  @Override
	    protected void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        saveState();
	        outState.putSerializable(NotesDbAdapter.KEY_ROWID, mRowId);
	    }
	    
	    @Override
	    protected void onPause() {
	        super.onPause();
	        saveState();
	    }
	    
	    @Override
	    protected void onResume() {
	        super.onResume();
	        populateFields();
	    }
	    
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.noteedit_menu, menu);
			return true;		
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    case R.id.menu_about:
		          
		    	/* Here is the introduce about myself */	    	
		        AlertDialog.Builder dialog = new AlertDialog.Builder(NoteEdit.this);
		        dialog.setTitle("About");
		        dialog.setMessage("Hello! I'm Heng, the creator of this application. This application is created for learning." +
		           		" Using it on trading or any others activity that is related to business is strictly forbidden."
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
		    case R.id.menu_delete:
				if(note != null){
	    			note.close();
	    			note = null;
	    		}
	    		if(mRowId != null){
	    			mDbHelper.deleteNote(mRowId);
	    		}
	    		finish();
		    	
		        return true;
		    case R.id.menu_save:
	    		saveState();
	    		finish();	    	
		    default:
		    	return super.onOptionsItemSelected(item);
		    }
		}
	    
	    private void saveState() {
	        String title = mTitleText.getText().toString();
	        String body = mBodyText.getText().toString();
	        String hash = edittext1.getText().toString();
	        String hashh = edittext2.getText().toString();
	        String hashhh= edittext3.getText().toString();

	        if(mRowId == null){
	        	long id = mDbHelper.createNote(title, body,hash,hashh,hashhh, curDate);
	        	if(id > 0){
	        		mRowId = id;
	        	}else{
	        		Log.e("saveState","failed to create note");
	        	}
	        }else{
	        	if(!mDbHelper.updateNote(mRowId, title, body,hash,hashh,hashhh, curDate)){
	        		Log.e("saveState","failed to update note");
	        	}
	        }
	    }
	    
	  
	    private void populateFields() {
	        if (mRowId != null) {
	            note = mDbHelper.fetchNote(mRowId);
	            startManagingCursor(note);
	            mTitleText.setText(note.getString(
	    	            note.getColumnIndexOrThrow(NotesDbAdapter.KEY_TITLE)));
	            mBodyText.setText(note.getString(
	                    note.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY)));
	            edittext1.setText(note.getString(note.getColumnIndexOrThrow(NotesDbAdapter.KEY_HASH)));
	            edittext2.setText(note.getString(note.getColumnIndexOrThrow(NotesDbAdapter.KEY_HASHH)));
	            edittext3.setText(note.getString(note.getColumnIndexOrThrow(NotesDbAdapter.KEY_HASHHH)));
	            curText = note.getString(
	                    note.getColumnIndexOrThrow(NotesDbAdapter.KEY_DATE));
	            
	        }
	    }

}
