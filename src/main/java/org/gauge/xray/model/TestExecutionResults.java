package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TestExecutionResults {
    private TestExecutionInfo info;
    private String testExecutionKey;
    private List<XrayTest> tests;

    @JsonProperty("info")
    public TestExecutionInfo getInfo() { return info; }
    @JsonProperty("info")
    public void setInfo(TestExecutionInfo value) { this.info = value; }

    @JsonProperty("testExecutionKey")
    public String getTestExecutionKey() { return testExecutionKey; }
    @JsonProperty("testExecutionKey")
    public void setTestExecutionKey(String value) { this.testExecutionKey = value; }

    @JsonProperty("tests")
    public List<XrayTest> getTests() { return tests; }
    @JsonProperty("tests")
    public void setTests(List<XrayTest> value) { this.tests = value; }
}
