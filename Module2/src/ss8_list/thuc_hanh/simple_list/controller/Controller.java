package ss8_list.thuc_hanh.simple_list.controller;

import ss8_list.thuc_hanh.simple_list.model.MyList;

public class Controller {

    public static void main(String[] args) {
        MyList<Integer> listInterger = new MyList<>();
        listInterger.add(1);
        listInterger.add(2);
        listInterger.add(3);
        listInterger.add(3);
        listInterger.add(4);
        System.out.println("element 4: " + listInterger.get(4));
        System.out.println("element 1: " + listInterger.get(1));
        System.out.println("element 2: " + listInterger.get(2));

        listInterger.get(-1);
        System.out.println("element -1: " + listInterger.get(-1));
    }
}
