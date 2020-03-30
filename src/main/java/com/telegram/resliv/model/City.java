package com.telegram.resliv.model;

import javax.persistence.*;

//@Data
@Entity
@Table(name="cities")
public class City {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "citiesIdSeq", sequenceName = "id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citiesIdSeq")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="message")
    private String message;
/*
    public City(){

    }

    public City(int id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final City other = (City) obj;
        if (this.id != other.id) {
            return false;
        }

        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

        if ((this.message == null) ? (other.message != null) : !this.message.equals(other.message)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (31 * id +
                +((name == null) ? 0 : name.hashCode())
                + ((message == null) ? 0 : message.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id
                + " name:" + name
                + " message:" + message;
    }
}
