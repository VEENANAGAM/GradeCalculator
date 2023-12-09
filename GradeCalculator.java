import java.util.Scanner;
//Author:Veena_Nagam
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for grade weights
        final double HOMEWORK_MARKS_WEIGHT = 0.20;   // 20% of Total Grade
        final double QUIZ_MARKS_WEIGHT = 0.05;       // 5% of Total Grade
        final double MIDTERM_MARKS_WEIGHT = 0.25;    // 25% of Total Grade
        final double FINALEXAM_MARKS_WEIGHT = 0.30;  // 30% of Total Grade
        final double FINALPROJECT_MARKS_WEIGHT = 0.20; // 20% of Total Grade

        // Maximum scores for each category
        final int MAX_HOMEWORK_MARKS = 30;
        final int MAX_QUIZ_MARKS = 10;
        final int MAX_MIDTERM_MARKS = 100;
        final int MAX_FINALEXAM_MARKS = 100;
        final int MAX_FINALPROJECT_MARKS = 100;

        // Input scores
        double homeworkAverage = getAverageScore(scanner, "Homework", MAX_HOMEWORK_MARKS, 8);
        double quizAverage = getAverageScore(scanner, "Quiz", MAX_QUIZ_MARKS, 5);
        double midtermScore = getScore(scanner, "Mid-Term Exam", MAX_MIDTERM_MARKS);
        double finalExamScore = getScore(scanner, "Final Exam", MAX_FINALEXAM_MARKS);
        double finalProjectScore = getScore(scanner, "Final Project", MAX_FINALPROJECT_MARKS);

        // Calculate total grade
        double totalGrade = (homeworkAverage / MAX_HOMEWORK_MARKS * HOMEWORK_MARKS_WEIGHT) +
                (quizAverage / MAX_QUIZ_MARKS * QUIZ_MARKS_WEIGHT) +
                (midtermScore / MAX_MIDTERM_MARKS * MIDTERM_MARKS_WEIGHT) +
                (finalExamScore / MAX_FINALEXAM_MARKS * FINALEXAM_MARKS_WEIGHT) +
                (finalProjectScore / MAX_FINALPROJECT_MARKS * FINALPROJECT_MARKS_WEIGHT);

        // Determine letter grade
        char letterGrade = calculateLetterGrade(totalGrade * 100);

        System.out.println("Letter Grade: " + letterGrade);
    }

    private static double getAverageScore(Scanner scanner, String assignmentType, int maxScore, int numAssignments) {
        double totalScore = 0;

        for (int i = 1; i <= numAssignments; i++) {
            totalScore += getScore(scanner, assignmentType + " " + i, maxScore);
        }

        return totalScore / numAssignments;
    }

    private static double getScore(Scanner scanner, String assignmentType, int maxScore) {
        double score;

        do {
            System.out.print("Marks for Assignment " + assignmentType + " : ");
            score = scanner.nextDouble();

            if (score < 0 || score > maxScore) {
                System.out.println("Error: Your marks must be between 0 and " + maxScore);
            }

        } while (score < 0 || score > maxScore);

        return score;
    }

    private static char calculateLetterGrade(double totalGrade) {
        if (totalGrade >= 92) {
            return 'A';
        } else if (totalGrade >= 82)  {
            return 'B';
        } else if (totalGrade >= 72) {
            return 'C';
        } else if (totalGrade >= 62) {
            return 'D';
        } else if (totalGrade >= 52) {
            return 'E';
    
    
        } else {
            return 'F';
        }
    }
}
