package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class XrayTest {
    private String assignee;
    private String comment;
    private List<Object> defects;
    private List<Object> evidences;
    private List<String> examples;
    private String executedBy;
    private String finish;
    private List<ContextResult> results;
    private String start;
    private String status;
    private List<TestStepResult> steps;
    private Test testInfoBean;
    private Object testKey;

    @JsonProperty("assignee")
    public String getAssignee() { return assignee; }
    @JsonProperty("assignee")
    public void setAssignee(String value) { this.assignee = value; }

    @JsonProperty("comment")
    public String getComment() { return comment; }
    @JsonProperty("comment")
    public void setComment(String value) { this.comment = value; }

    @JsonProperty("defects")
    public List<Object> getDefects() { return defects; }
    @JsonProperty("defects")
    public void setDefects(List<Object> value) { this.defects = value; }

    @JsonProperty("evidences")
    public List<Object> getEvidences() { return evidences; }
    @JsonProperty("evidences")
    public void setEvidences(List<Object> value) { this.evidences = value; }

    @JsonProperty("examples")
    public List<String> getExamples() { return examples; }
    @JsonProperty("examples")
    public void setExamples(List<String> value) { this.examples = value; }

    @JsonProperty("executedBy")
    public String getExecutedBy() { return executedBy; }
    @JsonProperty("executedBy")
    public void setExecutedBy(String value) { this.executedBy = value; }

    @JsonProperty("finish")
    public String getFinish() { return finish; }
    @JsonProperty("finish")
    public void setFinish(String value) { this.finish = value; }

    @JsonProperty("results")
    public List<ContextResult> getResults() { return results; }
    @JsonProperty("results")
    public void setResults(List<ContextResult> value) { this.results = value; }

    @JsonProperty("start")
    public String getStart() { return start; }
    @JsonProperty("start")
    public void setStart(String value) { this.start = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("steps")
    public List<TestStepResult> getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(List<TestStepResult> value) { this.steps = value; }

    @JsonProperty("testInfoBean")
    public Test getTestInfoBean() { return testInfoBean; }
    @JsonProperty("testInfoBean")
    public void setTestInfoBean(Test value) { this.testInfoBean = value; }

    @JsonProperty("testKey")
    public Object getTestKey() { return testKey; }
    @JsonProperty("testKey")
    public void setTestKey(Object value) { this.testKey = value; }
}
