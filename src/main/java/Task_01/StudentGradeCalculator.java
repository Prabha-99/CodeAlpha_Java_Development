package Task_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList to store student grades
        ArrayList<Integer> grades = new ArrayList<>();

        // Ask the teacher to enter grades until they're done
        System.out.println("Enter students' grades (enter -1 to finish):");
        int grade;
        while (true) {
            System.out.print("Enter grade: ");
            grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            grades.add(grade);
        }

        // Calculate average
        double average = calculateAverage(grades);
        System.out.println("Average grade: " + average);

        // Find highest grade
        int highestGrade = findHighestGrade(grades);
        System.out.println("Highest grade: " + highestGrade);

        // Find lowest grade
        int lowestGrade = findLowestGrade(grades);
        System.out.println("Lowest grade: " + lowestGrade);

        scanner.close();
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
