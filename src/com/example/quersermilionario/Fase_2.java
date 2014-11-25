package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Fase_2 extends Fases {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		quantidade_perguntas_fase = 5;
		valor_primeira_pergunta = 1000;
		score_pergunta = 1000;
		arquivo = "fase2.txt";
		super.seguinte_fase = Fase_3.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
