package SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DB";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "";
		sql += "CREATE TABLE PRODOTTI (";
		sql += " _id INTEGER PRIMARY KEY AUTOINCREMENT,";
		sql += " NOME TEXT NOT NULL,";
		sql += " BIDONE TEXT NOT NULL";
		sql += ")";
		
		db.execSQL(sql);
		
		
		String sql2 = "";
		sql2 += "CREATE TABLE BIDONI (";
		sql2 += " _id INTEGER PRIMARY KEY AUTOINCREMENT,";
		sql2 += " NOME TEXT NOT NULL,";
		sql2 += " FOREIGN KEY (NOME) REFERENCES PRODOTTI (BIDONE)";
		sql2 += ")";

		db.execSQL(sql2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//
		
	}


}
