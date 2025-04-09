package com.crossfiretactics.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "shooters")
public class Shooter extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shooter shooter = (Shooter) obj;
        return Objects.equals(name, shooter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
