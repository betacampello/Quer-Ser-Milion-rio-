package com.example.quersermilionario;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


import android.widget.RadioButton;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Fase_1 extends Fases {
	
	
	private String arquivo = "test.txt";
	 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fase_1);
		
		super.seguinte_fase = Fase_2.class;
		
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
	
	   
}
	
	    

	