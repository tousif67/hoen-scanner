package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;

public class HoenScannerConfiguration extends Configuration {
    @JsonProperty("resultsFile1Path")
    private String resultsFile1Path;

    @JsonProperty("resultsFile2Path")
    private String resultsFile2Path;

    /**
     * @return path to the first JSON results file
     */
    public String getResultsFile1Path() {
        return resultsFile1Path;
    }

    /**
     * @param resultsFile1Path path to the first JSON results file
     */
    public void setResultsFile1Path(String resultsFile1Path) {
        this.resultsFile1Path = resultsFile1Path;
    }

    /**
     * @return path to the second JSON results file
     */
    public String getResultsFile2Path() {
        return resultsFile2Path;
    }

    /**
     * @param resultsFile2Path path to the second JSON results file
     */
    public void setResultsFile2Path(String resultsFile2Path) {
        this.resultsFile2Path = resultsFile2Path;
    }
}
