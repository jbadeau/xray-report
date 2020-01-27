
package org.gauge.xray.report;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evidence {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("data")
    @Expose
    private String data;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    /**
     * 
     * (Required)
     * 
     */
    public String getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setData(String data) {
        this.data = data;
    }

    public Evidence withData(String data) {
        this.data = data;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Evidence withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Evidence withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

}
