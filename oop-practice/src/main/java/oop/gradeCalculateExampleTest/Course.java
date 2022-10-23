package oop.gradeCalculateExampleTest;

public class Course {
    private final String subject; // 과목명
    private final int credit; // 학점
    private final String grade; // 성적 (A+, A, B+ ...)

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    // re-factoring
    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }

    public double getGradeToNumber() {
        double grade;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2;
                break;
            default:
                grade = 0;
        }
        return grade;
    }
}
