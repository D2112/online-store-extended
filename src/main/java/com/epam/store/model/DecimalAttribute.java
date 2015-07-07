package com.epam.store.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("decimal")
public class DecimalAttribute extends Attribute {
    @Column(name = "decimal_value")
    private BigDecimal value;

    public DecimalAttribute() {
    }

    public DecimalAttribute(String name, BigDecimal value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return value.toString();
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int compareTo(Attribute o) {
        if (this.getClass() == o.getClass()) {
            DecimalAttribute other = (DecimalAttribute) o;
            return other.getValue().compareTo(this.getValue());
        }
        if (o.getClass() == IntegerAttribute.class) {
            IntegerAttribute other = (IntegerAttribute) o;
            int otherValue = other.getValue();
            return Integer.compare(this.getValue().intValue(), otherValue);
        }
        return 1;
    }

    @Override
    public String toString() {
        return "DecimalAttribute{" +
                "value=" + value +
                "} " + super.toString();
    }
}
