package com.example.lab2bai4;

public class Employee {
    protected String maNV;
    protected String tenNV;
    protected boolean isManager;

    public Employee(String maNV, String tenNV, boolean isManager) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.isManager = isManager;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getFullName() {
        return tenNV;
    }

    public boolean isManager() {
        return isManager;
    }

    // Phương thức toString để ghi đè ở các lớp con
    public String toString() {
        return maNV + " - " + tenNV;
    }
}
