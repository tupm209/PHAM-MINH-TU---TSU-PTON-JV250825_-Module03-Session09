package bai_3.ra.entity;

import bai_3.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public void inputData(Scanner scanner, List<Categories> arrCategories){
        this.catalogId = arrCategories.size() + 1;
        this.catalogName = inputCatalogName(scanner, arrCategories);

        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Nhập trạng thái danh mục (true - hoạt động / false - không hoạt động):");
        this.catalogStatus = catalogStatus(scanner);
    }

    private String inputCatalogName(Scanner scanner, List<Categories> arrCategories){
        String catalogNameRegex = "^[a-zA-Z\\s]{1,50}$";
        while (true){
            System.out.print("Nhập tên danh mục: ");
            String name = scanner.nextLine().trim();

            if(!name.matches(catalogNameRegex)){
                System.out.println("Tên không phù hợp");
                continue;
            }

            if(catalogNameIsExisted(arrCategories, name)){
                System.out.println("Tên danh mục đã tồn tại");
                continue;
            }

            return name;
        }
    }

    private boolean catalogNameIsExisted(List<Categories> arrCategories, String name){
        for (Categories list : arrCategories){
            if(list.getCatalogName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public boolean catalogStatus(Scanner scanner){
        while (true){
            String status = scanner.nextLine().trim().toLowerCase();
            if(status.equals("true") || status.equals("false")){
                return Boolean.parseBoolean(status);
            }
            System.out.println("Chỉ nhập được true hoặc false");
        }
    }

    @Override
    public String displayData() {
        return String.format("Mã danh mục: %d | Tên danh mục: %s | Mô tả danh mục: %s | Trạng thái danh mục: %s",
                catalogId, catalogName, descriptions, catalogStatus ? "Hoạt động" : "Không hoạt động");
    }

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
