package com.example.ricicla;

import java.util.ArrayList;

import SQLite.DBAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ShowProdActivity extends Activity {
	private DBAdapter helper;
	private ListView showList;
	private EditText inputSearch;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> showArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_prod);

		Intent myIntent = getIntent(); // gets the previously created intent
		String grb = myIntent.getStringExtra("GB");

		//helper = new DBAdapter(this);

		//showArrayList = helper.getSpecProds(grb);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, showArrayList);

		showList = (ListView) findViewById(R.id.listView2);
		showList.setAdapter(adapter);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		showList.setTextFilterEnabled(true);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_prod, menu);
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
