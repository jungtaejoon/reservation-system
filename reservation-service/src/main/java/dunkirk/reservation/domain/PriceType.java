package dunkirk.reservation.domain;

public enum PriceType {
    NONE, DEFAULT("일반"), YOUTH("청소년"), CHILD("어린이");

    private String name;

    PriceType() {
    }

    PriceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
