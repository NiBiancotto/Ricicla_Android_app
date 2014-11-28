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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BidoniActivity extends Activity {
	private DBAdapter helper;
	private ListView garbageList;
	private EditText inputSearch;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> garbageArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bidoni);

		//helper = new DBAdapter(this);

		//garbageArrayList = helper.getAllGarbage();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, garbageArrayList);

		garbageList = (ListView) findViewById(R.id.listView2);
		garbageList.setAdapter(adapter);
		inputSearch = (EditText) findViewById(R.id.inputSearch2);
		
		garbageList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	Intent myIntent = new Intent(BidoniActivity.this, ShowProdActivity.class);
            	myIntent.putExtra("GB",(String) ((TextView) view).getText());
            	startActivity(myIntent);
            }
          });
		
		inputSearch.addTextChangedListener(new TextWatcher() {
		     
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		        BidoniActivity.this.adapter.getFilter().filter(cs);  
		    }
		     
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
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
