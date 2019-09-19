package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TestExecutionInfo {
    private String description;
    private String finishDate;
    private String project;
    private String revision;
    private String startDate;
    private String summary;
    private List<String> testEnvironments;
    private String testPlanKey;
    private String user;
    private String version;

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("finishDate")
    public String getFinishDate() { return finishDate; }
    @JsonProperty("finishDate")
    public void setFinishDate(String value) { this.finishDate = value; }

    @JsonProperty("project")
    public String getProject() { return project; }
    @JsonProperty("project")
    public void setProject(String value) { this.project = value; }

    @JsonProperty("revision")
    public String getRevision() { return revision; }
    @JsonProperty("revision")
    public void setRevision(String value) { this.revision = value; }

    @JsonProperty("startDate")
    public String getStartDate() { return startDate; }
    @JsonProperty("startDate")
    public void setStartDate(String value) { this.startDate = value; }

    @JsonProperty("summary")
    public String getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(String value) { this.summary = value; }

    @JsonProperty("testEnvironments")
    public List<String> getTestEnvironments() { return testEnvironments; }
    @JsonProperty("testEnvironments")
    public void setTestEnvironments(List<String> value) { this.testEnvironments = value; }

    @JsonProperty("testPlanKey")
    public String getTestPlanKey() { return testPlanKey; }
    @JsonProperty("testPlanKey")
    public void setTestPlanKey(String value) { this.testPlanKey = value; }

    @JsonProperty("user")
    public String getUser() { return user; }
    @JsonProperty("user")
    public void setUser(String value) { this.user = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }
}
