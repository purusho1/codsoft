package hello;
import java.util.*;
public class grade_calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the  total number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1)+":\n" );
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);
        
        System.out.println("\nResults:");
        System.out.println("Total Marks obtained: " + totalMarks);
        System.out.println("Average Percentage obtained : " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

}
