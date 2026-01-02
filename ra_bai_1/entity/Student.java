package ra_bai_1.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private String major;

    public Student(int id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputData(Scanner scanner){
        System.out.print("Nhập tên SV: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập tuổi sv: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }

    public String displayData(){
        return String.format("Mã SV: %d | Tên SV: %s | Tuổi SV: %d | Chuyên Ngành: %s", id, name, age, major);
    }
}
