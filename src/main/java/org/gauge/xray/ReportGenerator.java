package org.gauge.xray;

import com.google.protobuf.ProtocolStringList;
import com.thoughtworks.gauge.Messages;
import com.thoughtworks.gauge.Spec;
import org.gauge.xray.report.Evidence;
import org.gauge.xray.report.Info;
import org.gauge.xray.report.Report;
import org.gauge.xray.report.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public final class ReportGenerator {

    private static final String STATUS_PASS = "PASS";

    private static final String STATUS_FAIL = "FAIL";


    private ReportGenerator() {
    }

    public static List<Report> generate(Messages.SuiteExecutionResult suite, String jiraTestExecutionId, String jiraTestExecutionSummary) {
        List<Report> reports = new ArrayList();
        for (Spec.ProtoSpecResult spec : suite.getSuiteResult().getSpecResultsList()) {
            Report report = new Report();
            report.setInfo(createInfo(suite.getSuiteResult(), jiraTestExecutionSummary));
            report.setTestExecutionKey(jiraTestExecutionId != null ? jiraTestExecutionId : getTestExecutionKey(spec));
            for (Spec.ProtoItem scenario : spec.getProtoSpec().getItemsList()) {
                Test test = createTest(scenario);
                if (test != null) {
                    report.addTest(test);
                }
            }
            reports.add(report);
        }
        return reports;
    }

    private static Test createTest(Spec.ProtoItem scenario) {
        Test test = null;
        String testKey = getTestCaseId(scenario);
        if (testKey != null) {
            test = new Test();
            test.setTestKey(testKey);
            test.setStatus(STATUS_PASS);
            switch (scenario.getItemType()) {
                case Scenario:
                case TableDrivenScenario:
                    if (scenario.getScenario().getExecutionStatus() == Spec.ExecutionStatus.FAILED) {
                        test.setStatus(STATUS_FAIL);
                        test.addEvidence(createEvidence(scenario));
                    }
                    break;
            }
        }
        return test;
    }

    private static Info createInfo(Spec.ProtoSuiteResult spec, String jiraTestExecutionSummary) {
        Info info = new Info();
        info.setSummary(jiraTestExecutionSummary != null ? jiraTestExecutionSummary : spec.getProjectName());
        info.setTestEnvironments(Arrays.asList(spec.getEnvironment().split(",")));
        return info;
    }

    private static Evidence createEvidence(Spec.ProtoItem scenario) {
        Evidence evidence = new Evidence();
        evidence.setContentType("plain/text");
        evidence.setFilename(scenario.getScenario().getScenarioHeading().replace(" ", "_") + ".txt");
        evidence.setData(getStacktrace(scenario.getScenario().getScenarioItemsList()));
        return evidence;
    }

    private static String getStacktrace(List<Spec.ProtoItem> items) {
        String stacktrace = null;
        for (Spec.ProtoItem item : items) {
            if (item.getItemType() == Spec.ProtoItem.ItemType.Concept) {
                stacktrace = getStacktrace(item.getConcept().getStepsList());
            }
            if (item.getItemType() == Spec.ProtoItem.ItemType.Step) {
                stacktrace = item.getStep().getStepExecutionResult().getExecutionResult().getStackTrace();
            }
            // TODO check if more cases need to be supported
        }
        return Base64.getUrlEncoder().encodeToString(stacktrace.getBytes(StandardCharsets.UTF_8));
    }

    private static String getTestCaseId(Spec.ProtoItem scenario) {
        return getTagValue(scenario.getScenario().getTagsList(), "TestCaseId:");
    }

    private static String getTestExecutionKey(Spec.ProtoSpecResult spec) {
        return getTagValue(spec.getProtoSpec().getTagsList(), "TestExecutionId:");
    }

    private static String getTagValue(ProtocolStringList tags, String tagPrefix) {
        if (tags != null) {
            for (String tag : tags) {
                if (tag.startsWith(tagPrefix)) {
                    return tag.substring(tagPrefix.length());
                }

            }
        }
        return null;
    }

}
