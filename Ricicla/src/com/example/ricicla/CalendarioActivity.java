package com.example.ricicla;

import java.util.ArrayList;

import SQLite.DBAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class CalendarioActivity extends Activity {
    private ListView listCalendarioZone;
    private ArrayAdapter<String> adapter;
	private DBAdapter helper;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		helper = new DBAdapter(this);
 		
		ArrayList<String>calendarioArrayList = helper.fetchZone();	
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, calendarioArrayList);
		
		listCalendarioZone = (ListView) findViewById(R.id.listView4);
		listCalendarioZone.setAdapter(adapter);
		
		listCalendarioZone.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(CalendarioActivity.this, ZoneActivity.class);
				intent.putExtra("ZN",(String) ((TextView) view).getText());
				startActivity(intent);
			}
		});
		
		Button b = (Button) findViewById(R.id.button8);
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(CalendarioActivity.this,
						FindViaActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
