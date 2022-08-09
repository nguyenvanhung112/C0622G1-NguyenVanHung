package ss6_abstract_class_interface.thuc_hanh.animal_interface.Model;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
