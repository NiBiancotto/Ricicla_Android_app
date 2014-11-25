package com.example.ricicla;

import java.util.ArrayList;

import SQLite.DBHelper;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProdottiActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ricerca);

		DBHelper helper = new DBHelper(getApplicationContext());
		helper.getReadableDatabase();
		
		final ListView productList = (ListView) findViewById(R.id.listView1);
		

		String[] values = new String[] { "Accendini", "Barattoli in latta",
				"Carta carbone" };

		ArrayList<String> productArrayList = new ArrayList<String>();
		for (String item : values)
			productArrayList.add(item);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, productArrayList);
		productList.setAdapter(adapter);

		productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				/*final String product = (String)parent.getItemAtPosition(position);
				Log.d("Ho cliccato su", product);*/
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ricerca, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
