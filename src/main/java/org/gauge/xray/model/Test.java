package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Test {
    private List<String> labels;
    private String requirementKey;
    private List<ManualStep> manualTestDefinition;
    private String projectKey;
    private String summary;
    private String cucumberTestDefinition;
    private String genericTestDefinition;

    @JsonProperty("labels")
    public List<String> getLabels() { return labels; }
    @JsonProperty("labels")
    public void setLabels(List<String> value) { this.labels = value; }

    @JsonProperty("requirementKey")
    public String getRequirementKey() { return requirementKey; }
    @JsonProperty("requirementKey")
    public void setRequirementKey(String value) { this.requirementKey = value; }

    @JsonProperty("manualTestDefinition")
    public List<ManualStep> getManualTestDefinition() { return manualTestDefinition; }
    @JsonProperty("manualTestDefinition")
    public void setManualTestDefinition(List<ManualStep> value) { this.manualTestDefinition = value; }

    @JsonProperty("projectKey")
    public String getProjectKey() { return projectKey; }
    @JsonProperty("projectKey")
    public void setProjectKey(String value) { this.projectKey = value; }

    @JsonProperty("summary")
    public String getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(String value) { this.summary = value; }

    @JsonProperty("cucumberTestDefinition")
    public String getCucumberTestDefinition() { return cucumberTestDefinition; }
    @JsonProperty("cucumberTestDefinition")
    public void setCucumberTestDefinition(String value) { this.cucumberTestDefinition = value; }

    @JsonProperty("genericTestDefinition")
    public String getGenericTestDefinition() { return genericTestDefinition; }
    @JsonProperty("genericTestDefinition")
    public void setGenericTestDefinition(String value) { this.genericTestDefinition = value; }
}
