/**
 * @author jcheng15
 */

public class Person {
    // Fields, properties
    private String firstName;
    private String lastName;
    private int age;

    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName; // this = class fields, itself
        this.lastName = lastName;
        this.age = age;
    }

    // Methods - getters, setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + lastName; // Firstname, lastname
    }
}
