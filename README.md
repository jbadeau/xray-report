# xray-report 
  
Jira Xray reporting plugin for [Gauge](http://gauge.org)  

## Usage  
 
### 1. Add this plugin to your Gauge project by registering it in **manifest.json**
```json
{  
  "Plugins": [  
  "xray-report"
  ]  
}
```
### 2. Add the following Gauge environment properties
```properties
jira_url = https://your.jira.host
jira_username = <TechnicalUser>
jira_password = <TechnicalUserPassword>
```
> Do **NOT** add these to your Gauge project properties as they are publicly visible.

### 3. Add **TestKey-\<XrayTestKey>** tag to scenarios

```markdown  
## Scenario
Tags: TestKey-EXMPL-1
```

### 4. Reuse Test Execution

In order to avoid create a new test execution for each run add **TestExecutionKey-\<XrayTestExecutionKey>** tag to spec 

```markdown  
# Spec
Tags: TestExecutionKey-EXMPL-2
```

## Build 
  
### 1. To build the plugin run   

```
../../gradlew clean build distro  
```
  
>Note the path that you are running this command. This is referred in the install step below**  
  
### 2. To install the plugin  
  
***nix systems (linux/osx etc)**  
  
- `mkdir /tmp/sample` - `cd /tmp/sample`  
- `gauge install xray-report -f <path_to_build>/artifacts/xray-report-0.1.0.zip`  
- `gauge run specs`
  
**Windows systems**  
- `mkdir %TEMP%\sample # on windows cmd`  
- `cd %TEMP%\sample`  
- `gauge install xray-report -f <path_to_build>\artifacts\json-report-example-0.1.0.zip`  
- `gauge run specs`
