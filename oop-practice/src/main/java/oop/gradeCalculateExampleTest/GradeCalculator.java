package oop.gradeCalculateExampleTest;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;
//    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {

        // (학점수×교과목 평점)의 합계
        /*
        double multipliedCreditAndCourseGrade = 0D;
        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            //re-factoring
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        */

        //re-factoring
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();

        // 수강신청 총학점 수
        /*
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
        */

        //re-factoring
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

//        return multipliedCreditAndCourseGrade / totalCompletedCredit;

        // re-factoring
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
