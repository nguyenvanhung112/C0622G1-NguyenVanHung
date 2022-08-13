package service.impl;

import service.ITeacherService;

public class TeacherService implements ITeacherService {
    public void editStudentInfo() {
        Student studentEdit = this.findStudent();
        if (studentEdit == null) {
            System.out.println("Không tìm thấy học sinh muốn sửa thông tin");
        } else {
            while (true) {
                int positionEdit = students.indexOf(studentEdit);
                System.out.print("Bạn muốn thay đổi thông tin gì?\n" +
                        "1. Tên học sinh\n" +
                        "2. Id học sinh\n" +
                        "3. Ngày sinh học sinh\n" +
                        "4. Điểm học sinh\n" +
                        "5. Tên lớp học sinh\n" +
                        "6. Giới tính\n" +
                        "7. Kết thúc\n" +
                        "--> Xin mời nhập ở đây: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Bạn muốn sửa tên học sinh lại như thế nào");
                        String newName = scanner.nextLine();
                        students.get(positionEdit).setName(newName);
                        System.out.println("Đã sửa tên thành công");
                        break;
                    case 2:
                        System.out.println("Bạn muốn sửa id học sinh lại như thế nào");
                        int newId = Integer.parseInt(scanner.nextLine());
                        students.get(positionEdit).setId(newId);
                        System.out.println("Đã sửa id thành công");
                        break;
                    case 3:
                        System.out.println("Bạn muốn sửa ngày sinh học sinh lại như thế nào");
                        String newBirthday = scanner.nextLine();
                        students.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Đã sửa ngày sinh thành công");
                        break;
                    case 4:
                        System.out.println("Bạn muốn sửa điểm học sinh lại như thế nào");
                        double newPoint = Double.parseDouble(scanner.nextLine());
                        students.get(positionEdit).setPoint(newPoint);
                        System.out.println("Đã sửa điểm thành công");
                        break;
                    case 5:
                        System.out.println("Bạn muốn sửa tên lớp lại như thế nào");
                        String newClassname = scanner.nextLine();
                        students.get(positionEdit).setClassName(newClassname);
                        System.out.println("Đã sửa tên lớp thành công");
                        break;
                    case 6:
                        System.out.println("Bạn muốn sửa giới tính lại như thế nào");
                        String newGender = scanner.nextLine();
                        students.get(positionEdit).setGender(newGender);
                        System.out.println("Đã sửa giới tính thành công");
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Số nhập vào không hợp lệ");
                }
            }
        }
    }
    public void changeStudenInfo() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Học sinh bạn cần thay đổi thông tin không có trong lớp ");
        } else {
            System.out.println("Bạn chắc chắn muốn thay đổi thông tin của học sinh có ID là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.set((student.getId() - 1), this.infoStudent());
                System.out.println("Bạn đã thay đổi thông tin thành công");
            }
        }
    }
}
