package dunkirk.reservation.domain;

import java.sql.*;

import org.apache.commons.lang3.builder.*;

public class Product {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private Timestamp salesStart;
    private Timestamp salesEnd;
    private SalesFlag salesFlag;
    private String event;
    private Timestamp createDate;
    private Timestamp modifyDate;


    public Product() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Timestamp getSalesStart() {
        return salesStart;
    }

    public void setSalesStart(Timestamp salesStart) {
        this.salesStart = salesStart;
    }

    public Timestamp getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(Timestamp salesEnd) {
        this.salesEnd = salesEnd;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
