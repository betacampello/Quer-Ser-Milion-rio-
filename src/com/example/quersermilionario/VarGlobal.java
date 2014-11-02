package com.example.quersermilionario;




import android.app.Application;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

public class VarGlobal extends Application {
	
	public MediaPlayer media;
	public Player player;
	
	@Override
	public void onCreate () {
			media = MediaPlayer.create(this, R.raw.milhao);
	 }

}
