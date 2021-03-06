package com.ratita.pos.client;

import com.ratita.pos.domain.Attribute;

import java.util.function.Predicate;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
public class CustomAttributesFilter implements Predicate<Attribute> {

    private final String attributeName;

    public CustomAttributesFilter(String attributeName) {
        this.attributeName = attributeName;
    }
    @Override
    public boolean test(Attribute attribute) {
        return attribute.getName().equals(attributeName);
    }
}
