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

public class OOPTeam {
	public static final String TABLE_NAME="user";
	
	public static final String KEY_ID= "_id";

	public static final String ACCOUNT_COLUMN= "account";
	public static final String PW_COLUMN= "password";
	public static final String NAME_COLUMN= "name";
	public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ACCOUNT_COLUMN+" TEXT NOT NULL, "
			+PW_COLUMN+" TEXT NOT NULL, "+NAME_COLUMN+" TEXT NOT NULL)";
	private SQLiteDatabase db;

	public static ArrayList<Team> usersList=new ArrayList<>();


	public OOPTeam(Context context){
		db=UserDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public Team insert(Team user){
		ContentValues cv=new ContentValues();

		cv.put(KEY_ID,user.id);
		cv.put(ACCOUNT_COLUMN,user.account);
		cv.put(PW_COLUMN,user.password);
		long id=db.insert(TABLE_NAME,null,cv);
		user.id=(int)id;

		return user;
	}
	public Team get(String account,String password){
		Team user=null;

		String where=ACCOUNT_COLUMN+" = \'"+account+"\' AND "+PW_COLUMN+" = "+password;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			user=getRecord(result);

		}
		result.close();
		return user;
	}
	public List<Team> getAll() {
		List<Team> result = new ArrayList<>();
		Cursor cursor = db.query(
				TABLE_NAME, null, null, null, null, null, null, null);

		while (cursor.moveToNext()) {
			result.add(getRecord(cursor));
		}

		cursor.close();
		return result;
	}

	public Team getRecord(Cursor cursor){
		Team result=new Team(cursor.getInt(0),cursor.getString(3),cursor.getString(1),cursor.getString(2));
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

		Team a = new Team(0,"LOGOO","b04505009@ntu.edu.tw","72727272");
		insert(a);
		Team b = new Team(1,"11person","b045050022@ntu.edu.tw","library");
		insert(b);
		Team c = new Team(2,"YoChen","b045050002@ntu.edu.tw","chin");
		insert(c);


	}
}