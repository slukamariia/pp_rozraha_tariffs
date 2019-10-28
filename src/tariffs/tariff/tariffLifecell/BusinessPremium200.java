package tariffs.tariff.tariffLifecell;

public class BusinessPremium200 extends Lifecell {
    public BusinessPremium200() {
        this.name = "Business Premium 200";
        this.price = 200;
        this.internet = 30000;
        this.call = 1;
        this.sms = 1000;
        this.callAnother = 2000;
    }
}