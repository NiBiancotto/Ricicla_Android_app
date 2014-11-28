package com.example.ricicla;

import java.util.ArrayList;
import java.util.List;


import Model.Prodotti;
import SQLite.DBAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

public class ProdottiActivity extends Activity {
	private DBAdapter helper;
	private ListView productList;
	private EditText inputSearch;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DBAdapter.init(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ricerca);
		
		DBAdapter.addProduct(new Prodotti("Prova", "Prova"));
				
		List <Prodotti> productArrayList = DBAdapter.getAllProduct();		
		ArrayList <String> pl = new ArrayList <String>();
		
		for(Prodotti item : productArrayList){
			pl.add(productArrayList.indexOf(item),item.get_nome());
			}
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, pl);


		productList = (ListView) findViewById(R.id.listView1);
		productList.setAdapter(adapter);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		productList.setTextFilterEnabled(true);
		
		
		
		/*productList.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            	ArrayList<String> garbageArrayList = helper.getAllGarbage();
	            	String prd = (String) ((TextView) view).getText();
	            	String sh = helper.getSpecGarb(prd);
	                // Quando cliccato visualizza un Toast col nome del bidone
	                Toast.makeText(getApplicationContext(), ((sh)), Toast.LENGTH_SHORT).show();
	            }
	          });*/
		
		inputSearch.addTextChangedListener(new TextWatcher() {
		     
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		        ProdottiActivity.this.adapter.getFilter().filter(cs);  
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
