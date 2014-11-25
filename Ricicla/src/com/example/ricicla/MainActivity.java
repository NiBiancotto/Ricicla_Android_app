package com.example.ricicla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button buttonSearch;
	private Button buttonBidone;
	private Button buttonCalendario;
	private Button buttonHelp;
	private Button buttonExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonSearch = (Button) findViewById(R.id.button1);
		buttonBidone = (Button) findViewById(R.id.button2);
		buttonCalendario = (Button) findViewById(R.id.button3);
		buttonHelp = (Button) findViewById(R.id.button4);
		buttonExit = (Button) findViewById(R.id.button5);
		
		
		
		OnClickListener OcLi = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {

				case R.id.button1:
					Intent intent = new Intent(MainActivity.this,
							ProdottiActivity.class);
					startActivity(intent);
					finish();
					break;

				case R.id.button2:
					Intent intent2 = new Intent(MainActivity.this,
							BidoniActivity.class);
					startActivity(intent2);
					finish();
					break;

				case R.id.button3:
					Intent intent3 = new Intent(MainActivity.this,
							CalendarioActivity.class);
					startActivity(intent3);
					finish();
					break;
					
				case R.id.button4:
					Intent intent4 = new Intent(MainActivity.this,
							HelpActivity.class);
					startActivity(intent4);
					finish();
					break;
					
				case R.id.button5:
					finish();
					break;
				}

			}
		};
		
		buttonSearch.setOnClickListener(OcLi);
		buttonBidone.setOnClickListener(OcLi);
		buttonCalendario.setOnClickListener(OcLi);
		buttonHelp.setOnClickListener(OcLi);
		buttonExit.setOnClickListener(OcLi);
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
