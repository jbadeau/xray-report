package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ExampleStep {
    private Double duration;
    private String errorMessage;
    private List<Evidence> evidences;
    private String keyword;
    private String name;
    private Double rank;
    private Status status;
    private Type type;

    @JsonProperty("duration")
    public Double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(Double value) { this.duration = value; }

    @JsonProperty("errorMessage")
    public String getErrorMessage() { return errorMessage; }
    @JsonProperty("errorMessage")
    public void setErrorMessage(String value) { this.errorMessage = value; }

    @JsonProperty("evidences")
    public List<Evidence> getEvidences() { return evidences; }
    @JsonProperty("evidences")
    public void setEvidences(List<Evidence> value) { this.evidences = value; }

    @JsonProperty("keyword")
    public String getKeyword() { return keyword; }
    @JsonProperty("keyword")
    public void setKeyword(String value) { this.keyword = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("rank")
    public Double getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Double value) { this.rank = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }
}
