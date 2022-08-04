package ss3_class_object.bai_tap.Fan;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    private boolean on = false;
    private int speed = 1;
    private String color = "blue";
    private double radius = 5;

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public boolean isOn() {
        return on;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    "fan is on" +
                    ", speed=" + speed +
                    ", color='" + color + '\'' +
                    ", radius=" + radius +
                    '}';
        } else {
            return "Fan{" +
                    "fan is off" +
                    ", speed=" + speed +
                    ", color='" + color + '\'' +
                    ", radius=" + radius +
                    '}';
        }
    }
}
