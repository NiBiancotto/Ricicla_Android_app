package SQLite;


import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

public class DBAdapter {
	private static final String LOG = DBAdapter.class.getSimpleName();
	
	@SuppressWarnings("unused")
	private Context context;
	private DBHelper helper;
	private SQLiteDatabase db;
	
	public static final String PT_NAME = "PRODOTTI";
	public static final String P_ID = "_id";
	public static final String P_NAME = "NOME";
	public static final String PB_NAME = "BIDONE";
	
	public static final String VT_NAME = "VIE";
	public static final String V_ID = "_id";
	public static final String V_NAME = "NOME";
	public static final String VZ_NAME = "ZONA";

	public DBAdapter(Context context){
		this.context = context;
		Log.i(LOG, "costruttore");
		helper = DBHelper.getInstance(context);
		
	}

	public void open() throws SQLException {

		db = helper.getWritableDatabase();
		Log.i(LOG, "open." + db.toString());
	}
	
	public void close() {
		Log.i(LOG, "close");
		helper.close();
	}

	public void createProducts(String name, String garb) {
		ContentValues values = new ContentValues();
		values.put(P_NAME, name);
		values.put(PB_NAME, garb);
		
		SQLiteDatabase database = helper.getWritableDatabase();
		database.insert("PRODOTTI", null, values);
		database.close();	
		
	}
	
	public void createVie(String name, String zn) {
		ContentValues values = new ContentValues();
		values.put(V_NAME, name);
		values.put(VZ_NAME, zn);
		
		SQLiteDatabase database = helper.getWritableDatabase();
		database.insert("VIE", null, values);
		database.close();	
		
	}
	
	public ArrayList<String> fetchProduct() {
		SQLiteDatabase database = helper.getReadableDatabase();
		ArrayList <String> prd = new ArrayList <String>();
		Cursor cursor = database.query(PT_NAME, new String[] { P_NAME }, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			 prd.add(cursor.getString(cursor.getColumnIndex(P_NAME)));
			 cursor.moveToNext();
			 }
		return prd;
		
	}
	
	public ArrayList<String> fetchGarbage() {
		SQLiteDatabase database = helper.getReadableDatabase();
		ArrayList <String> grb = new ArrayList <String>();
		Cursor cursor = database.rawQuery( "select distinct (bidone) from PRODOTTI", null);
		
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			 grb.add(cursor.getString(cursor.getColumnIndex(PB_NAME)));
			 cursor.moveToNext();
			 }
		return grb;	
		
	}
	
	public ArrayList<String> fetchVie() {
		SQLiteDatabase database = helper.getReadableDatabase();
		ArrayList <String> zn = new ArrayList <String>();
		Cursor cursor = database.query(VT_NAME, new String[] { V_NAME }, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			 zn.add(cursor.getString(cursor.getColumnIndex(V_NAME)));
			 cursor.moveToNext();
			 }
		return zn;	
		
	}
	
	public ArrayList<String> fetchZone() {
		SQLiteDatabase database = helper.getReadableDatabase();
		ArrayList <String> zn = new ArrayList <String>();
		Cursor cursor = database.rawQuery( "select distinct (zona) from VIE", null);
		
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			 zn.add(cursor.getString(cursor.getColumnIndex(VZ_NAME)));
			 cursor.moveToNext();
			 }
		return zn;	
		
	}
	
	public String fetchAGarbage(String nome) {
		SQLiteDatabase database = helper.getReadableDatabase();
		String grb = null;
		Cursor cursor = database.rawQuery("select BIDONE from PRODOTTI where nome='"+nome+"'", null);
		
		cursor.moveToFirst();
		grb = cursor.getString(cursor.getColumnIndex(PB_NAME));
		return grb;		
	}
	
	public String fetchAZona(String nome) {
		SQLiteDatabase database = helper.getReadableDatabase();
		String zn = null;
		Cursor cursor = database.rawQuery("select ZONA from VIE where nome='"+nome+"'", null);
		
		cursor.moveToFirst();
		zn = cursor.getString(cursor.getColumnIndex(VZ_NAME));
		return zn;		
	}
	
	public ArrayList<String> fetchAProduct(String bdn) {
		SQLiteDatabase database = helper.getReadableDatabase();
		ArrayList <String> prd = new ArrayList <String>();
		Cursor cursor = database.rawQuery("select NOME from PRODOTTI where bidone='"+bdn+"'", null);
		
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			 prd.add(cursor.getString(cursor.getColumnIndex(P_NAME)));
			 cursor.moveToNext();
			 }
		return prd;
		
	}
	
	public int countProd(){
		SQLiteDatabase database = helper.getReadableDatabase();
		Cursor cursor = database.rawQuery("select * from prodotti", null);
		int count = cursor.getCount();
		return count;
	}
	
	public int countVie(){
		SQLiteDatabase database = helper.getReadableDatabase();
		Cursor cursor = database.rawQuery("select * from vie", null);
		int count = cursor.getCount();
		return count;
	}
	
}