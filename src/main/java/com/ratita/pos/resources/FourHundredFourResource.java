package com.ratita.pos.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * @author z.martinez.ramirez on 13/03/2016.
 * response for any petition out of permissions, bad request
 * or servide down
 */
@Path("{any: .*}")
public class FourHundredFourResource {

    @GET
    public Response notFound() {
        return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
    }
}
