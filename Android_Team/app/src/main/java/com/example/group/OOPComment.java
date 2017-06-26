package com.example.group;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;

public class OOPComment {

	public static final String TABLE_NAME="comment";
	
	public static final String KEY_ID= "_id";

	public static final String ORDER_COLUMN= "order";
	public static final String NAME_COLUMN= "name";
	public static final String CONT_COLUMN= "context";
	public static final String ID_COLUMN= "id";
	public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ORDER_COLUMN+" INTEGER NOT NULL, "
			+CONT_COLUMN+" TEXT NOT NULL, "+NAME_COLUMN+" TEXT NOT NULL"+
			ID_COLUMN+" INTEGER NOT NULL)";
	private SQLiteDatabase db;

	public static ArrayList<User> usersList=new ArrayList<>();


	public OOPComment(Context context){
		db=UserDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public Comment insert(Comment comment){
		ContentValues cv=new ContentValues();


		cv.put(ORDER_COLUMN,comment.order);
		cv.put(NAME_COLUMN,comment.name);
		cv.put(CONT_COLUMN,comment.context);
		cv.put(ID_COLUMN,comment.group_id);
		db.insert(TABLE_NAME,null,cv);


		return comment;
	}

	public List<Comment> getAll() {
		List<Comment> result = new ArrayList<>();
		Cursor cursor = db.query(
				TABLE_NAME, null, null, null, null, null, null, null);

		while (cursor.moveToNext()) {
			result.add(getRecord(cursor));
		}

		cursor.close();
		return result;
	}

	public Comment getRecord(Cursor cursor){
		Comment result=new Comment(cursor.getInt(1),cursor.getString(2),cursor.getInt(4),cursor.getString(3));
		return result;
	}

	public int getCount(){
		int result =0;
		Cursor cursor=db.rawQuery("SELECT COUNT(*) FROM"+TABLE_NAME,null);
		while(cursor.moveToNext()){
			result=cursor.getInt(0);
		}
		return result;
	}



	public void loadSample(){

		Comment a = new Comment(0,"LOGOO",0,"72727272");
		insert(a);
		Comment b = new Comment(1,"11person",1,"library");
		insert(b);
		Comment c = new Comment(2,"YoChen",2,"chin");
		insert(b);


	}
}