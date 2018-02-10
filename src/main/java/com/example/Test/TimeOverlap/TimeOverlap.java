package com.example.Test.TimeOverlap;

import com.example.Test.TimeOverlap.data.Test;
import com.example.Test.TimeOverlap.data.TestSet;
import com.example.Test.TimeOverlap.data.TimeRange;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class TimeOverlap {

    private static String testCases = "{\n" +
            "\t\"test_set\": [{\n" +
            "\t\t\"is_overlapping\": false,\n" +
            "\t\t\"time_ranges\": [{\n" +
            "\t\t\t\"start\": \"2016-01-21 10:00:00+00:00\",\n" +
            "\t\t\t\"end\": \"2016-01-21 10:00:00+00:00\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\t\t\"is_overlapping\": false,\n" +
            "\t\t\"time_ranges\": [{\n" +
            "\t\t\t\t\"start\": \"2016-01-25 10:00:25+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-26 10:00:12+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 11:25:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-25 09:59:59+59:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-27 10:00:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-28 15:16:00+00:00\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}, {\n" +
            "\t\t\"is_overlapping\": true,\n" +
            "\t\t\"time_ranges\": [{\n" +
            "\t\t\t\t\"start\": \"2016-01-25 10:00:25+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-26 10:00:12+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 11:25:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-25 16:10:23+59:00\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}, {\n" +
            "\t\t\"is_overlapping\": false,\n" +
            "\t\t\"time_ranges\": [{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:21:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:22:10+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 11:25:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-25 13:10:23+59:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 13:10:24+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 13:14:24+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:31:12+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:31:15+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 13:14:27+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:20:10+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:25:30+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:25:32+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:27:12+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:29:41+00:00\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}, {\n" +
            "\t\t\"is_overlapping\": true,\n" +
            "\t\t\"time_ranges\": [{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:21:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:22:10+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 11:25:00+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-25 13:10:23+59:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:25:30+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:27:32+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 13:10:24+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 13:14:24+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 13:14:27+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 15:20:10+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:31:12+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:31:15+00:00\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"start\": \"2016-01-21 14:27:12+00:00\",\n" +
            "\t\t\t\t\"end\": \"2016-01-21 14:29:41+00:00\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}]\n" +
            "}";

    public static void main(String args[]) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TestSet testSet = objectMapper.readValue(testCases, TestSet.class);
        for(Test item: testSet.getTest_set()) {
            boolean is_overlapping = item.isIs_overlapping();
            List<TimeRange> time_ranges = item.getTime_ranges();
            List<String> start_times = new ArrayList<String>();
            Map<String, String> map = new HashMap<String, String>();
            for(TimeRange timeRange: time_ranges) {
                String key = timeRange.getStart();
                String value = timeRange.getEnd();
                if(map.containsKey(key)) {
                    String temp = map.get(key);
                    if(value.compareTo(temp)==1) {
                        map.put(key, value);
                    }
                } else  {
                    map.put(key, value);
                    start_times.add(key);
                }
            }
            Collections.sort(start_times);
            String start_time = "000";
            String end_time = "000";
            boolean overlap_calculated = false;
            for(String startTime: start_times) {
                //System.out.println("   "+start_time+ " "+ end_time);
                start_time = startTime;
                if(start_time.compareTo(end_time) < 0) {
                    //System.out.println(start_time+ " "+ end_time);
                    overlap_calculated = true;
                    break;
                }
                end_time = map.get(start_time);
            }
            if(overlap_calculated == is_overlapping) {
                //System.out.println(overlap_calculated + " " + is_overlapping);
                System.out.println(true);
            } else {
                //System.out.println(overlap_calculated + " " + is_overlapping);
                System.out.println(false);
            }
        }
    }
}
