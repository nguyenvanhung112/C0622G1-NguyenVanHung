package ss5_inheritance_and_polymorphism.bai_tap.point_class_and_move_able_point.MainController;

import ss5_inheritance_and_polymorphism.bai_tap.point_class_and_move_able_point.Model.MoveablePoint;


public class MainController {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(2, 4, 3, 4);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
