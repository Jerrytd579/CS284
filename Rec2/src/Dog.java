public class Dog implements Animal{

    private int height, weight;
    private String name;

    public Dog(int height, int weight, String name) {
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void makeNoise() {
        // Anything
    }
}
