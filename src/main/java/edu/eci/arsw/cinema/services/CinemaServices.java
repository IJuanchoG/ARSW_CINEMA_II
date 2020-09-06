/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.filter.CinemaFilter;
import edu.eci.arsw.cinema.filter.CinemaFilterException;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * The type Cinema services.
 */
@Service
public class CinemaServices {

    /**
     * The Cps.
     */
    @Autowired
    @Qualifier("InMemoryCinema")
    CinemaPersitence cps=null;

    /**
     * The Filter.
     */
    @Autowired
     @Qualifier("FilterByGender")
    CinemaFilter filter;

    /**
     * Add new cinema.
     *
     * @param c the c
     */
    public void addNewCinema(Cinema c) {
        try {
            cps.saveCinema(c);
        } catch (CinemaPersistenceException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get all cinemas set.
     *
     * @return the set
     */
    public List<Cinema> getAllCinemas(){
        try {
            return cps.getAllCinemas();
        } catch (CinemaPersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets cinema by name.
     *
     * @param name the name
     * @return the cinema by name
     */
    public Cinema getCinemaByName(String name) {
        try {
            return cps.getCinema(name);
        } catch (CinemaPersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Buy ticket.
     *
     * @param row       the row
     * @param col       the col
     * @param cinema    the cinema
     * @param date      the date
     * @param movieName the movie name
     */
    public void buyTicket(int row, int col, String cinema, String date, String movieName){
        try {
            cps.buyTicket(row, col, cinema, date, movieName);
        } catch (CinemaException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets functionsby cinema and date.
     *
     * @param cinema the cinema
     * @param date   the date
     * @return the functionsby cinema and date
     */
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        return cps.getFunctionsbyCinemaAndDate(cinema,date);
    }

    /**
     * Get functions by filter list.
     *
     * @param cinema   the cinema
     * @param date     the date
     * @param property the property
     * @return the list
     */
    public List<CinemaFunction> getFunctionsByFilter(String cinema, String date, String property){
        List<CinemaFunction> functions = getFunctionsbyCinemaAndDate(cinema, date);

        try{
           functions =  filter.filterBy(functions, property);
        } catch (CinemaFilterException e){
            e.printStackTrace();
        }
        return functions;
    }

}
