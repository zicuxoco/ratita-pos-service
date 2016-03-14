package com.ratita.pos.resources;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.apache.commons.collections.CollectionUtils;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 * annotaion to verify if the request contains the
 * required paramter @key
 */
@Provider
@KeyParameterFilter.Key
public class KeyParameterFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        UriInfo uriInfo = context.getUriInfo();
        if (CollectionUtils.isEmpty(uriInfo.getQueryParameters().get("key"))) {
            context.abortWith(
                Response
                    .status(Response.Status.BAD_REQUEST)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .entity("Parameter key is required.")
                    .build());
        }
    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(value = RetentionPolicy.RUNTIME )
    @NameBinding
    public @interface Key {

    }

}
