package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Example {
    private Double duration;
    private Double rank;
    private Status status;
    private List<ExampleStep> steps;

    @JsonProperty("duration")
    public Double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(Double value) { this.duration = value; }

    @JsonProperty("rank")
    public Double getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Double value) { this.rank = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }

    @JsonProperty("steps")
    public List<ExampleStep> getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(List<ExampleStep> value) { this.steps = value; }
}
