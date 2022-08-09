package interface_resizeable.MainController;

import interface_resizeable.Model.Circle;
import interface_resizeable.Model.Rectangle;
import interface_resizeable.Model.Shape;
import interface_resizeable.Model.Square;


public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5,"green",false);
        shapes[1] = new Rectangle(4.5,5.5,"yellow",true);
        shapes[2] = new Square("black",true,4.5);
        double percent = 5;
        System.out.println("Trước khi thay đổi");
        System.out.println("Phần trăm= " + percent);
        for (Shape shape: shapes) {
            System.out.println(shape);
            System.out.println("Diện tích= " + shape.getArea());
            System.out.println("Chu vi= " + shape.getPerimeter());
        }
        System.out.println("Sau khi thay đổi");

        for (Shape shape : shapes) {
            shape.resize(percent);
            System.out.println(shape);
            System.out.println("Diện tích= " + shape.getArea());
            System.out.println("Chu vi= " + shape.getPerimeter());
        }
    }
}
