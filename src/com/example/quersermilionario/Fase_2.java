package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Fase_2 extends Fases {

private String arquivo = "test.txt";
	 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fase_1);
		
		super.seguinte_fase = Fase_1.class;
		
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
