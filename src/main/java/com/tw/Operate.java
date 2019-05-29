package com.tw;

import java.util.*;

public class Operate {
    Map<String, Student> students = new HashMap<>();

    public int startShow() {
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
        System.out.println("请输入你的选择（1～3）：");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        return choice;
    }

    public void addStudent() {
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        Scanner sc = new Scanner(System.in);

        String[] str = sc.next().split(",");
        Student student = new Student(str[0], str[1]);

        for (int i = 2; i < str.length; i++) {
            String[] score = str[i].split(":");
            student.getScoreMap().put(score[0], Integer.parseInt(score[1]));
        }

        students.put(student.getNum(), student);
        System.out.println("学生" + student.getName() + "的成绩被添加");
    }

    public void showStudent() {
        System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");

        Scanner sc = new Scanner(System.in);
        String[] nums = sc.next().split(",");
        int scoreSum = 0;

        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================");

        for (String num : nums) {
            Student student = students.get(num);
            scoreSum = student.getScoreMap().get("数学") + student.getScoreMap().get("语文") + student.getScoreMap().get("英语") + student.getScoreMap().get("编程");
            System.out.println(student.getName() + "|" + student.getScoreMap().get("数学") + "|" + student.getScoreMap().get("语文") + "|" + student.getScoreMap().get("英语") + "|" + student.getScoreMap().get("编程") + "|" + scoreSum / 4 + "|" + scoreSum);
        }

        System.out.println("========================");
        System.out.println("全班总分平均数：" + scoreOfStudentsSum() / students.size());
        System.out.println("全班总分中位数：" + scoreOfStudentMedian());
    }

    public int scoreOfStudentsSum() {
        int studentsScore = 0;
        for (Student student : students.values()) {
            studentsScore += (student.getScoreMap().get("数学") + student.getScoreMap().get("语文") + student.getScoreMap().get("英语") + student.getScoreMap().get("编程"));
        }
        return studentsScore;
    }

    public int scoreOfStudentMedian() {
        List<Integer> list = new ArrayList<>();
        for (Student student : students.values()) {
            int score = (student.getScoreMap().get("数学") + student.getScoreMap().get("语文") + student.getScoreMap().get("英语") + student.getScoreMap().get("编程"));
            list.add(score);
        }
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1))/2;
        }
        return list.get(list.size()/2);
    }

}
