package bai_3.ra.presentation;

import bai_3.ra.entity.Categories;
import bai_3.ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private static final List<Categories> categoriesList = new ArrayList<>();
    private static final List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    int catalogChoice;
                    do {
                        System.out.println("********************CATEGORIES MENU***********");
                        System.out.println("1. Nhập thông tin các danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Cập nhật trạng thái danh mục");
                        System.out.println("6. Thoát");
                        catalogChoice = Integer.parseInt(sc.nextLine());
                        if(catalogChoice == 6){
                            System.out.println("Quay lại menu chính");
                            break;
                        }

                        switch (catalogChoice){
                            case 1:
                                addCatalog(sc);
                                break;
                            case 2:
                                showList();
                                break;
                            case 3:
                                editCatalog(sc,categoriesList);
                                break;
                            case 4:
                                break;
                            case 5:
                                changeCatalogStatus(sc, categoriesList);
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                        }
                    }while (true);
                    break;
                case 2:
                    do {
                        System.out.println("*******************PRODUCT MANAGEMENT*****************");
                        System.out.println("1. Nhập thông tin các sản phẩm");
                        System.out.println("2. Hiển thị thông tin các sản phẩm");
                        System.out.println("3. Sắp xếp các sản phẩm theo giá");
                        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
                        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
                        System.out.println("8. Thoát");
                        int productChoice = Integer.parseInt(sc.nextLine());
                        if (productChoice == 8){
                            System.out.println("Quay lại menu chính");
                            break;
                        }

                        switch (productChoice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                        }
                    }while (true);
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (true);
    }

    // thêm danh mục
    public static void addCatalog(Scanner scanner){
        Categories categories = new Categories();
        categories.inputData(scanner, categoriesList);
        categoriesList.add(categories);
        System.out.println("Thêm danh mục thành công");
    }

    // hiển thị danh mục
    public static void showList(){
        System.out.println("Danh sách danh mục:");
        for (Categories list : categoriesList){
            System.out.println(list.displayData());
        }
    }

    // chỉnh sửa danh mục
    public static void editCatalog(Scanner scanner, List<Categories> categoriesList){
        while (true){
            System.out.print("Nhập vào mã danh mục: ");
            int inputId = Integer.parseInt(scanner.nextLine());
            if(!catalogIdIsExisted(inputId)){
                System.out.println("Mã danh mục không tồn tại");
            }else{
                int foundIndex = findIndex(inputId, categoriesList);
                // thêm tên mới
                System.out.print("Nhập tên mới danh mục: ");
                String newName = scanner.nextLine();
                categoriesList.get(foundIndex).setCatalogName(newName);
                // thêm mô tả mới
                System.out.print("Nhập mô tả mới: ");
                String newDescription = scanner.nextLine();
                categoriesList.get(foundIndex).setDescriptions(newDescription);
                // thêm trạng thái mới
                System.out.print("Nhập trạng thái mới: ");
                boolean newStatus = categoriesList.get(foundIndex).catalogStatus(scanner);
                categoriesList.get(foundIndex).setCatalogStatus(newStatus);
                System.out.println("Đã cập nhật danh mục");
                break;
            }
        }


    }

    // đổi trạng thái danh mục
    public static void changeCatalogStatus(Scanner scanner, List<Categories> categoriesList){
        while (true){
            System.out.print("Nhập vào mã danh mục: ");
            int inputId = Integer.parseInt(scanner.nextLine());
            if (catalogIdIsExisted(inputId)){
                System.out.println("Mã danh mục không tồn tại");
            }else{
                int foundIndex = findIndex(inputId, categoriesList);
                boolean b = categoriesList.get(foundIndex).isCatalogStatus();
                categoriesList.get(foundIndex).setCatalogStatus(!b);
                System.out.println("Đã cập nhật trạng thái mới");
                break;
            }
        }

    }

    // check id có tồn tại hay không
    public static boolean catalogIdIsExisted(int id){
        for (Categories c : categoriesList){
            if(c.getCatalogId() == id){
                return true;
            }
        }
        return false;
    }

    // tìm index của đối tượng
    public static int findIndex(int id, List<Categories> categoriesList){
        for (int i = 0; i < categoriesList.size(); i++) {
            if(categoriesList.get(i).getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }
}
