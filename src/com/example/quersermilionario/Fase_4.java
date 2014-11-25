package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Fase_4 extends Fases {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		quantidade_perguntas_fase = 5;
		valor_primeira_pergunta = 100000;
		score_pergunta = 100000;
		arquivo = "fase4.txt";
		super.seguinte_fase = Fase_5.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
