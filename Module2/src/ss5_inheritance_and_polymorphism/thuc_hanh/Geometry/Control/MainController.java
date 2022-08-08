package ss5_inheritance_and_polymorphism.thuc_hanh.Geometry.Control;

import ss5_inheritance_and_polymorphism.thuc_hanh.Geometry.Model.Circle;
import ss5_inheritance_and_polymorphism.thuc_hanh.Geometry.Model.Rectangle;
import ss5_inheritance_and_polymorphism.thuc_hanh.Geometry.Model.Shape;
import ss5_inheritance_and_polymorphism.thuc_hanh.Geometry.Model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5);
        System.out.println(circle);
        circle = new Circle("indigo", false, 3.5);
        System.out.println(circle);
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(2.3,5.8);
        System.out.println(rectangle);
        rectangle = new Rectangle("orange",true,2.3,5.8);
        System.out.println(rectangle);
        Square square = new Square();
        System.out.println(square);
        square = new Square(2.3);
        System.out.println(square);
        square = new Square("yellow",true,5.8);
        System.out.println(square);
    }
}
