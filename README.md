[![Codefresh build status]( https://g.codefresh.io/api/badges/pipeline/jbadeau/xray-report%2Fbuild?type=cf-1&key=eyJhbGciOiJIUzI1NiJ9.NWQ4NWM1MmZmZDJkZWY3MzVjMDIyNmY1.65xP0iIixl3qVtmA9g4HZK1DVuawEleW4W30ZFArCXQ)]( https://g.codefresh.io/pipelines/edit/new/builds?id=5e5e05eb35bf1863521e4e57&pipeline=build&projects=xray-report&projectId=5e56cc98f5ff833beb1ffa5b)

# xray-report 
  
Jira [Xray](https://www.getxray.app/) plugin for [Gauge](http://gauge.org)  

Please note that this is a preview release and am looking for feedback on:

- What a failure report should look like and contain
- Upload Gauge specs to autocreate Xray tests

I will soon release a Jira plugin that allows Xray tests to render Gauge Specs with formatting and syntax highlighting. 

Installation
------------

```bash
gauge install xray-report
```

#### Installing specific version:

```bash
gauge install xray-report --version x.x.x
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
  "Plugins": [
    "xray-report"
  ]
}
```

#### Provide the following env variables

| Name                        | Description                    | Values        | Default | Required  | Example                           |
| ----------------------------|--------------------------------| --------------|---------|-----------|-----------------------------------|
| jira_url                    | Base URL of Jira API           |               |         | true      | https://your-domain.atlassian.net |
| jira_username               | Jira username                  |               |         | false     |                                   |
| jira_token                  | Jira token                     |               |         | false     |                                   |
| jira_test_execution_id      | Reuse Jira test execution      |               |         | false     |                                   |
| jira_test_execution_summary | Summary of Jira test execution |               |         | false     |                                   |

> Do **NOT** save the 'jira_token' in source code. 


#### Add **TestCaseId:\<XrayTestKey>** tag to scenarios

```markdown  
## Scenario
Tags: TestCaseId:PROJECT-1
```
