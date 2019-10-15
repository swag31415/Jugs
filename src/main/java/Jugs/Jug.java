package Jugs;

public class Jug {

    private String name;

    private int water;
    private int capacity;

    public Jug(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String fill() {
        this.water = this.capacity;
        return "Fill " + this.name;
    }

    public String empty() {
        this.water = 0;
        return "Empty " + this.name;
    }

    public String pour_into(Jug other) {
        if (other.getSpace() > this.water) {
            other.addWater(this.water);
            this.empty();
        } else { 
            this.water -= other.getSpace();
            other.fill();
        }
        return "Pour " + this.name + " into " + other.getName();
    }

    private void addWater(int water) {
        if (water < 0) {
            throw new Error("Encountered negative water");
        }
        int temp = this.water + water;
        this.water = (temp > this.capacity) ? this.capacity : temp;
    }

    public String getName() {
        return this.name;
    }

    public int getWater() {
        return this.water;
    }

    public int getSpace() {
        return this.capacity - this.water;
    }
}