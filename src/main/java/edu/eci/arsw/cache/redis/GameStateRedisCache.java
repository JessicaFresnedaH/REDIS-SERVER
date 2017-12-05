/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache.redis;

import edu.eci.arsw.cache.GameStateCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.StringRedisTemplate;



/**
 *
 * @author 2089340
 */
@Service
public class GameStateRedisCache implements GameStateCache{

    @Autowired
    private StringRedisTemplate template;

    public void createGame(int id, String word){
    }

//
//    public HangmanGame getGame(int gameid) {
//       String juego=Integer.toString(gameid);
//        HangmanRedisGame a=new HangmanRedisGame(juego, template);
//        return a;
//    }

   

}
