package com.ratita.pos.resources;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
public class IdParameterFilterTest {

    @Test
    public void test_WithoutIdParameter() throws Exception {
        MultivaluedMap<String, String> query = new MultivaluedHashMap<>();
        UriInfo mockInfo = mock(UriInfo.class);
        when(mockInfo.getPath()).thenReturn("offer");
        when(mockInfo.getQueryParameters()).thenReturn(query);

        ContainerRequestContext mockContext = mock(ContainerRequestContext.class);
        when(mockContext.getUriInfo()).thenReturn(mockInfo);

        ContainerRequestFilter filter = new IdParameterFilter();
        filter.filter(mockContext);

        verify(mockContext, times(1)).getUriInfo();
        verify(mockContext, times(1)).abortWith(any(Response.class));
        verifyNoMoreInteractions(mockContext);
    }

    @Test
    public void test_WithIdParameter() throws Exception {
        MultivaluedMap<String, String> query = new MultivaluedHashMap<>();
        query.putSingle("id", "123456");
        UriInfo mockInfo = mock(UriInfo.class);
        when(mockInfo.getPath()).thenReturn("offer");
        when(mockInfo.getQueryParameters()).thenReturn(query);

        ContainerRequestContext mockContext = mock(ContainerRequestContext.class);
        when(mockContext.getUriInfo()).thenReturn(mockInfo);

        ContainerRequestFilter filter = new IdParameterFilter();
        filter.filter(mockContext);

        verify(mockContext, times(1)).getUriInfo();
        verifyNoMoreInteractions(mockContext);
    }
}
