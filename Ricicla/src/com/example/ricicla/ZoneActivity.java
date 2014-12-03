package com.example.ricicla;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ZoneActivity extends Activity {
	private final static String day[] = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato"};
	private final static String racc1[] = {"Carta e cartone", "Organico", "Indifferenziato", "", "Organico", ""};
	private final static String racc2[] = {"", "Organico", "", "Indifferenziato", "Organico", "Carta e cartone"};
	private final static String racc3[] = {"Indifferenziato", "", "Organico", "Carta e cartone", "", "Organico"};
	private final static String racc4[] = {"", "Indifferenziato", "Organico", "", "Carta e cartone", "Organico"};
	private final static String racc5[] = {"Organico", "Carta e cartone", "", "Organico", "Indifferenziato", ""};
	private final static String racc6[] = {"Organico", "", "Carta e cartone", "Organico", "", "Indifferenziato"};
	
	private ListView listView;
	private ListViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zone);
		
		Intent intent = getIntent();
		String item = intent.getStringExtra("ZN");
		listView = (ListView) findViewById(R.id.listView5);
		
		switch(item){
			case "centro_isola":
				adapter = new ListViewAdapter(this, day, racc1);
				break;
			case "cappuccini":
				adapter = new ListViewAdapter(this, day, racc2);
				break;
			case "ospedale":
				adapter = new ListViewAdapter(this, day, racc3);
				break;
			case "trino":
				adapter = new ListViewAdapter(this, day, racc4);
				break;
			case "prestinari":
				adapter = new ListViewAdapter(this, day, racc5);
				break;
			case "centro_rigola":
				adapter = new ListViewAdapter(this, day, racc6);
				break;
		}
		
		
		listView.setAdapter(adapter);
	
	}
	@Override
	public void onBackPressed() {
		finish();
	}
	
	}

