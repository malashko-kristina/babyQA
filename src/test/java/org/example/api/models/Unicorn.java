package org.example.api.models;

public class Unicorn {
    private String name;
    private String colour;

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public Unicorn(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String toJson() {
        return "{\"name\":\"" + name + "\",\"colour\":\"" + colour + "\"}";
    }
}
