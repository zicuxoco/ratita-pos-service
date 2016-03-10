package com.ratita.pos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
@XmlType(propOrder = { "name", "value", "createdBy", "timestamp", "metaValue" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute {
    protected String name;
    protected String value;
    protected String createdBy;
    protected Date timestamp;
    protected boolean metaValue;

    public Attribute() {

    }

    public Attribute(String name, String value, String createdBy, Date timestamp) {
        this.name = name;
        this.value = value;
        this.createdBy = createdBy;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isMetaValue() {
        return metaValue;
    }

    public void setMetaValue(boolean metaValue) {
        this.metaValue = metaValue;
    }
}
