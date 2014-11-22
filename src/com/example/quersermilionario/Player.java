package com.example.quersermilionario;

public class Player {

	private String name, type;
	private String types;
	private int best_score;
	private int last_score;
	private int score;
		
	
	public Player (String name, String type, int best_score, int last_score ){
		this.name = name;
		this.type = type;
		this.best_score = best_score;
		this.last_score = last_score;
		this.score = 0;
		
		// mandando os dados para o banco de dados
        
	
	}
	
	public Player (String name, String type){
		this.name = name;
		this.type = type;
		this.best_score = 0;
		this.last_score = 0;
		this.score = 0;
	
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
	}
	
	
	
	
}

