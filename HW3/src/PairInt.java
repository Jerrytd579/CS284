public class PairInt {

    private int x;
    private int y;


    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    public boolean equals(Object p) {
        PairInt obj = (PairInt) p;
        return x == obj.getX() && y == obj.getY();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        result.append(x);
        result.append(", ");
        result.append(y);
        result.append(")");
        return result.toString();
    }

    public PairInt copy() {
        return new PairInt(this.x, this.y);
    }
}
