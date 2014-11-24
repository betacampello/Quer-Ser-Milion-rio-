package com.example.quersermilionario;




import android.app.Application;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

public class VarGlobal extends Application {
	
	public MediaPlayer media;
	public MediaPlayer aplausos;
	public MediaPlayer boos;
	public Player player;
	private Banco_de_dados db;
	
	
	@Override
	public void onCreate () {
			media = MediaPlayer.create(this, R.raw.milhao);
			aplausos = MediaPlayer.create(this, R.raw.aplausos);
			boos = MediaPlayer.create(this, R.raw.boos);
	 }
	
	public Banco_de_dados getBanco_de_dados(){
		return this.db;
	}
	
	public void setBanco_de_dados (Banco_de_dados db) {
		 this.db = db;
	}
	

}
