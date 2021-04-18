package CollectionsFrameWork;

public class Student {
    String name, classes;
    Double maths, chemistry, physics, avgMarks;
    char type;

    public Student() {

    }

    public Student(String name, String classes, Double maths, Double chemistry, Double physics, char type) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.chemistry = chemistry;
        this.physics = physics;
        this.type = type;
    }

    public String getClasses() {
        return classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getType() {
        return type;
    }


    public double getAvgMarks() {
        this.avgMarks = (this.maths + this.physics + this.chemistry) / 3;
        return avgMarks;
    }


}
