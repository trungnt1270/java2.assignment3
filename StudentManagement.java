package CollectionsFrameWork;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    Double maths, physics, chemistry, avgMark;
    char type;
    Scanner sc = new Scanner(System.in);

    public Double checkMathsInput() {
        System.out.println("Math:");
        maths = sc.nextDouble();
        if (!Double.isNaN(maths)) {
            if (maths <= 0) {
                System.out.println("Maths is greater than zero");
                return null;
            } else if (maths > 10) {
                System.out.println("Maths is equal or less than ten");
                return null;
            }
        } else {
            System.out.println("Maths is digit");
            return null;
        }
        return maths;
    }

    public Double checkChemistryInput() {
        System.out.println("Chemistry:");
        chemistry = sc.nextDouble();
        if (!Double.isNaN(chemistry)) {
            if (chemistry <= 0) {
                System.out.println("Chemistry is greater than zero");
                return null;
            } else if (chemistry > 10) {
                System.out.println("Chemistry is equal or less than ten");
                return null;
            }
        } else {
            System.out.println("Chemistry is digit");
            return null;
        }
        return chemistry;
    }

    public Double checkPhysicsInput() {
        System.out.println("Physics:");
        physics = sc.nextDouble();
        if (!Double.isNaN(physics)) {
            if (physics <= 0) {
                System.out.println("Physics is greater than zero");
                return null;
            } else if (physics > 10) {
                System.out.println("Physics is equal or less than ten");
                return null;
            }
        } else {
            System.out.println("Physics is digit");
            return null;
        }
        return physics;
    }

    public Character getType() {
        if (getAvgMark() < 4) {
            this.type = 'D';
        } else if (getAvgMark() >= 4 && getAvgMark() < 6) {
            this.type = 'C';
        } else if (getAvgMark() >= 6 && getAvgMark() <= 7.5) {
            this.type = 'B';
        } else {
            this.type = 'A';
        }
        return type;
    }

    public Double getAvgMark() {
        avgMark = (maths + chemistry + physics) / 3;
        return avgMark;
    }


    public HashMap<String, String> getPercentTypeStudent(List<Student> students) {
        int countTypeA = 0, countTypeB = 0, countTypeC = 0, countTypeD = 0, sumTypeValues;
        for (Student s : students) {
            if (s.getType() == 'A') {
                countTypeA++;
            } else if (s.getType() == 'B') {
                countTypeB++;
            } else if (s.getType() == 'C') {
                countTypeC++;
            } else {
                countTypeD++;
            }
        }
        sumTypeValues = countTypeA + countTypeB + countTypeC + countTypeD;
        double Apercent, Bpercent, Cpercent, Dpercent;
        Apercent = (double) countTypeA / sumTypeValues * 100;
        Bpercent = (double) countTypeB / sumTypeValues * 100;
        Cpercent = (double) countTypeC / sumTypeValues * 100;
        Dpercent = 100 - (Apercent + Bpercent + Cpercent);
        HashMap<String, String> stdType = new HashMap<>();
        stdType.put("A:", String.format("%.0f%%", Apercent));
        stdType.put("B:", String.format("%.0f%%", Bpercent));
        stdType.put("C:", String.format("%.0f%%", Cpercent));
        stdType.put("D:", String.format("%.0f%%", Dpercent));

        return stdType;
    }

    public HashMap<String, String> getMaxAndMinAVG(List<Student> students) {
        double min = students.get(0).getAvgMarks();
        double max = students.get(0).getAvgMarks();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAvgMarks() < min) {
                min = students.get(i).getAvgMarks();
            }
        }
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAvgMarks() > max) {
                max = students.get(i).getAvgMarks();
            }
        }
        HashMap<String, String> stdAvgMarks = new HashMap<>();
        stdAvgMarks.put("AVG Mark Min: ", String.format("%.1f", min));
        stdAvgMarks.put("AVG Mark Max: ", String.format("%.1f", max));

        return stdAvgMarks;
    }

    public void displayStudentInfo(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("------ Student%d Info ------%n", i + 1);
            System.out.println("Name:" + students.get(i).getName());
            System.out.println("Classes:" + students.get(i).getClasses());
            System.out.printf("AVG:%.1f%n", students.get(i).getAvgMarks());
            System.out.println("Type:" + students.get(i).getType());
        }
    }
}
