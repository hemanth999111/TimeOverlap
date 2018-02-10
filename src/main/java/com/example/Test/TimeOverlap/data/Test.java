package com.example.Test.TimeOverlap.data;

import java.util.List;

public class Test {

    private boolean is_overlapping;
    private List<TimeRange> time_ranges;

    public boolean isIs_overlapping() {
        return is_overlapping;
    }

    public void setIs_overlapping(boolean is_overlapping) {
        this.is_overlapping = is_overlapping;
    }

    public List<TimeRange> getTime_ranges() {
        return time_ranges;
    }

    public void setTime_ranges(List<TimeRange> time_ranges) {
        this.time_ranges = time_ranges;
    }

    @Override
    public String toString() {
        return "Test{" +
                "is_overlapping=" + is_overlapping +
                ", time_ranges=" + time_ranges +
                '}';
    }
}
