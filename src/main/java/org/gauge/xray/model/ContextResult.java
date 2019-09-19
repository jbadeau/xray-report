package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContextResult {
    private List<Example> detailedExamples;
    private Double duration;
    private List<Evidence> evidences;
    private List<Status> examples;
    private String log;
    private String name;
    private Status status;

    @JsonProperty("detailedExamples")
    public List<Example> getDetailedExamples() { return detailedExamples; }
    @JsonProperty("detailedExamples")
    public void setDetailedExamples(List<Example> value) { this.detailedExamples = value; }

    @JsonProperty("duration")
    public Double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(Double value) { this.duration = value; }

    @JsonProperty("evidences")
    public List<Evidence> getEvidences() { return evidences; }
    @JsonProperty("evidences")
    public void setEvidences(List<Evidence> value) { this.evidences = value; }

    @JsonProperty("examples")
    public List<Status> getExamples() { return examples; }
    @JsonProperty("examples")
    public void setExamples(List<Status> value) { this.examples = value; }

    @JsonProperty("log")
    public String getLog() { return log; }
    @JsonProperty("log")
    public void setLog(String value) { this.log = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }
}
