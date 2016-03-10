package com.ratita.pos.pz;

import com.ratita.pos.client.PZAttributesFilter;
import com.ratita.pos.domain.Attribute;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
public interface PZClient {
    @NotNull
    List<Attribute> getAttributes(String key);

    @NotNull
    default Stream<Attribute> getAttributeStream(String key) {
        return getAttributes(key).stream();
    }

    default String getAttribute(String key, String attributeName) {
        return getAttribute(key, attributeName, null);
    }

    default String getAttribute(String cid, String attributeName, String defaultValue) {
        return getAttributeStream(cid)
            .filter(new PZAttributesFilter(attributeName))
            .findFirst()
            .map(Attribute::getValue)
            .orElse(defaultValue);
    }
}
