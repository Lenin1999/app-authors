package com.distribuida.rest;

import com.distribuida.db.Authors;
import com.distribuida.servicios.AuthorRepository;
import com.oracle.svm.core.annotate.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @Inject
    AuthorRepository authorRepository;




    @GET
    public Response findAll(){
        System.out.println("************Consultado Servicio");
List<Authors> list = Authors.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Authors.findByIdOptional(id)
                .map(author -> Response.ok(author).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public void create(Authors author){
        Authors.persist(author);
//        if (author.isPersistent()){
//            return Response.created(URI.create("/authors" + author.getId())).build();
//        }
//        return Response.status(Response.Status.BAD_REQUEST).build();
    }

        @DELETE
        @Transactional
        @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        Authors.deleteById(id);
        }

        @PUT
        @Transactional
        @Path("/{id}")
        public Authors findByNameForUpdate(Authors author, @PathParam("id") Long id){
            Authors entity = Authors.findById(id);
            if(entity == null) {
                throw new NotFoundException();
            }

            entity.setFirst_name(author.getFirst_name());
            entity.setLast_name(author.getLast_name());

            return entity;
        }

}
