package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Fase_5 extends Fases {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		quantidade_perguntas_fase = 1;
		valor_primeira_pergunta = 1000000;
		score_pergunta = 100000;
		arquivo = "fase5.txt";
		super.seguinte_fase = Win.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
