package com.restapitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DefaultOption {

    private Integer optionId;

    private Integer productId;

    private String sellingPrice;

    private String compareType;

    private String comparePrice;

    private String savings;

    private Integer savingsPercent;

    private String basePrice;

    private String cost;

    private Boolean discountApplied;

    private Boolean onSale;

    private Object siteSaleId;

    private Object siteSaleStartDate;

    private Object siteSaleEndDate;

    private Object discountDetails;

    private String pricingResponseEnum;

    private Object msrp;

    private String wasPrice;

    private Object compareAt;

    private Object mapPrice;

}

