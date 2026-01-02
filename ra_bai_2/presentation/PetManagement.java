package ra_bai_2.presentation;

import ra_bai_2.entity.Cat;
import ra_bai_2.entity.Dog;
import ra_bai_2.entity.Pet;

import java.util.Scanner;

public class PetManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pet[] pets = new Pet[5];
        int count = 0;
        String id;
        boolean flag;
        int choice;

        do {
            System.out.println("*********************QUẢN LÝ THÚ CƯNG******************** \n");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    if(count == 0){
                        System.out.println("Không có dữ liệu thú cưng");
                    }else{
                        System.out.println("Danh sách thú cưng:");
                        for (int i = 0; i < count; i++) {
                            System.out.println(pets[i].displayData());
                        }
                    }
                    break;
                case 2:
                    if(count > pets.length){
                        System.out.println("Danh sách đầy");
                    }

                    System.out.println("Hãy chọn loại thú cưng bạn muốn thêm");
                    System.out.println("1. Chó");
                    System.out.println("2. Mèo");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    choice = Integer.parseInt(sc.nextLine());

                    switch (choice){
                        case 1:
                            System.out.println("Đây là một chú chó\n");
                            pets[count] = new Dog();
                            pets[count].inputData(sc);
                            System.out.println("Thú cưng đã được thêm thành công");
                            count++;
                            break;
                        case 2:
                            System.out.println("Đây là một chú mèo\n");
                            pets[count] = new Cat();
                            pets[count].inputData(sc);
                            System.out.println("Thú cưng đã được thêm thành công");
                            count++;
                            break;
                        default:
                            System.err.println("Hãy nhập lựa chọn 1 hoặc 2");
                    }
                    break;
                case 3:
                    flag = false;
                    System.out.print("Nhập mã thú cưng muốn nghe tiếng kêu: ");
                    id = sc.nextLine();
                    for (int i = 0; i < count; i++) {
                        if(pets[i].getId().equals(id)){
                            pets[i].speak();
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        System.out.println("Không tìm thấy thú cưng");
                    }
                    break;
                case 4:
                    int findIndex = -1;
                    System.out.print("Nhập mã thú cưng muốn xóa: ");
                    id = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if(pets[i].getId().equals(id)){
                            findIndex = i;
                            break;
                        }
                    }

                    if(findIndex != -1){
                        for (int i = findIndex; i < count - 1; i++) {
                            pets[i] = pets[i + 1];
                        }
                        pets[count - 1] = null;
                        count--;
                        System.out.println("Đã xóa thú cưng mã số: " + id);
                    }else{
                        System.out.println("Không tìm thấy thú cưng");
                    }
                    break;
                case 5:
                    flag = false;
                    System.out.print("Nhập tên thú cưng muốn tìm: ");
                    String name = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if(pets[i].getName().equals(name)){
                            System.out.println("Thông tin thú cưng muốn tìm:");
                            System.out.println(pets[i].displayData());
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        System.out.println("Không tìm thấy thú cưng");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("Nhập lựa chọn từ 1 - 6");
            }
        }while (true);
    }
}
