package com.techwaala.car_image_analysis;

import java.util.List;

public class CarCount {

    private List<CarColorCount> carColorCountList;
    private int totalCount;

    public List<CarColorCount> getCarColorCountList() {
        return carColorCountList;
    }

    public void setCarColorCountList(List<CarColorCount> carColorCountList) {
        this.carColorCountList = carColorCountList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
