package case_study.model.person;

public class Customer extends Person {
    private String customerCode;
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String customerCode, String typeCustomer, String address) {
        this.customerCode = customerCode;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(String name, String dateOfBirth, String gender, int idCard, int phone, String email, String customerCode, String typeCustomer, String address) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.customerCode = customerCode;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getDateOfBirth(), this.getGender(), this.getIdCard(),
                this.getPhone(), this.getEmail(), this.getCustomerCode(), this.getTypeCustomer(), this.getAddress());
    }
}
