package com.foochane.dao;

import com.foochane.pojo.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonDao extends Neo4jRepository<Person,Long> {
    Person findByName(String name);
}
