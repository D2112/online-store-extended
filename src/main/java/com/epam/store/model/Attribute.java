package com.epam.store.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "attribute_type")
public abstract class Attribute extends BaseEntity implements Comparable<Attribute> {
    private String name;

    public Attribute() {
    }

    public Attribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getValueAsString();

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                "} ";
    }
}
