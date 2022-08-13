package bai_tap_lam_them_2.model;


public class Product {
    private String code;
    private String productName;
    private String national;

    public Product() {
    }

    public Product(String code, String productName, String national) {
        this.code = code;
        this.productName = productName;
        this.national = national;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", productName='" + productName + '\'' +
                ", national='" + national + '\'' +
                '}';
    }
}
