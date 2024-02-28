package Task_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        do {
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("|       |CodeAlpha| STUDENT MANAGEMENT SYSTEM        |");
            System.out.println("------------------------------------------------------");
            System.out.println("|\t1. Enter grades                                  |");
            System.out.println("|\t2. Exit                                          |");
            System.out.println("------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterGradesAndShowResults(scanner);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        } while (!exit);

        scanner.close();
    }

    //Allow to enter grades of 10 students continuously
    public static void enterGradesAndShowResults(Scanner scanner) {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
        }

        // Show results immediately after entering grades
        if (!grades.isEmpty()) {
            double average = calculateAverage(grades);
            int highestGrade = findHighestGrade(grades);
            int lowestGrade = findLowestGrade(grades);

            System.out.println();
            System.out.println("++++++++++++++++++++++++");
            System.out.println("| Average grade: " + average);
            System.out.println("| Highest grade: " + highestGrade);
            System.out.println("| Lowest grade : " + lowestGrade);
            System.out.println("++++++++++++++++++++++++");
        } else {
            System.out.println("No grades entered.");
        }
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public static int findHighestGrade(ArrayList<Integer> grades) {
        return Collections.max(grades);
    }

    // Method to find the lowest grade
    public static int findLowestGrade(ArrayList<Integer> grades) {
        return Collections.min(grades);
    }
}
