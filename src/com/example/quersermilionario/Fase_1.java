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
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		valor_primeira_pergunta = 100;
		score_pergunta = 100;
		arquivo = "test.txt";
		seguinte_fase = Fase_2.class;
		
		super.onCreate(savedInstanceState);
		
		
	}
	
	   
}
	
	    

	