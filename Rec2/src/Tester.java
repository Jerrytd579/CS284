public class Tester {

    public static void main(String[] args) {
        Animal dog = new Dog(2, 15, "Rusty");

        System.out.println("Name : " + dog.getName());

        PetOwner<Animal> petOwner = new PetOwner<Animal>("Roger", dog);

    }
}
