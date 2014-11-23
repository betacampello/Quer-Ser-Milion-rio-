package com.example.quersermilionario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Banco_de_dados extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MilionarioDB";
   
    
    
 
    public Banco_de_dados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); 
    }
    
    
	
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create player table
        String CREATE_PLAYER_TABLE = "CREATE TABLE players ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, "+
                "last_score INTEGER, "+
                "best_score INTEGER, "+
                "tipo TEXT )";
 
        // create books table
        db.execSQL(CREATE_PLAYER_TABLE);
    }
    
    
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS players");
 
        // create fresh books table
        this.onCreate(db);
    }
    
    
    
    public void addPlayer(Player player){
      
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		
		String query = "INSERT OR REPLACE INTO players (ID, nome,tipo,last_score, best_score) VALUES ((SELECT ID FROM players WHERE nome='" + player.getName() + "'),'" + player.getName() + "', '" + player.getType() + "', " + Integer.toString(player.getLast_score()) + ", " + Integer.toString(player.getBest_score()) + ")";     
		db.execSQL(query);
		/*
			// 2. create ContentValues to add key "column"/value
			ContentValues values = new ContentValues();
			values.put("nome", player.getName()); // get Name 
			values.put("last_score", player.getLast_score()); // get LAST SCORE
			values.put("best_score", player.getBest_score());
			values.put("tipo", player.getType());
			
			// 3. insert
			db.insert("players", // table
			        null, //nullColumnHack
			        values); // key/value -> keys = column names/ values = column values
			*/
			// 4. close
			db.close(); 
		
		}
    
    
    
    
    
    public ArrayList<String> getRanking() {
    	ArrayList<String> players = new ArrayList<String>();
  
        // 1. build the query
        String query = "SELECT  nome, best_score,last_score  FROM players order by best_score desc limit 10 ";
  
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
  
        // 3. go over each row, build book and add it to list
        Player player = null;
        if (cursor.moveToFirst()) {
            do {
            	player = new Player();
            	player.setName(cursor.getString(0));
            	player.setBest_score(cursor.getInt(1));
            	player.setLast_score(cursor.getInt(2));
            	String playerStr = player.getLinhaRanking();
  
                // Add player to players
            	players.add(playerStr);
            } while (cursor.moveToNext());
        }
  
        // return players
        return players;
    }
    
    
    public Player getPlayer(String nome, VarGlobal app) {
  
        // 1. build the query
        String query = "SELECT  nome, tipo, best_score  FROM players WHERE nome = '" + nome + "' order by best_score desc limit 1";
  
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
  
        // 3. go over each row, build book and add it to list
        Player player = null;
        if (cursor.moveToFirst()) {
            do {
            	
            	player = new Player(cursor.getString(0),cursor.getString(1),cursor.getInt(2),app);
            	 Log.d("addplayer", Integer.toString(player.getBest_score()));
            } while (cursor.moveToNext());
        }
        
        
  
        // return player
        return player;
    }
    
    
    
    
    
    //O seguinte metodo é para pegar o nome de todos os usuarios já cadastrados no meu banco de dados e passar para a classe select player para que o usuario possa selecionar o nome dele
    
    public ArrayList<String> getPlayers(){
    	
    	ArrayList<String> players = new ArrayList<String>();
    	 String query = "SELECT  nome FROM players ORDER by nome";
    	 
    	 SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(query, null);
         if (cursor.moveToFirst()) {
             do {
            	 players.add(cursor.getString(0));
              } while (cursor.moveToNext());
         }
    	
		return players;
    	
    }
    
    
    
    
    
    //o seguinte metodo serve para saber se o player que está jogando já existe e, em caso positivo, pegar a melhor pontuação dele 
    //para na classe Player ir comparando a pontuação que o player vai fazendo com a melhor pontuação dele
    public int getBest_score_player(String player){
    	
    	String query = "SELECT best_score FROM players WHERE nome = player.getName ORDER BY best_score DESC LIMIT 1";
    	SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
    	
        //na verdade, quando chamo esta função, já sei que o jogador existe (pois o metodo da classe que chama esta função, ja fez a verificação através da variável player_exist), porém, por segurança para não dar erro, coloco a condição que não seja nulo
        //if(cursor != null && cursor.getCount()>0){
        	   cursor.moveToFirst();
        	   int best_score = cursor.getInt(0);
        	   return best_score;
        	   
        //} else {
    	
		//return 0;
		
        //}
    	
    }
    
    
    
}
