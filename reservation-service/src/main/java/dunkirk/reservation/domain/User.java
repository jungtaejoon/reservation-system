package dunkirk.reservation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.*;

public class User {
    public static final String SAME = "Same";
    public static final String NEED_UPDATE = "Need Update";

    private Long id;
    private String username;
    private String email;
    private String tel;
    private String nickname;
    private String snsId;
    private String snsType;
    private String snsProfile;
    private int adminFlag;
    private Date createDate;
    private Date modifyDate;

    public User() {
        super();
    }

    public User(String username) {
        super();
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSnsId() {
        return snsId;
    }

    public void setSnsId(String snsId) {
        this.snsId = snsId;
    }

    public String getSnsType() {
        return snsType;
    }

    public void setSnsType(String snsType) {
        this.snsType = snsType;
    }

    public String getSnsProfile() {
        return snsProfile;
    }

    public void setSnsProfile(String snsProfile) {
        this.snsProfile = snsProfile;
    }

    public int getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(int adminFlag) {
        this.adminFlag = adminFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public String checkNaverUser(NaverLoginUser naverUser) {
        String checkResult = SAME;
        if (naverUser.getNickname() != null) {
            if (!naverUser.getNickname().equals(this.getNickname())) checkResult = NEED_UPDATE;
        } else {
            if (this.getNickname() != null) checkResult = NEED_UPDATE;
        }
        if (naverUser.getProfile_image() != null) {
            if (!naverUser.getProfile_image().equals(this.getSnsProfile())) checkResult = NEED_UPDATE;
        } else {
            if (this.getSnsProfile() != null) checkResult = NEED_UPDATE;
        }
        return checkResult;
    }

}
