package ss6_abstract_class_interface.bai_tap.interface_colorable.MainController;

import ss6_abstract_class_interface.bai_tap.interface_colorable.Model.Circle;
import ss6_abstract_class_interface.bai_tap.interface_colorable.Model.Rectangle;
import ss6_abstract_class_interface.bai_tap.interface_colorable.Model.Shape;
import ss6_abstract_class_interface.bai_tap.interface_colorable.Model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5, "yellow", true);
        shapes[1] = new Rectangle(4.7, 4.6, "white", true);
        shapes[2] = new Square("black", true, 5.5);
        for (Shape shape : shapes
        ) {
            System.out.println(shape);
            System.out.println("Diện tích= " + shape.getArea());
            System.out.println("Chu vi= " + shape.getPerimeter());
            shape.howToColor();
            System.out.println("Ok");

        }
    }
}
