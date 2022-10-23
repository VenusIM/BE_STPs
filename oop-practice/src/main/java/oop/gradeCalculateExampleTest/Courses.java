package oop.gradeCalculateExampleTest;

import java.util.List;

// 일급 컬랙션 : 자료구조 하나를 필드로 가지는 Class
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        /*
       double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            //re-factoring
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;
        */

        // re-factoring
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
