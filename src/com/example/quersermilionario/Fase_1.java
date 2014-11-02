package com.example.quersermilionario;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


import android.support.v7.app.ActionBarActivity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Fase_1 extends ActionBarActivity {
	
	private String type;
	private ListView listaPerguntas;
	private String respostaEscolhida;
	private int contador = 0;
	//declarando perguntas da clase perguntas
	private Perguntas perguntas = null;
	private String pergunta = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fase_1);
		
		//para imprimir meu objeto player name na tela do android:		
		
		TextView printName=(TextView)findViewById(R.id.printName);
		//aqui estou passando para a variavel app o objeto Varglobal que contem todas as variaveis e objetos globais
		VarGlobal app = ((VarGlobal) this.getApplication());
		//aqui estou impriminto o getName do objeto que criei em Select_player player.
		printName.setText(app.player.getName()); 
		//aqui imprimo a pontuação, passei ela como string
		TextView printScore=(TextView)findViewById(R.id.printScore);
		//faço a chamada a meu objeto do score, a função String.valueOf é para passar de int a string para que possa imprimir
		printScore.setText(String.valueOf(app.player.getScore()));
		Perguntas perguntas = readFile("test.txt");
		//recebeResposta ();	
	}
	
	
	
	
	 
    /*vou abrir meu arquivo txt com as perguntas e criar o objeto perguntas, esse objeto 
    estará passando de parametros um array de arrays que são todas as perguntas. */
		InputStream input;       
	   
	    private Perguntas readFile(String file) {
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fase_1, menu);
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
