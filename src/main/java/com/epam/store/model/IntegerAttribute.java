package com.epam.store.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("integer")
public class IntegerAttribute extends Attribute {
    @Column(name = "integer_value")
    private Integer value;

    public IntegerAttribute() {
    }

    public IntegerAttribute(String name, Integer value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(value);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Attribute o) {
        if (this.getClass() == o.getClass()) {
            IntegerAttribute other = (IntegerAttribute) o;
            return Integer.compare(this.getValue(), other.getValue());
        }
        if (o.getClass() == DecimalAttribute.class) {
            DecimalAttribute other = (DecimalAttribute) o;
            int otherValue = other.getValue().intValue();
            return Integer.compare(this.getValue(), otherValue);
        }
        return 1;
    }

    @Override
    public String toString() {
        return "IntAttribute{" +
                "value=" + value +
                "} " + super.toString();
    }
}
