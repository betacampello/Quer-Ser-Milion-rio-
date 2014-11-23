package com.example.quersermilionario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Fase_2 extends Fases {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		valor_primeira_pergunta = 1000;
		score_pergunta = 1000;
		arquivo = "test2.txt";
		super.seguinte_fase = Fase_1.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
