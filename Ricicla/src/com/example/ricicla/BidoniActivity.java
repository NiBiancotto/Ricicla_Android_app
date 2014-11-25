package com.example.ricicla;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BidoniActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bidoni);
		
		final ListView bidoniList = (ListView) findViewById(R.id.listView1);

	    String[] values = new String[] { "Indifferenziata", "Umido", "Carta" };
	    

	    ArrayList <String> bidoniArrayList = new ArrayList <String>();
	    for(String item : values)bidoniArrayList.add(item);
	    final ArrayAdapter <String> adapter = new ArrayAdapter <String> (this,android.R.layout.simple_list_item_1, bidoniArrayList);
	    bidoniList.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bidoni, menu);
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
