package dunkirk.reservation.domain;

public enum ReservationType {
    REQUESTING("예약중"), DUE("예약확정"), USED("이용완료"), REFUND_CANCEL("취소환불");

    private String name;

    ReservationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
