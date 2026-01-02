package ra_bai_2.entity;

import java.util.Scanner;

public abstract class Pet {
    private String id;
    private String name;
    private int age;

    public Pet() {
    }

    public Pet(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet inputData(Scanner scanner){
        // validate mã thú cưng
        String regexId = "^[CD]\\d{3}$";
        do {
            System.out.println("Quy định mã thú cưng:");
            System.out.println("- Gồm 4 ký tự");
            System.out.println("- Bắt đầu bằng ký tự C hoặc D");
            System.out.println("- 3 ký tự sau là số");
            System.out.println("- Không được trùng lặp");
            System.out.print("Nhập mã thú cưng: ");
            String inputId = scanner.nextLine();
            if(inputId.matches(regexId)){
                this.id = inputId;
                break;
            }else{
                System.out.println("Mã không hợp lệ");
            }
        }while(true);

        // validate tên thú cưng
        String regexName = "^[a-zA-Z\\s]{20,50}$";
        do {
            System.out.println("Quy định tên thú cưng: ");
            System.out.println("- Chuỗi từ 20 - 50 ký tự");
            System.out.print("Nhập tên thú cưng: ");
            String inputName = scanner.nextLine();
            if(inputName.matches(regexName)){
                this.name = inputName;
                break;
            }else{
                System.out.println("Tên không hợp lệ");
            }
        }while (true);

        //validate tuổi thú cưng
        do {
            System.out.print("Nhập tuổi thú cưng: ");
            int inputAge = Integer.parseInt(scanner.nextLine());
            if(inputAge > 0){
                this.age = inputAge;
                break;
            }else{
                System.out.println("Tuổi không hợp lệ");
            }
        }while (true);
        return null;
    }

    public String displayData(){
        return String.format("Mã thú cưng: %s | Tên: %s | Tuổi: %d", id, name, age);
    }

    public void speak(){}
}
