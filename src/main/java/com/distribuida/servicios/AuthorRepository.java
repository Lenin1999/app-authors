package com.distribuida.servicios;

import com.distribuida.db.Authors;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Authors> {




//    public Author findById(Integer id){
//        return find("name", id).firstResult();
//    }

//    public List<Author> findAlive(){
//        return list("status", Status.Alive);
//    }


}
