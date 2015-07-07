package com.epam.store.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("string")
public class StringAttribute extends Attribute {
    @Column(name = "string_value")
    private String value;

    public StringAttribute() {
    }

    public StringAttribute(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return getValue();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Attribute o) {
        return 0;
    }

    @Override
    public String toString() {
        return "StringAttribute{" +
                "value='" + value + '\'' +
                "} " + super.toString();
    }
}
