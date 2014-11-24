package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Perdeu extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perdeu);
		
		
	}
	
	@Override
	public void onBackPressed(){
		startActivity (new Intent(getApplicationContext(), MainActivity.class)); 
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perdeu, menu);
		return true;
	}
	
	public void onRestart(View v){
		MediaPlayer media = ((VarGlobal) this.getApplication()).boos;
    	
		   if (media.isPlaying()) {
		      media.pause();
		   } 
    	startActivity (new Intent(getApplicationContext(), MainActivity.class));    	
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
