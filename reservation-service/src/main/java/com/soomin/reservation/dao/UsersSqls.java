package com.soomin.reservation.dao;

public class UsersSqls {
	final static String CHECK_USER = "SELECT COUNT(*) FROM USERS WHERE sns_id=:sns_id";
	final static String UPDATE_USER = "UPDATE USERS SET username=:name, email=:email, nickname=:nickname WHERE sns_id=:sns_id";
}
