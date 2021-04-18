package CollectionsFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MSProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        char confirmContinue = 'Y';
        List<Student> studentList = new ArrayList<>();
        Double mathsInput, chemistryInput, physicsInput;
        Character type;
        while (confirmContinue == 'Y') {
            System.out.println("Name:");
            String name = input.nextLine();
            System.out.println("Classes:");
            String classes = input.nextLine();
            do {
                mathsInput = sm.checkMathsInput();
            } while (mathsInput == null);
            do {
                chemistryInput = sm.checkChemistryInput();
            } while (chemistryInput == null);
            do {
                physicsInput = sm.checkPhysicsInput();
            } while (physicsInput == null);
            type = sm.getType();
            var student = new Student(name, classes, mathsInput, chemistryInput, physicsInput, type);
            studentList.add(student);
            System.out.println("Do you want to enter more student information?(Y/N):");
            confirmContinue = input.nextLine().charAt(0);

        }
        input.close();
        sm.displayStudentInfo(studentList);
        System.out.println("--------Mark Info--------");
        sm.getMaxAndMinAVG(studentList).forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println("--------Classification Info--------");
        sm.getPercentTypeStudent(studentList).forEach((key, value) -> System.out.println(key + value));
    }

}
