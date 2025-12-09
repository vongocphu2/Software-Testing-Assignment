package com.nhom2.testing;

public class NextDate {

    public static String run(int day, int month, int year) {
        // Kiem tra mien gia tri (DA SUA: Cho phep den nam 2030)
        if (day < 1 || day > 31) return "Ngay khong hop le";
        if (month < 1 || month > 12) return "Thang khong hop le";
        if (year < 1812 || year > 2030) return "Nam khong hop le"; 

        // Xac dinh so ngay trong thang
        int daysInMonth;
        switch (month) {
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                daysInMonth = isLeap ? 29 : 28;
                break;
            default:
                daysInMonth = 31;
        }

        // Kiem tra ngay hop le so voi thang
        if (day > daysInMonth) {
            return "Ngay khong hop le";
        }

        // Tinh toan ngay ke tiep
        if (day < daysInMonth) {
            return (day + 1) + "/" + month + "/" + year;
        } else { // Truong hop cuoi thang
            if (month == 12) {
                return "1/1/" + (year + 1);
            } else {
                return "1/" + (month + 1) + "/" + year;
            }
        }
    }
}