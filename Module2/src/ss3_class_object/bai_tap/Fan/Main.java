package ss3_class_object.bai_tap.Fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan1.setRadius(10);
        System.out.print(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setSpeed(3);
        fan2.setRadius(10);
        fan2.setColor("yellow");
        System.out.print(fan2.toString());
    }
}
