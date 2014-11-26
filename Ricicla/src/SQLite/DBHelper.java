package SQLite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	public static final String PT_NAME = "PRODOTTI";
	public static final String P_ID = "_id";
	public static final String P_NAME = "NOME";
	public static final String PB_NAME = "BIDONE";
	
	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DB";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE IF NOT EXISTS"+PT_NAME+"(" +P_ID+"INTEGER PRIMARY KEY AUTOINCREMENT," +
				P_NAME+" VARCHAR,"+PB_NAME+" VARCHAR);");
	
	}
	
	public ArrayList getAllProduct(){
	      ArrayList array_list = new ArrayList();
	      SQLiteDatabase db = this.getReadableDatabase();
	      Cursor res =  db.rawQuery( "select * from PRODOTTI", null);
	      res.moveToFirst();
	      while(res.isAfterLast() == false){
	      array_list.add(res.getString(res.getColumnIndex(P_NAME)));
	      res.moveToNext();
	      }
	   return array_list;
	   }
	
	public ArrayList getAllGarbage(){
	      ArrayList array_list = new ArrayList();
	      SQLiteDatabase db = this.getReadableDatabase();
	      Cursor res =  db.rawQuery( "select distinct (bidone) from PRODOTTI", null);
	      res.moveToFirst();
	      while(res.isAfterLast() == false){
	    	  array_list.add(res.getString(res.getColumnIndex(PB_NAME)));
	    	  res.moveToNext();
	      }
	   return array_list;
	   }
	
	public ArrayList getSpecProds(String nome){
		ArrayList<String> array_list = new ArrayList();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select NOME from PRODOTTI where bidone='"+nome+"'", null);
		res.moveToFirst();
	    while(res.isAfterLast() == false){
	    	array_list.add(res.getString(res.getColumnIndex(P_NAME)));
	    	res.moveToNext();
	      }
	   return array_list;				
	}
	
	public String getSpecGarb(String nome){
		String str = null;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select bidone from prodotti where nome='"+nome+"'", null);
		res.moveToFirst();
		str = res.getString(res.getColumnIndex(PB_NAME));
		return str;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
