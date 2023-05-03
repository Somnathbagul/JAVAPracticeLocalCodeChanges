package com.sb.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final int immutableInt;
    private final String immutableString;
    private final List<String> immutableList;

    public ImmutableClass(int immutableInt, String immutableString, List<String> immutableList) {
        this.immutableInt = immutableInt;
        this.immutableString = immutableString;
        this.immutableList = Collections.unmodifiableList(new ArrayList<>(immutableList));
    }

    public int getImmutableInt() {
        return immutableInt;
    }

    public String getImmutableString() {
        return immutableString;
    }

    public List<String> getImmutableList() {
        return immutableList;
    }
}
