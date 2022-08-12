package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.MemberController;


public class MainView {
    public static void main(String[] args) {
        MemberController memberController = new MemberController();
        memberController.menuManagement();
    }
}
