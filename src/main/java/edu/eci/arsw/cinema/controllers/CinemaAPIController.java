/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.services.CinemaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.Assert.*;

/**
 * @author cristian
 */

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaAPIController {

    @Autowired
    CinemaServices cs;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCinemas() {
        try {
            List<Cinema> allCinemas = cs.getAllCinemas();

            return new ResponseEntity<>(allCinemas, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}")
    public ResponseEntity<?> getCinemasByName(@PathVariable("name") String cinemaName) {
        try {
            Cinema cinemas = cs.getCinemaByName(cinemaName);
            if (cinemas == null) {
                return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cinemas, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/{date}")
    public ResponseEntity<?> getFunctionsByNameAndDate(@PathVariable("name") String cinemaName, @PathVariable("date") String date) {
        try {
            List<CinemaFunction> functions = cs.getFunctionsbyCinemaAndDate(cinemaName, date);
            if (functions.isEmpty()) {
                return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(functions, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/{date}/{movieName}")
    public ResponseEntity<?> filterFunctionsByMovieName(@PathVariable("name") String cinemaName, @PathVariable("date") String date, @PathVariable("movieName") String movie) {
        try {
            List<CinemaFunction> functions = cs.getFunctionsbyCinemaAndDate(cinemaName, date);
            List<CinemaFunction> cinemaFunctions = functions.stream()
                    .filter(cinemaFunction ->
                            cinemaFunction.getMovie().getName().equals(movie))
                    .collect(Collectors.toList());
            if(functions.isEmpty()) {
                return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cinemaFunctions, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST, path = "{name}")
    public ResponseEntity<?> addCinema(@RequestBody Cinema o, @PathVariable("name") String cinemaName) {
        try {
            if (cs.getCinemaByName(cinemaName) == null) {
                cs.addNewCinema(o);
                return new ResponseEntity<>("Se ha construido el objeto con éxito.", HttpStatus.CREATED);
            } else {
                List<CinemaFunction> cinemaFunctions = new ArrayList<>(), y = cs.getCinemaByName(cinemaName).getFunctions();
                o.getFunctions().forEach(x-> {
                    if(y.stream().noneMatch(functionY -> functionY.getMovie().getName().equals(x.getMovie().getName()))) cinemaFunctions.add(x);
                });
                y.addAll(cinemaFunctions);
                return new ResponseEntity<>("Se ha actualizado la información con éxito.", HttpStatus.ACCEPTED);
            }

        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }

    }


}