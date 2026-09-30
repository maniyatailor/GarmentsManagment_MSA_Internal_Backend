package com.mycompany.garmentsapplication.service;

import entity.Category;
import entity.Garmentmaster;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;


@Path("/example")
public class ExampleService {
    
    @PersistenceContext(unitName="GarmentPU")
    private EntityManager em;
    
    @GET
    public Response get() {
        return Response.ok("Hello, world!").build();
    }
    
    
    @Path("getSearchGarments")
    @RolesAllowed("CLIENT")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Garmentmaster> getGarments(
            @QueryParam("category") String category,
            @QueryParam("priceRange") String priceRange) {

        String query
            = "SELECT g FROM Garmentmaster g "
            + "WHERE g.cid.cname = :category "
            + "AND g.stock > 0 ";
        
        if ("500-1000".equals(priceRange)) {

            query += "AND g.price BETWEEN 500 AND 1000";

        } else if ("1001-1500".equals(priceRange)) {

            query += "AND g.price BETWEEN 1001 AND 1500";

        } else if (">1500".equals(priceRange)) {

            query += "AND g.price > 1500";
        }

        return em.createQuery(query, Garmentmaster.class)
                .setParameter("category", category)
                .getResultList();
    } 
    @GET
    @Path("getAllCat")
    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCat()
    {
       return em.createQuery("SELECT c FROM Category c",Category.class).getResultList();
    }
    
//    @Produces(MediaType.APPLICATION_JSON)
//    @GET
//    public Collection<Garmentmaster> getGarments(@QueryParam("cat")String category,@QueryParam("price")Double price)
//    {
//        
//    }

}
