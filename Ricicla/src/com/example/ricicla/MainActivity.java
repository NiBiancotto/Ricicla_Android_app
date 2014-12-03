package com.example.ricicla;

import SQLite.DBAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

;
public class MainActivity extends Activity {
	private Button buttonSearch;
	private Button buttonBidone;
	private Button buttonCalendario;
	private Button buttonHelp;
	private Button buttonExit;
	private ImageButton buttonInfo;
	private DBAdapter helper;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new DBAdapter(this);

		if (helper.countProd() == 0) {
			helper.createProducts("Foglio di Carta", "Carta");
			helper.createProducts("Carne", "Umido");
			helper.createProducts("Lattina", "Latta");
			helper.createProducts("Pesce", "Umido");
			helper.createProducts("Frutta", "Organico");
			helper.createProducts("Formaggio", "Organico");
		}
		
		if(helper.countVie() == 0){
			helper.createVie("P.za Cavour C.", "centro_isola");
			helper.createVie("P.za Risorgimento","centro_isola");
			helper.createVie("P.za Zumaglini E.","centro_isola");
			helper.createVie("Via Alighieri D.","centro_isola");
			helper.createVie("Via Ara C.","centro_isola");
			helper.createVie("Via Balbo C.","centro_isola");
			helper.createVie("Via Bandiera F.lli","centro_isola");
			helper.createVie("Via Bava E.","centro_isola");
			helper.createVie("Via Brighinzio","centro_isola");
			helper.createVie("Via Caccianotti","centro_isola");
			helper.createVie("Via Covour C.","centro_isola");
			helper.createVie("Via di Collobiano C.","centro_isola");
			helper.createVie("Via Duchessa Jolanda","centro_isola");
			helper.createVie("Via Ferraris G.","centro_isola");
			helper.createVie("Via Laviny F.lli","centro_isola");
			helper.createVie("Via Mandelli V.","centro_isola");
			helper.createVie("Via MArsala","centro_isola");
			helper.createVie("Via Monte di Pietà","centro_isola");
			helper.createVie("Via Nigra C.","centro_isola");
			helper.createVie("Via S.Antonio","centro_isola");
			helper.createVie("Via Verdi G.","centro_isola");
			helper.createVie("Via Viotti G.B.","centro_isola");
			helper.createVie("Via Vittorio Veneto","centro_isola");
			helper.createVie("Viale Garibaldi G.","centro_isola");
			helper.createVie("C.so Gastoldi G.","centro_isola");
			helper.createVie("C.so Randaccio G.","centro_isola");
			helper.createVie("C.so Ticino","centro_isola");
			helper.createVie("P.za Irigoyen","centro_isola");
			helper.createVie("P.za Roma","centro_isola");
			helper.createVie("Via Arles","centro_isola");
			helper.createVie("Via Birago D.","centro_isola");
			helper.createVie("Via Borgogna F.","centro_isola");
			helper.createVie("Via Campoea","centro_isola");
			helper.createVie("Via Cantorana","centro_isola");
			helper.createVie("Via Cerrone M.","centro_isola");
			helper.createVie("Via De Rossi C.","centro_isola");
			helper.createVie("Via Durandi J.","centro_isola");
			helper.createVie("Via Egitto","centro_isola");
			helper.createVie("Via Grolla O.","centro_isola");
			helper.createVie("Via Latina","centro_isola");
			helper.createVie("Via Manzone W.","centro_isola");
			helper.createVie("Via Micca P.","centro_isola");
			helper.createVie("Via Oldoni","centro_isola");
			helper.createVie("Via Pollo Don S.","centro_isola");
			helper.createVie("Via Raviglione G.","centro_isola");
			helper.createVie("Via Restano R.","centro_isola");
			helper.createVie("Via Rigazio M.","centro_isola");
			helper.createVie("Via Sereno L.","centro_isola");
			helper.createVie("Via Siracusa","centro_isola");
			helper.createVie("Via Trocia","centro_isola");
			helper.createVie("Via Trieste","centro_isola");
			helper.createVie("Via Trento","centro_isola");
			helper.createVie("Via Udine","centro_isola");
			helper.createVie("Via Vicenza","centro_isola");
			helper.createVie("C.so Gastoldi","centro_isola");
			helper.createVie("P.za S.Eusebio","centro_isola");
			helper.createVie("Via Bichieri G.","centro_isola");
			helper.createVie("Via 53Fanteria Umbria","centro_isola");
			helper.createVie("Via Agosti","centro_isola");
			helper.createVie("Via Albenga","centro_isola");
			helper.createVie("Via America","centro_isola");
			helper.createVie("Via Anadone","centro_isola");
			helper.createVie("Via Argentina","centro_isola");
			helper.createVie("Via Boemia","centro_isola");
			helper.createVie("Via Borgosesia","centro_isola");
			helper.createVie("Via Bramante","centro_isola");
			helper.createVie("Largo Brigata Cagliari","centro_isola");
			helper.createVie("Via Caduti di Nassirya","centro_isola");
			helper.createVie("Via Candia","centro_isola");
			helper.createVie("Via Carlo III di Savoia","centro_isola")
			helper.createVie("Via Caron","centro_isola");
			helper.createVie("Via Casalino R.","centro_isola");
			helper.createVie("Via Casanova A.","centro_isola");
			helper.createVie("Via Coltellina","centro_isola");
			helper.createVie("Via Crispo","centro_isola");
			helper.createVie("Via Dionisetti","centro_isola");
			helper.createVie("Via Don Rossi","centro_isola");
			helper.createVie("Via Dusnasi","centro_isola");
			
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
			}

		buttonSearch = (Button) findViewById(R.id.button1);
		buttonBidone = (Button) findViewById(R.id.button2);
		buttonCalendario = (Button) findViewById(R.id.button3);
		buttonHelp = (Button) findViewById(R.id.button4);
		buttonExit = (Button) findViewById(R.id.button5);
		buttonInfo = (ImageButton) findViewById(R.id.imageButton1);

		OnClickListener OcLi = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {

				case R.id.button1:
					Intent intent = new Intent(MainActivity.this,
							ProdottiActivity.class);
					startActivity(intent);
					break;

				case R.id.button2:
					Intent intent2 = new Intent(MainActivity.this,
							BidoniActivity.class);
					startActivity(intent2);
					break;

				case R.id.button3:
					Intent intent3 = new Intent(MainActivity.this,
							CalendarioActivity.class);
					startActivity(intent3);
					break;

				case R.id.button4:
					Intent intent4 = new Intent(MainActivity.this,
							HelpActivity.class);
					startActivity(intent4);
					break;

				case R.id.imageButton1:
					Intent intent5 = new Intent(MainActivity.this,
							InfoActivity.class);
					startActivity(intent5);
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
		buttonInfo.setOnClickListener(OcLi);
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setMessage("Sei sicuro di voler uscire?")
				.setCancelable(false)
				.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						MainActivity.this.finish();
					}
				}).setNegativeButton("No", null).show();
	}

}
