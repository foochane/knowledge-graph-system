package com.foochane.service;

import com.foochane.dao.PersonDao;
import com.foochane.pojo.Movie;
import com.foochane.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    public Person findByName(String name){
        return personDao.findByName(name);
    }

    public Iterable<Person> findAll(){
        return  personDao.findAll();
    }

    public Set<Movie> getMoviesByRelationship(Person person, String rel){
        if(rel.equals("actedby")){
            return person.getActedInMovie();
        }
        else if(rel.equals("directed")){
            return person.getDirectedMovie();
        }
        else if(rel.equals("wrote")){
            return person.getWroteMovie();
        }
        else if(rel.equals("reviewed")){
            return person.getReviewedMovie();
        }
        else if(rel.equals("produced")){
            return person.getProducedMovie();
        }
        else{
            return null;
        }
    }

}
