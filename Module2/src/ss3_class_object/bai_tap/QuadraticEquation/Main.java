package ss3_class_object.bai_tap.QuadraticEquation;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation qre = new QuadraticEquation(1,-5,4);
        if(qre.getDiscriminant()<0){
            System.out.print("Phương trình vô nghiệm");
        }else if (qre.getDiscriminant()>0){
            System.out.print("Nghiệm x1 = " + qre.getRoot1() + " Nghiệm x2 = " + qre.getRoot2());
        }else {
            System.out.print("x = " + qre.getRoot1());
        }
    }
}
