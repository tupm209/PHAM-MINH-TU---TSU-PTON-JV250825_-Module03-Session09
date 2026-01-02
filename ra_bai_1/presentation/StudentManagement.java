package ra_bai_1.presentation;

import ra_bai_1.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];
        int count = 0;
        int choice, id;

        do {
            System.out.println("*************** QUẢN LÝ SINH VIÊN ***************\n\n");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.println("Chọn chức năng từ 1 - 6");
            choice = Integer.parseInt(sc.nextLine());
            boolean flag;

            switch (choice){
                case 1:
                    if(count == 0){
                        System.out.println("Không có dữ liệu sinh viên");
                    }else{
                        for (int i = 0 ; i < count ; i++){
                            System.out.println(students[i].displayData());
                        }
                    }
                    break;
                case 2:
                    if(count < students.length){
                        do {
                            flag = false;
                            System.out.print("Nhập mã SV: ");
                            id = Integer.parseInt(sc.nextLine());
                            for (int i = 0; i < count ; i++) {
                                if(id == students[i].getId()){
                                    System.out.println("Mã SV đã tồn tại. Hãy nhập mã mới");
                                    flag = true;
                                    break;
                                }
                            }
                        }while (flag);
                        students[count] = new Student();
                        students[count].setId(id);
                        students[count].inputData(sc);
                        count++;
                        System.out.println("Thêm sinh viên thành công");
                    }else{
                        System.out.println("Danh sách sinh viên đã đầy");
                    }
                    break;
                case 3:
                    flag = false;
                    System.out.print("Hãy nhập mã SV muốn cập nhật: ");
                    id = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < count; i++) {
                        if(id == students[i].getId()){
                            System.out.print("Nhập tên mới cho SV: ");
                            String name = sc.nextLine();
                            students[i].setName(name);
                            System.out.print("Nhập tuổi mới cho SV: ");
                            int age = Integer.parseInt(sc.nextLine());
                            students[i].setAge(age);
                            System.out.print("Nhập chuyên ngành mới cho SV: ");
                            String major = sc.nextLine();
                            students[i].setMajor(major);
                            System.out.println("Đã cập nhật thành công");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag){
                        System.out.println("Mã SV không tồn tại");
                    }
                    break;
                case 4:
                    int findIndex = -1;
                    System.out.print("Hãy nhập mã SV muốn xóa: ");
                    id = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < count; i++) {
                        if(id == students[i].getId()){
                            findIndex = i;
                            break;
                        }
                    }

                    // xóa vị trí có mã sv nhập vào
                    if (findIndex != -1){
                        for (int i = findIndex; i < count - 1; i++){
                            students[i] = students[i + 1];
                        }
                        students[count - 1] = null;
                        count--;
                        System.out.println("Đã xóa sinh viên có mã SV là: " + id);
                    }else{
                        System.out.println("Mã SV không tồn tại");
                    }
                    break;
                case 5:
                    flag = false;
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String findByName = sc.nextLine().trim().toLowerCase();
                    for (int i = 0; i < count; i++) {
                        if(students[i].getName().trim().toLowerCase().equals(findByName)){
                            System.out.println(students[i].displayData());
                            System.out.println("Thông tin sinh viên cần tìm đã được in ra");
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        System.out.println("Sinh viên không tồn tại");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("Hãy nhập lựa chọn từ 1 - 6");
            }
        }while (true);
    }
}
