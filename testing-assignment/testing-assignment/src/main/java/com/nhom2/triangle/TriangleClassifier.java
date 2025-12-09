package com.nhom2.triangle;

public class TriangleClassifier {
 // ... (Noi dung ham classify) ...
 public String classify(int a, int b, int c) {
     // Kiem tra du lieu dau vao (Canh phai duong)
     if (a <= 0 || b <= 0 || c <= 0) {
         return "Khong_phai_Tam_giac_Sai_du_lieu";
     }

     // Kiem tra dieu kien bat dang thuc tam giac
     if (a + b <= c || a + c <= b || b + c <= a) {
         return "Khong_phai_Tam_giac";
     }

     // Kiem tra loai tam giac
     if (a == b && b == c) {
         return "Deu";
     } else if (a == b || b == c || a == c) {
         return "Can";
     } else {
         return "Thuong";
     }
 }
}
