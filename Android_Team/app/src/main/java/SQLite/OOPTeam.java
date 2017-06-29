package sqlite;

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
	public static final String TABLE_NAME="team";
	
	public static final String KEY_ID= "_id";


	public static final String NAME_COLUMN= "name";
	public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "	+NAME_COLUMN+" TEXT NOT NULL)";
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
		long id=db.insert(TABLE_NAME,null,cv);
		user.id=(int)id;

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
		Team result=new Team(cursor.getInt(0),cursor.getString(1));
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

		Team a = new Team(0,"可....可惡");
		insert(a);
		Team b = new Team(1,"工海最爛一屆");
		insert(b);


	}
}