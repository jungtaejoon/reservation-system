package kr.or.connect.reservation.domain;

import lombok.*;

/**
 * Created by ODOL on 2017. 7. 19..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DisplayInfo {
    private Long id;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
}
