package com.example.quersermilionario;

import android.media.MediaPlayer;

public class Player {

	private String name, type;
	private String types;
	private int best_score;
	private int last_score;
	private int score;
	private VarGlobal app;
	
		
	
	public Player (String name, String type, int best_score, VarGlobal app ){
		this.name = name;
		this.type = type;
		this.best_score = best_score;
		this.last_score = 0;
		this.score = 0;
		this.app = app;
		
	
	}
	
	public Player (String name, String type, VarGlobal app){
		this.name = name;
		this.type = type;
		this.best_score = 0;
		this.last_score = 0;
		this.score = 0;
		this.app = app;
		
		
		Banco_de_dados db = app.getBanco_de_dados();
		// mandando os dados para o banco de dados
		db.addPlayer(this);
	
	}	
	
	public Player (){
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getBest_score () {
		return this.best_score;
	}
	
	public int getLast_score () {
		return this.last_score;
	}
	
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public void setBest_score (int best_score) {
		this.best_score = best_score;
	}
	
	public void setLast_score (int last_score) {
		this.last_score = last_score;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score = this.score + score;
		this.last_score= this.score;
		
		if (best_score < this.last_score){				
			this.best_score = this.last_score;
	    }
		
		
		Banco_de_dados db = app.getBanco_de_dados();
		// mandando os dados para o banco de dados
		db.addPlayer(this);
	}
	

	
	
	//para mostrar os dados nome e melhor pontuação, preciso passar como string, para isso fiz a função abaixo
	public String getLinhaRanking(){
		String linhaRanking = "Jogador: " + this.name +", Melhor pontuação: " + Integer.toString(this.best_score) + ", Última pontuação: " + Integer.toString(this.last_score);
		return linhaRanking;
	}
	
	
	
	
}

