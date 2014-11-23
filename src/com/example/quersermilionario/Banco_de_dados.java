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
        db.execSQL("DROP TABLE IF EXISTS books");
 
        // create fresh books table
        this.onCreate(db);
    }
    
    public void addPlayer(Player player){
      
		
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		
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
		
		// 4. close
		db.close(); 
		}
    
    public ArrayList<String> getRanking() {
    	ArrayList<String> players = new ArrayList<String>();
  
        // 1. build the query
        String query = "SELECT  nome, best_score  FROM players order by best_score desc limit 10 ";
  
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
            	String playerStr = player.getLinhaRanking();
  
                // Add player to players
            	players.add(playerStr);
            } while (cursor.moveToNext());
        }
  
        // return books
        return players;
    }
    
    
    
}
