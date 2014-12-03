package SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private static DBHelper instance;

	static String LOG = "DBHelper";
	public static final boolean DEBUG = true;
	public static final String VT_NAME = "VIE";
	public static final String PT_NAME = "PRODOTTI";
	public static final String P_ID = "_id";
	public static final String P_NAME = "NOME";
	public static final String PB_NAME = "BIDONE";
	
	public static final String LOG_TAG = "DBAdapter";
	private static final int DATABASE_VERSION = 3;
	private static final String DATABASE_NAME = "DBase.db";
	private static final String CREATE_PRODOTTI = "create table PRODOTTI (_id integer primary key autoincrement, NOME text not null, "
			+ "BIDONE string not null)";
	private static final String CREATE_VIE = "create table VIE (_id integer primary key autoincrement, NOME text not null, "
			+ "ZONA string not null)";

	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.i(LOG, "costruttore");

	}

	public static DBHelper getInstance(Context context) {
		if (instance == null) {
			instance = new DBHelper(context.getApplicationContext());
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(LOG, "onCreate");
		deleteTable(db, PT_NAME);
		deleteTable(db, VT_NAME);
		SQLiteDatabase.releaseMemory();
		db.execSQL(CREATE_PRODOTTI);
		db.execSQL(CREATE_VIE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			database.execSQL("DROP TABLE IF EXISTS PRODOTTI");
			database.execSQL("DROP TABLE IF EXISTS VIE");
			onCreate(database);

		}
	

	public void deleteTable(SQLiteDatabase database, String table) {
		database.execSQL("DROP TABLE IF EXISTS " + table);
	}

}
