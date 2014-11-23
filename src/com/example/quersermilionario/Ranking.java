package com.example.quersermilionario;

import java.util.ArrayList;
import java.util.List;



import android.support.v7.app.ActionBarActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ranking extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		VarGlobal app = ((VarGlobal) this.getApplication());
		ArrayList<String> lista = app.getBanco_de_dados().getRanking();
		ListView listaPerguntas = (ListView) findViewById(R.id.listRanking);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        listaPerguntas.setAdapter(adapter);
	}

	
	public void onClean(View v) {
		
		VarGlobal app = ((VarGlobal) this.getApplication());
		Banco_de_dados db = app.getBanco_de_dados();
		SQLiteDatabase db2 = db.getWritableDatabase();
        db2.execSQL("delete from players");
 
	}
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
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
