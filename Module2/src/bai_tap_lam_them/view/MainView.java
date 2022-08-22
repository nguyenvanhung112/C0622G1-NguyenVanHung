package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.MemberController;

import java.io.IOException;


public class MainView {
    public static void main(String[] args) throws IOException {
        MemberController memberController = new MemberController();
        memberController.menuManagement();
    }
}
