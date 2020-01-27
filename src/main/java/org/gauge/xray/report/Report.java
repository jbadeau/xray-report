
package org.gauge.xray.report;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("testExecutionKey")
    @Expose
    private String testExecutionKey;
    @SerializedName("info")
    @Expose
    private Info info;
    /**
     * (Required)
     */
    @SerializedName("tests")
    @Expose
    private List<Test> tests = new ArrayList();

    public String getTestExecutionKey() {
        return testExecutionKey;
    }

    public void setTestExecutionKey(String testExecutionKey) {
        this.testExecutionKey = testExecutionKey;
    }

    public Report withTestExecutionKey(String testExecutionKey) {
        this.testExecutionKey = testExecutionKey;
        return this;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Report withInfo(Info info) {
        this.info = info;
        return this;
    }

    /**
     * (Required)
     */
    public List<Test> getTests() {
        return tests;
    }

    /**
     * (Required)
     */
    public void addTests(List<Test> tests) {
        this.tests = tests;
    }

    public Report withTests(List<Test> tests) {
        this.tests = tests;
        return this;
    }

    public void addTest(Test test) {
        this.tests.add(test);
    }

}
