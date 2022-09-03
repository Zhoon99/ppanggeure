package inha.capstone.ppanggeure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreadDto {

    private String breadName;

    private String address;

    private String detailAddress;

    private Long editorId;

    private Float scope;

    private String editorEval;

    private String phone;

    private String priceRange;

    private String openingHours;

    private String breakTime;

    private String lastOrder;

    private String lat;

    private String lng;
}
