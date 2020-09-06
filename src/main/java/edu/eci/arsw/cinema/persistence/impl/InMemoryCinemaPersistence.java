/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type In memory cinema persistence.
 */
@Component("InMemoryCinema")
public class InMemoryCinemaPersistence implements CinemaPersitence{
    
    private final Map<String,Cinema> cinemas=new HashMap<>();


    /**
     * Instantiates a new In memory cinema persistence.
     */
    public InMemoryCinemaPersistence() {
        //load stub data
        // First Cinema
        List<CinemaFunction> functions = new ArrayList<>();
        String functionDate = "2020-12-18 15:30";
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        cinemas.put("cinemaX", c);
        // Second Cinema
        functions = new ArrayList<>();
        functionDate = "2020-10-20 15:20";
        funct1 = new CinemaFunction(new Movie("Sci-fi Movie","Sci-fi"),functionDate);
        funct2 = new CinemaFunction(new Movie("A Night in Paris","Romance"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        c=new Cinema("cinemaY",functions);
        cinemas.put("cinemaY", c);
        // Third Cinema
        functions = new ArrayList<>();
        functionDate = "2020-11-19 15:10";
        funct1 = new CinemaFunction(new Movie("Kimi no Na Wa","Anime"),functionDate);
        funct2 = new CinemaFunction(new Movie("Sing With Me, Baby","Musical"),"2020-13-19 15:10");
        functions.add(funct1);
        functions.add(funct2);
        c=new Cinema("cinemaZ",functions);
        cinemas.put("cinemaZ", c);
        // Fourth Cinema
        functions = new ArrayList<>();
        functionDate = "2020-11-19 17:26";
        funct1 = new CinemaFunction(new Movie("That's Time I Got Reincarnated as a Slime","Fantasy"),functionDate);
        funct2 = new CinemaFunction(new Movie("Cry Together","Drama"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        c=new Cinema("cinemaW",functions);
        cinemas.put("cinemaW", c);
    }

    @Override
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {

        List<CinemaFunction> cinemaFunctions =cinemas.get(cinema).getFunctions();
        Optional<CinemaFunction> cf = cinemaFunctions.stream().filter(cinemaFunction -> {
            if(cinemaFunction.getMovie().getName().equals(movieName) && cinemaFunction.getDate().contains(date)) {
                return true;
            }
            return false;
        }).findFirst();
        if(cf.isPresent()){
            CinemaFunction cinemaFunction = cf.get();
            cinemaFunction.buyTicket(row, col);
            System.out.println("Compra exitosa, para la funcion: "+cinemaFunction.getMovie().getName()+" con horario: "+cinemaFunction.getDate());
        }else{
            throw new CinemaException(CinemaPersistenceException.NO_FOUND_CINEMA_FUNCTION);
        }
    }

    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        List<CinemaFunction> cinemaFunctions = cinemas.get(cinema).getFunctions();
        List<CinemaFunction> cinemaFunctionList =
                cinemaFunctions.stream().filter(cinemaFunction -> cinemaFunction.getDate().contains(date)).collect(Collectors.toList());
        return cinemaFunctionList;
    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    @Override
    public Cinema getCinema(String name) throws CinemaPersistenceException {
        return cinemas.get(name);
    }

    @Override
    public List<Cinema> getAllCinemas() throws CinemaPersistenceException {
        List<Cinema> list = cinemas.values().stream().collect(Collectors.toList());
        return list;
    }


}
