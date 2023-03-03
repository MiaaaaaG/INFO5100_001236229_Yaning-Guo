public class Main {
    public static void main(String[] args) {
        Session session = new Session();

        for (int i = 0; i < 10; i++) {
            FullTime fullTime = new FullTime("FullTime " + (i+1), i*2+70, i*2+80);
            for (int j = 0; j < 15; j++) {
                fullTime.setQuizScore(j, i*2+j);
            }
            session.addStudent(fullTime);
        }

        for (int i = 0; i < 10; i++) {
            PartTime partTime = new PartTime("PartTime " + (i+1));
            for (int j = 0; j < 15; j++) {
                partTime.setQuizScore(j, i*2+j);
            }
            session.addStudent(partTime);
        }

        System.out.println("Average quiz score for the session: " + session.calculateAverageQuizScore());

        System.out.println("Quiz scores in ascending order:");
        session.printQuizScores();

        System.out.println("Part-time students:");
        session.printPartTimeStudents();

        System.out.println("Full-time exam scores:");
        session.printFullTimeExamScores();
    }
}