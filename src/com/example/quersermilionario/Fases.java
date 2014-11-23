package com.example.quersermilionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public abstract class Fases extends ActionBarActivity {
	
	private String type;
	private ListView listaPerguntas;
	private String respostaEscolhida;
	private int contador = 0;
	//declarando perguntas da clase perguntas
	public Perguntas perguntas = null;
	private String pergunta = null;
	private Player player;
	public Class seguinte_fase;
	public String arquivo;
	public int score_pergunta;
	public int valor_primeira_pergunta;
	public int quantidade_perguntas_fase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fase_1);
	
		player = ((VarGlobal) this.getApplication()).player;
		
		//aqui estou passando para a variavel app o objeto Varglobal que contem todas as variaveis e objetos globais
		VarGlobal app = ((VarGlobal) this.getApplication());
		//para imprimir meu objeto player name na tela do android:
		TextView printName=(TextView)findViewById(R.id.printName);
		//aqui estou impriminto o getName do objeto que criei em Select_player player.
		printName.setText(app.player.getName()); 
		//aqui imprimo a pontuação, passei ela como string
		TextView printScore=(TextView)findViewById(R.id.printScore);
		//faço a chamada a meu objeto do score, a função String.valueOf é para passar de int a string para que possa imprimir
		printScore.setText(String.valueOf(app.player.getScore()));
		perguntas = readFile(arquivo);
		recebeResposta ();
	}
	
	
	public void recebeResposta (){
    	
    	if (contador < quantidade_perguntas_fase){
    		//no array perguntaEscolhida estou passando uma pergunta e 4 respostas, atraves do meu objeto e do metodo getPerguntaEscolhida
    		
    		String[] perguntaEscolhida = perguntas.getPerguntaEscolhida(contador);
    		Toast.makeText(getBaseContext(), perguntaEscolhida[0], Toast.LENGTH_LONG).show();
    		pergunta = perguntaEscolhida[0];
    		TextView imprimepergunta = (TextView)findViewById(R.id.imprimepergunta);
    		imprimepergunta.setText(pergunta);
    		RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup1);

	    	for (int i = 0; i < rg.getChildCount(); i++) {
	            RadioButton rb = (RadioButton) rg.getChildAt(i);
	            rb.setText(perguntaEscolhida[i + 1]);
	        }
	    	rg.clearCheck();
	    	
	    	//rg.clearCheck();
	    
	    	
    		
	    	        
	    	rg.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	        {
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                
	            	if(checkedId>0){
		            	RadioButton rb = (RadioButton) group.findViewById(checkedId);
		            	respostaEscolhida = rb.getText().toString(); 
		            	//Toast.makeText(getBaseContext(), respostaEscolhida, Toast.LENGTH_LONG).show();
	            	}
	            }
	        }); 
	    	
    	}else {
    		startActivity (new Intent(getApplicationContext(), this.seguinte_fase));
    	}
    	
   }
	
	
	
	
	
	/*vou abrir meu arquivo txt com as perguntas e criar o objeto perguntas, esse objeto 
    estará passando de parametros um array de arrays que são todas as perguntas. */
		InputStream input;       
	   
	    public Perguntas readFile(String file) {
	        // TODO Auto-generated method stub
	        AssetManager manger;
	        String line = null;
	        
	       
	       

	        try {
	        	//aqui vou criar um ArrayList que será um array de arrays para guardar as perguntas e respostas
	        	//escolhi em vez de usar array, usar ArrayList<String[]> pois são flexiveis, não precisa determinar o numero de elemnetos ao inicializar
	        	ArrayList<String[]> PerguntasFase = new ArrayList<String[]>();   
	        	// o array temp foi criado apenas para ir pegando array por array do meu txt e ir adicionando no collection
	        	String[] temp;
	        	// estou chamando a pasta assets
	            manger = getAssets();
	            //estou abrindo o meu txt
	            InputStream abrindo = manger.open(file);
	            InputStreamReader lendo = new InputStreamReader(abrindo);
	            BufferedReader armazenado = new BufferedReader(lendo);
	            // no meu while eu digo que enquanto não tiver uma linha nula, ele lê o que tem na linha e separa em uma variavel o que está entre ";", se não for zero, ele coloca no meu array de arrays
	            while ((line = armazenado.readLine()) != null) {
	            	   temp = line.split(";");
	            	  if (temp.length > 0) {
	            		  PerguntasFase.add(temp);
	            	   }  	  
	            	 
	            }	
	            
	            armazenado.close();
	            //aqui vou criar meu objeto pertas
	            perguntas = new Perguntas(PerguntasFase); 
	            perguntas.escolhePerguntas();
	            


	        } catch (IOException e1) {
	            System.out.println("not good");

	        } 
	        //retorno o meu objeto perguntas que será um array com uma pergunta e 4 respostas
	        return perguntas;
	    }
	    
	    
	    
	    public void onClick(View v) {
	    	
		    boolean certo = perguntas.comprovaResposta(respostaEscolhida);
	    	
	    	if (certo){
	    		 Toast.makeText(getBaseContext(), "certo", Toast.LENGTH_LONG).show();
	    		 contador = contador +1;
	    		 recebeResposta();
	    		 //aqui tenho que somar a pontuação do usuario;
	    		 if (contador == 1){
	    			 player.setScore(valor_primeira_pergunta);
	    		 }else {
	    			 player.addScore(score_pergunta);
	    		 }
	    		 
	    		 VarGlobal app = ((VarGlobal) this.getApplication());
	    		//aqui estou impriminto o getName do objeto que criei em Select_player player.
	    		//aqui imprimo a pontuação, passei ela como string
	    		TextView printScore=(TextView)findViewById(R.id.printScore);
	    		//faço a chamada a meu objeto do score, a função String.valueOf é para passar de int a string para que possa imprimir
	    		printScore.setText(String.valueOf(app.player.getScore()));
	    		
	    		
	    	 
	    	} else {
	    		 Toast.makeText(getBaseContext(), "errado", Toast.LENGTH_LONG).show();
	    		 startActivity (new Intent(getApplicationContext(), Perdeu.class));
	    		 //aqui ainda tenho que fazer com que esta tela morra para que o usuario nao possa clicar em voltar e recomeçar
	    		 //tambem tenho que fazer que o programa guarde a pontuação do usuario em um txt
	    		 
	    	}
	    }
	    
	    
	    
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fases, menu);
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
