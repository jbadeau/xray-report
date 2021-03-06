[![Codefresh build status]( https://g.codefresh.io/api/badges/pipeline/jbadeau/gauge%2Fxray-report?type=cf-1&key=eyJhbGciOiJIUzI1NiJ9.NWQ4NWM1MmZmZDJkZWY3MzVjMDIyNmY1.65xP0iIixl3qVtmA9g4HZK1DVuawEleW4W30ZFArCXQ)]( https://g.codefresh.io/pipelines/edit/new/builds?id=5e5e05eb35bf1863521e4e57&pipeline=xray-report&projects=gauge&projectId=5e56cc98f5ff833beb1ffa5b)

# xray-report 
  
Jira [Xray](https://www.getxray.app/) plugin for [Gauge](http://gauge.org)   

Installation
------------

```bash
gauge install xray-report
```

#### Installing specific version:

```bash
gauge install xray-report --version 0.x.x
```

#### Offline installation
* Download the plugin from [Releases](https://github.com/jbadeau/xray-report/releases)

```bash
gauge install xray-report --file <path_to_plugin_zip_file>
```

Usage
-----

Add this plugin to your Gauge project by registering it in `manifest.json` file. You can also do this by:

```bash
{
  "Language": "",
  "Plugins": [
    "xray-report"
  ]
}
```

#### Provide the following env variables
```properties
jira_url = https://your.jira.url
jira_username = <user>
jira_password = <password>
jira_authentication = cookie/basic
```
> Do **NOT** save the 'jira_password' in source code. 

> Default jira_authentication is cookie if property not provided.

The following env variables are optional, and allow to configure a specific testExecutionId and summary:

```properties
jira_test_execution_id = JIRA_ID
jira_test_execution_summary = Expected JIRA issue summary
```

#### Add **TestCaseId:\<XrayTestKey>** tag to scenarios

```markdown  
## Scenario
Tags: TestCaseId:PROJECT-1
```

#### Reuse Test Execution

In order to avoid creating a new test execution for each run, add **TestExecutionId:\<XrayTestExecutionKey>** tag to spec.
Note: TestExecutionId defined in the tag will only be used if there was none set in the env variables. 

```markdown  
# Spec
Tags: TestExecutionId:PROJECT-2
```
