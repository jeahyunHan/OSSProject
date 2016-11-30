package com.example.note;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NoteListViewAdapter extends BaseAdapter{ // 노트 리스트뷰 어댑터  (( 실시간으로 검색결과를 뿌려주기위함)

	Context context;
	LayoutInflater inflater;
	private List<Note> noteList=null; //노트클래스 리스트 선언  null로 초기화
	private ArrayList<Note> arrayList; //배열리스트 사용

	public NoteListViewAdapter(Context context,List<Note> noteList) {
	
		this.context = context;
		
		this.noteList = noteList;
		inflater=LayoutInflater.from(context);
		this.arrayList = new ArrayList<Note>();
		this.arrayList.addAll(noteList);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
