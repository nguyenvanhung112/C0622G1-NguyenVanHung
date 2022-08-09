package ss6_abstract_class_interface.thuc_hanh.animal_interface.Model;

public class Tiger extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Tiger: roar";
    }


    @Override
    public String howToEat() {
        return "ực ực";
    }
}
