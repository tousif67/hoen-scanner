package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyscanner.search.SearchResource;
import com.skyscanner.search.SearchResult;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    // List to store all search results
    private final List<SearchResult> searchResults = new ArrayList<>();

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {

    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> carResults = Arrays.asList(
                mapper.readValue(
                        getClass().getClassLoader().getResource("rental_cars.json"),
                        SearchResult[].class
                )
        );

        List<SearchResult> hotelResults = Arrays.asList(
                mapper.readValue(
                        getClass().getClassLoader().getResource("hotels.json"),
                        SearchResult[].class
                )
        );

        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(carResults);
        searchResults.addAll(hotelResults);
        final SearchResource resource= new SearchResource(searchResults);
        environment.jersey().register(resource);
    }
    /**
     * Loads search results from JSON files specified in the configuration
     *
     * @param configuration The application configuration
     * @throws IOException If there's an error reading the files
     */
    private void loadSearchResults(HoenScannerConfiguration configuration) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Load first file
        String file1Path = configuration.getResultsFile1Path();
        if (file1Path != null && !file1Path.isEmpty()) {
            List<SearchResult> results1 = mapper.readValue(
                    new File(file1Path),
                    new TypeReference<List<SearchResult>>() {}
            );
            searchResults.addAll(results1);
        }

        // Load second file
        String file2Path = configuration.getResultsFile2Path();
        if (file2Path != null && !file2Path.isEmpty()) {
            List<SearchResult> results2 = mapper.readValue(
                    new File(file2Path),
                    new TypeReference<List<SearchResult>>() {}
            );
            searchResults.addAll(results2);
        }

        System.out.println("Loaded " + searchResults.size() + " search results from JSON files");
    }

    /**
     * Get the loaded search results
     *
     * @return List of search results
     */
    public List<SearchResult> getSearchResults() {
        return searchResults;
    }
}
