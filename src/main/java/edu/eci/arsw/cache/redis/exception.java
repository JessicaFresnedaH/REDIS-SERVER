/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache.redis;

/**
 *
 * @author 3070465
 */
public class exception extends Exception {
    
    public exception(String message) {
        super(message);
    }

    public exception(String message, Throwable cause) {
        super(message, cause);
    }

    public exception(Throwable cause) {
        super(cause);
    }
    

}
