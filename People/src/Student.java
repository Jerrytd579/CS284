public class Student extends Person {

    // fields

    double gpa;

    //constructor
    public Student(String firstName, String lastName, int age, double gpa) {
        super(firstName, lastName, age); //call constructor of Person
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String getFullName() {
        return getLastName() + " " + getFirstName();
    }

}
