# Example - JSON report with gauge

> DISCLAIMER: This is just an example. Not meant to be used as is in a project. 

> Note that there is a separate [json-report plugin](https://github.com/apoorvam/json-report) which gives a much better json.

This project is an example implementation of the [report-seed](https://github.com/getgauge-contrib/report-seed)

The idea is to get the raw execution result and transform it to json.

## Running this example

To build the plugin run 

`../../gradlew clean build distro`

**Note the path that you are running this command. This is referred in the install step below**

To install the plugin

***nix systems (linux/osx etc)**

- `mkdir /tmp/sample` 
- `cd /tmp/sample`
- `gauge install json-report-example -f <path_to_build>/artifacts/json-report-example-0.0.1.zip`
- `gauge run specs`
- Observe `reports/json-report-example/result.json`


**Windows systems**
- `mkdir %TEMP%\sample # on windows cmd`
- `cd %TEMP%\sample`
- `gauge install json-report-example -f <path_to_build>\artifacts\json-report-example-0.0.1.zip`
- `gauge run specs`
- Observe `reports\json-report-example\result.json`
