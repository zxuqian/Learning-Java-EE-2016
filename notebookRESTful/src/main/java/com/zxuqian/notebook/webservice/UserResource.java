package com.zxuqian.notebook.webservice;

import com.zxuqian.notebook.domain.User;
import com.zxuqian.notebook.service.client.IUserServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by zxuqian on 3/8/17.
 */

@Path("/user")
public class UserResource {

    private static final Logger logger = Logger.getLogger(UserResource.class.getCanonicalName());

    @EJB
    private IUserServiceLocal userService;

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUserById(@PathParam("id") Long id) {

        User user = this.userService.getUserById(id);
        return user;

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        this.userService.addUser(user);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {

        logger.severe("The id is: " + id);

        User user = this.userService.getUserById(id);

        logger.severe("The user is: " + user);

        this.userService.deleteUser(user);

        return Response.ok().build();
    }


}
