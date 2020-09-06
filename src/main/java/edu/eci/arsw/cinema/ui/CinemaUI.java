package edu.eci.arsw.cinema.ui;

import edu.eci.arsw.cinema.services.CinemaServices;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CinemaUI {


    public static void main(String a[]) {
        CinemaServices cs = new CinemaServices();
        cs.buyTicket(1,1,"cinemaX","2018-12-18 15:30","The Night");
        cs.getFunctionsbyCinemaAndDate("cinemaX", "2018-12-18 15:30").forEach(x -> System.out.println(x.getMovie().getName()));
        cs.getFunctionsByFilter("cinemaX","2018-12-18 15:30","Action").forEach(x -> System.out.println("Filtrado por Genero: "+x.getMovie().getName()));
    }
}
