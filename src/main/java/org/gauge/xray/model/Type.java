package org.gauge.xray.model;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    BACKGROUND, HOOK, STEP;

    @JsonValue
    public String toValue() {
        switch (this) {
        case BACKGROUND: return "background";
        case HOOK: return "hook";
        case STEP: return "step";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("background")) return BACKGROUND;
        if (value.equals("hook")) return HOOK;
        if (value.equals("step")) return STEP;
        throw new IOException("Cannot deserialize Type");
    }
}
