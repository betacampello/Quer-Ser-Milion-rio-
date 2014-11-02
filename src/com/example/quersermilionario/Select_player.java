package com.example.quersermilionario;





import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Select_player extends ActionBarActivity {
	
	private String type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_player);
		
		Spinner dropdown = (Spinner)findViewById(R.id.Spintypes);			
		String [] types = new String [] {"Aluno", "Professor", "Outros"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
		dropdown.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types));
	
		dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
			 
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
            	//com a pr�xima linha de cod, vou receber a escolha do usu�rio e armazenar na variavel type
            	type = (String) adapterView.getItemAtPosition(position);
            	
            	//tenho que colocar essa cariavel type como global para usar durante todo o jogo
            	
            	
            	
            	// Se quiser fazer com que saia uma caixinha de dialogo, esta abaixo comentado como fazer
               //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
 
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio                 
            }
        });
	}
	
	
	public void onClick(View v) {
		
		EditText name= (EditText) findViewById(R.id.name); //Estou fazendo uma referencia atraves do id
		
		String person  = name.getText().toString(); // Estou armazenando na variavel person o nome que se coloca no edittex
	    //vou criar meu objeto player da classe Player com o nome da pessoa e o tipo
		Player player = new Player (person, type);	
		//aqui embaixo o que fiz foi mandar o player para a varglobal
		VarGlobal app = ((VarGlobal) this.getApplication());
		app.player = player;
				
	}
	
	
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
		getMenuInflater().inflate(R.menu.select_player, menu);
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
