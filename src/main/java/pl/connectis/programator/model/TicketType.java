package pl.connectis.programator.model;

public enum TicketType {

    STUDENT("Studencki",0.50),
    SENIOR("Senior",0.65),
    PUPIL("Szkolny",0.55),
    NORMAL("Normlany",1.00);

    private String type;
    private double discount;

    TicketType() {
    }

    TicketType(String type) {
        this.type = type;
    }

    TicketType(String type, double discount) {
        this.type = type;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "type='" + type + '\'' +
                ", discount=" + discount +
                '}';
    }
}
