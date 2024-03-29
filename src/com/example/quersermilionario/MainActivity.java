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
        
        //criei na minha VarGlobal a variavel media, assim posso us�-la durante todo o programa
        //na seguinte linha, estou "chamando" a variavel para usar ela
        MediaPlayer media = ((VarGlobal) this.getApplication()).media;
        media.start();
        
        //crio meu objeto banco de dados
        Banco_de_dados db = new Banco_de_dados(this);
        //mando meu objeto banco de dados a classe varGlobal para poder usa-lo ao longo do programa
        VarGlobal app = ((VarGlobal) this.getApplication());
        app.setBanco_de_dados(db);
      
    }
    
    
     // o metodo onPlay chama a seguinte activity
    public void onPlay(View v){
    	startActivity (new Intent(getApplicationContext(), Select_player.class));    	
    }
    
    public void onRanking(View v){
    	startActivity (new Intent(getApplicationContext(), Ranking.class)); 
    	
    }
    
    
    //o metodo onPause serve para dar pause na musica
    public void onPause(View v) {
    	MediaPlayer media = ((VarGlobal) this.getApplication()).media;
    	
    		   if (media.isPlaying()) {
    		      media.pause();
    		   } else {
    			  media.start();  
    		   }
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
