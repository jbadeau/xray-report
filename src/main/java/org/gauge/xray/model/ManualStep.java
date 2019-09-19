package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ManualStep {
    private String action;
    private String data;
    private String result;

    @JsonProperty("action")
    public String getAction() { return action; }
    @JsonProperty("action")
    public void setAction(String value) { this.action = value; }

    @JsonProperty("data")
    public String getData() { return data; }
    @JsonProperty("data")
    public void setData(String value) { this.data = value; }

    @JsonProperty("result")
    public String getResult() { return result; }
    @JsonProperty("result")
    public void setResult(String value) { this.result = value; }
}
