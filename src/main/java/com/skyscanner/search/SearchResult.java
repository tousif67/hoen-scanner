package com.skyscanner.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty("city")
    private String city;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("title")
    private String title;

    /**
     * Default constructor required for Jackson deserialization
     */
    public SearchResult() {
    }

    /**
     * Constructor with all fields
     *
     * @param city the city associated with this result
     * @param kind the kind/type of the result
     * @param title the title of the result
     */
    public SearchResult(String city, String kind, String title) {
        this.city = city;
        this.kind = kind;
        this.title = title;
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

    /**
     * Gets the kind value
     *
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the kind value
     *
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Gets the title value
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title value
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "city='" + city + '\'' +
                ", kind='" + kind + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
