
package org.gauge.xray.report;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("evidences")
    @Expose
    private List<Evidence> evidences = new ArrayList<Evidence>();

    /**
     * 
     * (Required)
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Step withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Step withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<Evidence> getEvidences() {
        return evidences;
    }

    public void setEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
    }

    public Step withEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
        return this;
    }

}
