/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence;

/**
 *
 * @author cristian
 */
public class CinemaPersistenceException extends Exception {
    public static final String NO_FOUND_CINEMA_FUNCTION = "La función actual no existe.";

    public CinemaPersistenceException(String message) {
        super(message);
    }

    public CinemaPersistenceException(String message, Throwable cause) {
        super(message, cause);
    } 
    
}
