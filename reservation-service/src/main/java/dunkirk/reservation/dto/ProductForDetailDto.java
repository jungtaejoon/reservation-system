package dunkirk.reservation.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import dunkirk.reservation.domain.SalesFlag;

public class ProductForDetailDto {
    private int id;
    private String name;
    private String description;
    private SalesFlag salesFlag;
    private String event;
    private String content;
    private String observationTime;
    private Timestamp displayStart;
    private Timestamp displayEnd;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private float avgScore;
    private int reviewCount;
    private List<Integer> bannerImageIdList;
    private List<CommentForDetailDto> comments;
    private List<Integer> noticeImageIdList;
    private int descriptionImageId;

    public ProductForDetailDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SalesFlag getSalesFlag() {
        return salesFlag;
    }

    public void setSalesFlag(SalesFlag salesFlag) {
        this.salesFlag = salesFlag;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public Timestamp getDisplayStart() {
        return displayStart;
    }

    public void setDisplayStart(Timestamp displayStart) {
        this.displayStart = displayStart;
    }

    public Timestamp getDisplayEnd() {
        return displayEnd;
    }

    public void setDisplayEnd(Timestamp displayEnd) {
        this.displayEnd = displayEnd;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<Integer> getBannerImageIdList() {
        return bannerImageIdList;
    }

    public void setBannerImageIdList(List<Integer> bannerImageIdList) {
        this.bannerImageIdList = bannerImageIdList;
    }

    public List<CommentForDetailDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentForDetailDto> comments) {
        this.comments = comments;
    }

    public List<Integer> getNoticeImageIdList() {
        return noticeImageIdList;
    }

    public void setNoticeImageIdList(List<Integer> noticeImageIdList) {
        this.noticeImageIdList = noticeImageIdList;
    }

    public int getDescriptionImageId() {
        return descriptionImageId;
    }

    public void setDescriptionImageId(int descriptionImageId) {
        this.descriptionImageId = descriptionImageId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
