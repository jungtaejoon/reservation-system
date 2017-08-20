package dunkirk.reservation.sql;

public class UserSqls {
    public final static String SELECT_BY_EMAIL = "SELECT * FROM users WHERE email = :email";
    public final static String UPDATE_BY_NAVER_USER = "UPDATE users SET nickname = :nickname, sns_profile = :snsProfile, modify_date = :modifyDate WHERE email = :email";
}
