package com.example.quersermilionario;




import android.app.Application;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

public class VarGlobal extends Application {
	
	public MediaPlayer media;
	public Player player;
	private int score = 0;
	
	@Override
	public void onCreate () {
			media = MediaPlayer.create(this, R.raw.milhao);
	 }
	
	public int getScore(){
		return this.score;
	}
	public void setScore (int score) {
		this.score = score;
	}

}
