package ss4_access_modifier.thuc_hanh;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Car(String name, String engine){
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
    void display() {
        System.out.println(this.name + " " + this.engine);
    }
    public static class TestStaticProperty{
        public static void main(String[] args) {
            Car car1 = new Car("Mazda 3","Skyactiv 3");
            System.out.println(String.valueOf(Car.numberOfCars));
            car1.display();
            Car car2 = new Car("GLC","Mec");
            System.out.println(String.valueOf(Car.numberOfCars));
            car2.display();
        }
    }
}