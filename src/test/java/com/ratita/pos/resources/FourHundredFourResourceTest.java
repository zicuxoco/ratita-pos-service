package com.ratita.pos.resources;

import com.ratita.pos.categories.Unit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
@Category(Unit.class)
public class FourHundredFourResourceTest {
    @Test
    public void test_Always_returns_404() throws Exception {
        FourHundredFourResource resource = new FourHundredFourResource();
        assertThat(resource.notFound().getStatus(), equalTo(404));
    }
}
