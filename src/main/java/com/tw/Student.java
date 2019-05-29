package com.tw;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String num;
    private Map<String,Integer> scoreMap;

    public Student(String name, String num) {
        this.name = name;
        this.num = num;
        scoreMap = new HashMap<>();
        scoreMap.put("数学",0);
        scoreMap.put("语文",0);
        scoreMap.put("英语",0);
        scoreMap.put("编程",0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Map<String, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(String subject, Integer score) {
        scoreMap.put(subject,score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getNum().equals(student.getNum());
    }
}
