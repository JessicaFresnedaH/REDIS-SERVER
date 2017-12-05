/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache.redis;

import edu.eci.arsw.collabhangman.model.game.HangmanGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author 2089340
 */
public class HangmanRedisGame extends HangmanGame{
//    @Autowired
    private StringRedisTemplate template;
    String idPartida;
    public final String word;
    public String guessedWord;
    public HangmanRedisGame(String id,StringRedisTemplate t) {
        super("");
        this.idPartida=id;
        this.template=t;
        word=(String)template.opsForHash().get(id,"palabra");
        // String toLowerCase = word.toLowerCase();
        char[] gword = new char[word.length()];
        for (int i=0;i<word.length();i++){
            
             gword [i]='_';
            
           
        } 
        guessedWord=String.valueOf(gword);
        template.opsForHash().put(id,"pal", guessedWord);
    }

    @Override
    public String addLetter(char l){    
          char[] gword = new char[word.length()];
        for (int i=0;i<word.length();i++){
            if (word.charAt(i)==l){
              String value=(String)template.opsForHash().get("1","pal");
              gword=value.toCharArray();
                gword[i]=l;
            }            
        } 
        guessedWord=String.valueOf(gword);
        template.opsForHash().put(idPartida,"pal", guessedWord);
        return (String) template.opsForHash().get(idPartida,guessedWord);
    }
   
    
    @Override
    public synchronized boolean tryWord(String playerName,String s){
        boolean tryWord=false;
        String value=(String)template.opsForHash().get("1","palabra");
        if(value.equals(word)) tryWord=true;
        return tryWord;
    }
    
    @Override
    public boolean gameFinished(){
        return (boolean) template.opsForHash().get("1","finalizo");
    }
    
    /**
     * @pre gameFinished=true;
     * @return winner's name
     */
    @Override
    public String getWinnerName(){
        return (String) template.opsForHash().get("1","winner");
    }
    
    @Override
    public String getCurrentGuessedWord(){
        return (String) template.opsForHash().get("1","pal");
    }   
    
    
}
