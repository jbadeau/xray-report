package org.gauge.xray.model;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Evidence {
    private String contentType;
    private String data;
    private String filename;

    @JsonProperty("contentType")
    public String getContentType() { return contentType; }
    @JsonProperty("contentType")
    public void setContentType(String value) { this.contentType = value; }

    @JsonProperty("data")
    public String getData() { return data; }
    @JsonProperty("data")
    public void setData(String value) { this.data = value; }

    @JsonProperty("filename")
    public String getFilename() { return filename; }
    @JsonProperty("filename")
    public void setFilename(String value) { this.filename = value; }
}
