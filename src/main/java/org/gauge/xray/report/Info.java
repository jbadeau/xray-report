
package org.gauge.xray.report;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Info {

    @SerializedName("project")
    @Expose
    private String project;
    /**
     * (Required)
     */
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("revision")
    @Expose
    private String revision;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("finishDate")
    @Expose
    private String finishDate;
    @SerializedName("testEnvironments")
    @Expose
    private List<String> testEnvironments = new ArrayList();

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Info withProject(String project) {
        this.project = project;
        return this;
    }

    /**
     * (Required)
     */
    public String getSummary() {
        return summary;
    }

    /**
     * (Required)
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Info withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Info withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Info withUser(String user) {
        this.user = user;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Info withVersion(String version) {
        this.version = version;
        return this;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Info withRevision(String revision) {
        this.revision = revision;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Info withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Info withFinishDate(String finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public List<String> getTestEnvironments() {
        return this.testEnvironments;
    }

    public void setTestEnvironments(List<String> testEnvironments) {
        this.testEnvironments = testEnvironments;
    }

    public Info withTestEnvironments(List<String> testEnvironments) {
        this.testEnvironments = testEnvironments;
        return this;
    }

    public void addTestEnvironments(String testEnvironment) {
        this.testEnvironments.add(testEnvironment);
    }
    
}
