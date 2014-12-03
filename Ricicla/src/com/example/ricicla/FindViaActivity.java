package com.example.ricicla;

import java.util.ArrayList;

import SQLite.DBAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FindViaActivity extends Activity {
	private DBAdapter helper;
	private ListView vieList;
	private EditText inputSearch;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_via);

		helper = new DBAdapter(this);

			/*if(helper.countVie() == 0){
			helper.createVie("P.za Cavour C.", "centro_isola");
			helper.createVie("Via Verdi G.", "centro_isola");
			helper.createVie("C.so Tanaro", "cappuccini");
			helper.createVie("Cascina Colombara", "cappuccini");
			helper.createVie("V.le Aeronautica", "ospedale");
			helper.createVie("V.le Rimembranza", "ospedale");
			helper.createVie("Via Testi", "trino");
			helper.createVie("Via Chicco", "trino");
			helper.createVie("Via Gioberti", "centro_rigola");
			helper.createVie("Via S.Ugolina", "centro_rigola");
			helper.createVie("C.so Torino", "prestinari");
			helper.createVie("Via Aosta", "prestinari");	
			}*/
		
		
		ArrayList <String> vieArrayList = helper.fetchVie();
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, vieArrayList);

		vieList = (ListView) findViewById(R.id.listView7);
		vieList.setAdapter(adapter);
		inputSearch = (EditText) findViewById(R.id.inputSearch2);
		vieList.setTextFilterEnabled(true);
		
		vieList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	String via = (String) ((TextView) view).getText();
            	String sh = helper.fetchAZona(via);
                Toast toast = Toast.makeText(getApplicationContext(), ((sh)), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();	                
            }
          });
		
		inputSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				// When user changed the Text
				FindViaActivity.this.adapter.getFilter().filter(cs);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.find_via, menu);
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
	
	@Override
	public void onBackPressed() {
		finish();
	}
}
