package com.example.Test.TimeOverlap.data;

import java.util.List;

public class TestSet {

    private List<Test> test_set;

    public List<Test> getTest_set() {
        return test_set;
    }

    public void setTest_set(List<Test> test_set) {
        this.test_set = test_set;
    }

    @Override
    public String toString() {
        return "TestSet{" +
                "test_set=" + test_set +
                '}';
    }
}
