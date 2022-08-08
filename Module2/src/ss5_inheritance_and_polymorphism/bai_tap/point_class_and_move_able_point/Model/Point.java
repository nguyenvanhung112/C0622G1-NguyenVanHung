package ss5_inheritance_and_polymorphism.bai_tap.point_class_and_move_able_point.Model;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] array = {x, y};
        return array;
    }

    @Override
    public String toString() {
        return "Point{" +
                Arrays.toString(getXY()) +
                '}';
    }
}
