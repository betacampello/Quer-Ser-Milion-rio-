package com.example.quersermilionario;




import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
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
	private String player_select;

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
            	//com a próxima linha de cod, vou receber a escolha do usuário e armazenar na variavel type
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
		
		
		//Abaixo, vou fazer o dropdown dos players ja cadastrados
		
		VarGlobal app = ((VarGlobal) this.getApplication());
		Banco_de_dados db = app.getBanco_de_dados();
		Spinner Select_player = (Spinner)findViewById(R.id.spinnerPlayers);
		ArrayAdapter<String> adapterPlayer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.getPlayers());
		Select_player.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.getPlayers()));
		
		Select_player.setOnItemSelectedListener(new OnItemSelectedListener() {
			 
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
            	//com a próxima linha de cod, vou receber a escolha do usuário e armazenar na variavel type
            	player_select = (String) adapterView.getItemAtPosition(position);
            	
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
	
	
	//Ao clicar no botão ok, chamo esta função onClick que vai criar meu objeto da clase Player e armazenar em var global, também vai chamar a activit fase1
	public void onClick(View v) {
		
			
		    VarGlobal app = ((VarGlobal) this.getApplication());
			EditText name= (EditText) findViewById(R.id.name); //Estou fazendo uma referencia atraves do id
			
			String person  = name.getText().toString(); // Estou armazenando na variavel person o nome que se coloca no edittex
		    //vou criar meu objeto player da classe Player com o nome da pessoa e o tipo, estou usando o construtor que só exige estes 2 parametros
			Player player = new Player (person,type, app);	
			//aqui embaixo o que fiz foi mandar o player para a varglobal
			
			app.player = player;
			//chamo a activity fase 1
			startActivity (new Intent(getApplicationContext(), Fase_1.class));
				
	}
	
	public void onClickPlayerSelect (View v) {
		
	
		VarGlobal app = ((VarGlobal) this.getApplication());
		Banco_de_dados db = app.getBanco_de_dados();
		Player player = db.getPlayer(player_select, app);
		app.player = player;
		//chamo a activity fase 1
		startActivity (new Intent(getApplicationContext(), Fase_1.class));
		
		
	}
	
	
	public void onPause(View v) {
    	MediaPlayer media = ((VarGlobal) this.getApplication()).media;
    	
    		   if (media.isPlaying()) {
    		      media.pause();
    		   } else {
    			  media.start();  
    		   }
    	}
	
	//O seguinte metodo serve para parar a musica quando mudo de tela
	protected void onPause(){
    	
    	MediaPlayer media = ((VarGlobal) this.getApplication()).media;
    	media.pause();
    	super.onPause();  
    	
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
