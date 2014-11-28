package com.example.ricicla;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

public class CalendarioActivity extends Activity {
	private ListView listCalendarioZone;
	private ArrayAdapter <String> adapter;
	private String[] calendarioArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		
		calendarioArrayList = new String[]{"zona 1 centro-isola", "zona 6 cappuccini", "zona 4 ospedale",
											"zona 5 trino", "zona 2 prestinari", "zona 3 centro-rigola"};
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, calendarioArrayList);
		
		listCalendarioZone = (ListView) findViewById(R.id.listView4);
		listCalendarioZone.setAdapter(adapter);

		listCalendarioZone.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(CalendarioActivity.this,
						MostraCalendarioActivity.class);
				startActivity(intent);
				finish();

			}
		});
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