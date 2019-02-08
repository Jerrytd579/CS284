public class PetOwner<T> extends Person {

    private T an;

    public PetOwner(String name, T an) {
        super(name);
        this.an = an;
    }

    public T getAnimal() {
        return an;
    }
}
