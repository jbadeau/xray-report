package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TestStepResult {
    private String comment;
    private List<String> defects;
    private List<Evidence> evidences;
    private String status;

    @JsonProperty("comment")
    public String getComment() { return comment; }
    @JsonProperty("comment")
    public void setComment(String value) { this.comment = value; }

    @JsonProperty("defects")
    public List<String> getDefects() { return defects; }
    @JsonProperty("defects")
    public void setDefects(List<String> value) { this.defects = value; }

    @JsonProperty("evidences")
    public List<Evidence> getEvidences() { return evidences; }
    @JsonProperty("evidences")
    public void setEvidences(List<Evidence> value) { this.evidences = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }
}
