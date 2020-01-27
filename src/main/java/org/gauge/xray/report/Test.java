
package org.gauge.xray.report;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Test {

    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("finish")
    @Expose
    private String finish;
    @SerializedName("start")
    @Expose
    private String start;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("status")
    @Expose
    private String status;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("testKey")
    @Expose
    private String testKey;
    @SerializedName("executedBy")
    @Expose
    private String executedBy;
    @SerializedName("evidences")
    @Expose
    private List<Evidence> evidences = new ArrayList<Evidence>();
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
    @SerializedName("examples")
    @Expose
    private List<String> examples = new ArrayList<String>();
    @SerializedName("steps")
    @Expose
    private List<Step> steps = new ArrayList<Step>();

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Test withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Test withFinish(String finish) {
        this.finish = finish;
        return this;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Test withStart(String start) {
        this.start = start;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Test withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getTestKey() {
        return testKey;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }

    public Test withTestKey(String testKey) {
        this.testKey = testKey;
        return this;
    }

    public String getExecutedBy() {
        return executedBy;
    }

    public void setExecutedBy(String executedBy) {
        this.executedBy = executedBy;
    }

    public Test withExecutedBy(String executedBy) {
        this.executedBy = executedBy;
        return this;
    }

    public List<Evidence> getEvidences() {
        return evidences;
    }

    public void setEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
    }

    public Test withEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
        return this;
    }

    public void addEvidence(Evidence evidence) {
        this.evidences.add(evidence);
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Test withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public Test withExamples(List<String> examples) {
        this.examples = examples;
        return this;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Test withSteps(List<Step> steps) {
        this.steps = steps;
        return this;
    }

}
