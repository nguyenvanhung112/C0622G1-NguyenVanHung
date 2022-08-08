package ss5_inheritance_and_polymorphism.bai_tap.circle_class_and_cylinder_class.MainController;

import ss5_inheritance_and_polymorphism.bai_tap.circle_class_and_cylinder_class.Model.Circle;
import ss5_inheritance_and_polymorphism.bai_tap.circle_class_and_cylinder_class.Model.Cylinder;

public class MainController {
    public static void main(String[] args) {
        Circle circle = new Circle(3.4, "red");
        System.out.println(circle);
        Cylinder cylinder = new Cylinder(4.5, "blue", 5.4);
        System.out.println(cylinder);
    }
}
