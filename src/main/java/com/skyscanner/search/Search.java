package com.skyscanner.search;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a search request from a user.
 * This class is designed to be serialized/deserialized using Jackson
 * for handling JSON in HTTP requests and responses.
 */
public class Search {

    @JsonProperty("city")
    private String city;

    /**
     * Default constructor required for Jackson deserialization
     */
    public Search() {
    }

    /**
     * Constructor with city parameter
     *
     * @param city the city to search for
     */
    public Search(String city) {
        this.city = city;
    }

    /**
     * Gets the city value
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city value
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Search{city='" + city + "'}";
    }
}