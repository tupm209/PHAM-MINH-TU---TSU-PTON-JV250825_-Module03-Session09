package bai_3.ra.entity;

import bai_3.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public void inputData(Scanner scanner, List<Product> arrProduct, int indexProduct, List<Categories> arrCategories, int indexCatalog){

    }

    @Override
    public String displayData() {
        return String.format
                ("Mã SP: %s | Tên: %s | Giá: %.1f | Mô tả: %s | Mã danh mục: %d | Trạng thái: %s",
                productId, productName, price, description, catalogId, getProductStatusText());
    }

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public String getProductStatusText(){
        return switch (this.productStatus) {
            case 1 -> "Hết hàng";
            case 2 -> "Không bán";
            case 0 -> "Đang bán";
            default -> "";
        };
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}
