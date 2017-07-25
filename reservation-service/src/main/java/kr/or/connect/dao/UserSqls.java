package kr.or.connect.dao;

public class UserSqls {
    final static String SELECT_BY_EMAIL = "SELECT * FROM users WHERE email = :email";
    final static String UPDATE_BY_NAVER_USER = "UPDATE users SET nickname = :nickname, sns_profile = :snsProfile, modify_date = :modifyDate WHERE email = :email";
}
