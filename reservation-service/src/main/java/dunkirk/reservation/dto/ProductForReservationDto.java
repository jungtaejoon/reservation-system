package dunkirk.reservation.dto;

import java.sql.Timestamp;
import java.util.List;

import dunkirk.reservation.domain.ProductPrice;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProductForReservationDto {
    private int id;
    private String name;
    private int fileId;
    private String observationTime;
    private Timestamp displayStart;
    private Timestamp displayEnd;
    private String placeStreet;
    private String placeLot;
    private List<ProductPrice> productPrices;

    public ProductForReservationDto() {
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
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

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
