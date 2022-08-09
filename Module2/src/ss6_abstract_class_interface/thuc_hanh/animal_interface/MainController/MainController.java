package ss6_abstract_class_interface.thuc_hanh.animal_interface.MainController;

import ss6_abstract_class_interface.thuc_hanh.animal_interface.Model.*;


public class MainController {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
            if (animal instanceof Tiger) {
                Edible edibler1 = (Tiger) animal;
                System.out.println(edibler1.howToEat());
            }
        }
        Fruit apple = new Apple();
        System.out.println(apple.howToEat());
    }
}
