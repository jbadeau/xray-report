package org.gauge.xray.model;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Status {
    EXECUTING, FAILED, PASSED, TODO;

    @JsonValue
    public String toValue() {
        switch (this) {
        case EXECUTING: return "EXECUTING";
        case FAILED: return "FAILED";
        case PASSED: return "PASSED";
        case TODO: return "TODO";
        }
        return null;
    }

    @JsonCreator
    public static Status forValue(String value) throws IOException {
        if (value.equals("EXECUTING")) return EXECUTING;
        if (value.equals("FAILED")) return FAILED;
        if (value.equals("PASSED")) return PASSED;
        if (value.equals("TODO")) return TODO;
        throw new IOException("Cannot deserialize Status");
    }
}
