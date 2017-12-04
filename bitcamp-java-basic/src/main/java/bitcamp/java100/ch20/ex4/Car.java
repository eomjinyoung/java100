package bitcamp.java100.ch20.ex4;

import java.util.Arrays;
import java.util.List;

public class Car {
    private String model;
    private String color;
    private int capacity;
    private Engine engine;
    private Tire[] tires;
    private List<Seat> seats;
    
    public Car() {
        System.out.println("Car()");
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", color=" + color + ", capacity=" + capacity + ", engine=" + engine + ", tires="
                + Arrays.toString(tires) + ", seats=" + seats + "]";
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
        System.out.println("setTires()");
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
        System.out.println("setModel()");
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
        System.out.println("setColor()");
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        System.out.println("setCapacity()");
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("setEngine()");
    }
    
    
}
