package case_study.model;

public class Contract {
    String contractNumber;
    String bookingCode;
    double moneyFirst;
    double totalMoney;
    String customerCode;

    public Contract() {
    }

    public Contract(String contractNumber, String bookingCode, double moneyFirst, double totalMoney, String customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.moneyFirst = moneyFirst;
        this.totalMoney = totalMoney;
        this.customerCode = customerCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getMoneyFirst() {
        return moneyFirst;
    }

    public void setMoneyFirst(double moneyFirst) {
        this.moneyFirst = moneyFirst;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.getContractNumber(), this.getBookingCode(),
                this.getMoneyFirst(), this.getTotalMoney(), this.getCustomerCode());
//        return "Contract{" +
//                "contractNumber='" + contractNumber + '\'' +
//                ", bookingCode='" + bookingCode + '\'' +
//                ", moneyFirst=" + moneyFirst +
//                ", totalMoney=" + totalMoney +
//                ", customerCode='" + customerCode + '\'' +
//                '}';
    }
}
