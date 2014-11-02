package com.example.quersermilionario;





import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Fase_1 extends ActionBarActivity {

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
		//app.getScore() é a chamada ao meu get criado em Varglobal 
		printScore.setText(String.valueOf(app.getScore()));
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
