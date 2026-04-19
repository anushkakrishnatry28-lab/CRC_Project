import java.util.Scanner;
class Student {
    private String name;
    private int rollNo;
    private int[] marks;
    private int subjects;
    public Student(String name, int rollNo, int subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
        marks = new int[subjects];
    }
    public void inputMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for " + subjects + " subjects:");
        for (int i = 0; i < subjects; i++) {
            marks[i] = sc.nextInt();
        }
    }
    public double calculatePercentage() {
        int sum = 0;
        for (int i = 0; i < subjects; i++) {
            sum += marks[i];
        }
        return (double) sum / subjects;
    }
    public double calculateGPA() {
        double percentage = calculatePercentage();
        return percentage / 10; 
    }
    public void displayGrade() {
        double per = calculatePercentage();

        if (per >= 90)
            System.out.println("Grade: A+");
        else if (per >= 75)
            System.out.println("Grade: A");
        else if (per >= 60)
            System.out.println("Grade: B");
        else if (per >= 50)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: Fail");
    }
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Percentage: " + calculatePercentage());
        System.out.println("GPA: " + calculateGPA());
        displayGrade();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        Student s1 = new Student(name, roll, subjects);

        s1.inputMarks();
        s1.displayDetails();
    }
}