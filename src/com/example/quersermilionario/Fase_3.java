package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Fase_3 extends Fases {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		quantidade_perguntas_fase = 5;
		valor_primeira_pergunta = 10000;
		score_pergunta = 10000;
		arquivo = "test2.txt";
		super.seguinte_fase = Fase_4.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
