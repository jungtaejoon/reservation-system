package dunkirk.reservation.domain;

public enum ReservationType {
    REQUESTING("예약 중"), DUE("예약 확정"), USED("사용 완료"), REFUND_CANCEL("취소 환불");

    private String name;

    ReservationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
