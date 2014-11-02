package com.example.quersermilionario;






import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MediaPlayer media = ((VarGlobal) this.getApplication()).media;
        media.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }
    
    
    public void onPlay(View v){
    	startActivity (new Intent(getApplicationContext(), Select_player.class));    	
    }
    
    public void onPause(View v) {
    	MediaPlayer media = ((VarGlobal) this.getApplication()).media;
    	// o metodo onClick � do botao pause sound que pausa a musica
    	
    	Button stopsound = (Button)findViewById(R.id.pause);
    	
    		   if (media.isPlaying()) {
    		      media.pause();
    		   } else {
    			  media.start();  
    		   }
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
