package com.boxcf.constands;

public enum BoxState {
    booked("Đặt trước"),
    active("Đang sử dụng"),
    empty("Trống"),
    waiting("Chờ"),
    used("Đã trả"),;
    
    private String state;

    private BoxState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
