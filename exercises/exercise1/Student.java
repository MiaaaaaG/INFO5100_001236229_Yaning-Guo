import java.util.ArrayList;
import java.util.Collections;
public class Student {
    private String name;
    private double[] quizScores = new double[15];

    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setQuizScore(int index, double score) {
        quizScores[index] = score;
    }

    public double getQuizScore(int index) {
        return quizScores[index];
    }
}

class PartTime extends Student {
    public PartTime(String name) {
        super(name);
    }
}

class FullTime extends Student {
    private double exam1Score;
    private double exam2Score;

    public FullTime(String name, double exam1Score, double exam2Score) {
        super(name);
        this.exam1Score = exam1Score;
        this.exam2Score = exam2Score;
    }

    public double getExam1Score() {
        return exam1Score;
    }

    public double getExam2Score() {
        return exam2Score;
    }
}

class Session {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateAverageQuizScore() {
        double sum = 0.0;
        for (Student student : students) {
            for (int i = 0; i < 15; i++) {
                sum += student.getQuizScore(i);
            }
        }
        return sum / (15 * students.size());
    }

    public void printQuizScores() {
        ArrayList<Double> allQuizScores = new ArrayList<>();
        for (Student student : students) {
            for (int i = 0; i < 15; i++) {
                allQuizScores.add(student.getQuizScore(i));
            }
        }
        Collections.sort(allQuizScores);
        for (Double score : allQuizScores) {
            System.out.println(score);
        }
    }

    public void printPartTimeStudents() {
        for (Student student : students) {
            if (student instanceof PartTime) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeExamScores() {
        for (Student student : students) {
            if (student instanceof FullTime) {
                FullTime fullTimeStudent = (FullTime) student;
                System.out.println(fullTimeStudent.getName() + ": Exam 1 score = " + fullTimeStudent.getExam1Score()
                        + ", Exam 2 score = " + fullTimeStudent.getExam2Score());
            }
        }
    }
}