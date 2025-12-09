package com.nhom2.triangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassifierTest {
    
    // Khởi tạo đối tượng cần kiểm thử
    TriangleClassifier classifier = new TriangleClassifier();

    // =======================================================================
    // A. PHÂN VÙNG TƯƠNG ĐƯƠNG (Equivalence Partitioning - EP) - 5 Tests
    // =======================================================================

    // EP A1: Vùng Hợp lệ (Tam giác Đều)
    @Test
    void testA01_Equilateral_EP() {
        // NOTE: EP - Đại diện vùng Tam giác Đều
        assertEquals("Deu", classifier.classify(10, 10, 10));
    }

    // EP A2: Vùng Hợp lệ (Tam giác Cân)
    @Test
    void testA02_Isosceles_EP() {
        // NOTE: EP - Đại diện vùng Tam giác Cân
        assertEquals("Can", classifier.classify(15, 15, 12));
    }

    // EP A3: Vùng Hợp lệ (Tam giác Thường)
    @Test
    void testA03_Scalene_EP() {
        // NOTE: EP - Đại diện vùng Tam giác Thường
        assertEquals("Thuong", classifier.classify(7, 8, 9));
    }

    // EP A4: Vùng Không Hợp lệ (Cạnh không dương)
    @Test
    void testA04_NotTriangle_Negative_EP() {
        // NOTE: EP - Đại diện vùng K.Hợp lệ (Cạnh Âm)
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(-1, 5, 5));
    }

    // EP A5: Vùng Không Hợp lệ (Bất đẳng thức)
    @Test
    void testA05_NotTriangle_Inequality_EP() {
        // NOTE: EP - Đại diện vùng K.Hợp lệ (1+2 < 5)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(1, 2, 5));
    }

    // =======================================================================
    // B. PHÂN TÍCH GIÁ TRỊ BIÊN (Boundary Value Analysis - BVA) - 15 Tests
    // =======================================================================

    // BVA B1: Biên dưới (Min - 1) - Cạnh bằng 0
    @Test
    void testB01_NotTriangle_BVA_Zero_a() {
        // NOTE: BVA - Biên a=0
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(0, 10, 10));
    }
    
    @Test
    void testB02_NotTriangle_BVA_Zero_b() {
        // NOTE: BVA - Biên b=0
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(10, 0, 10));
    }
    
    @Test
    void testB03_NotTriangle_BVA_Zero_c() {
        // NOTE: BVA - Biên c=0
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(10, 10, 0));
    }
    
    // BVA B4: Biên dưới (Min) - Cạnh bằng 1 (Tam giác Đều)
    @Test
    void testB04_Equilateral_BVA_Min() {
        // NOTE: BVA - Biên (1, 1, 1)
        assertEquals("Deu", classifier.classify(1, 1, 1));
    }
    
    // BVA B5-B7: Biên Bất đẳng thức (a+b = c)
    @Test
    void testB05_NotTriangle_BVA_aPlusbEqualsC() {
        // NOTE: BVA - Biên a+b = c (3+4=7)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(3, 4, 7));
    }
    
    @Test
    void testB06_NotTriangle_BVA_aPluscEqualsB() {
        // NOTE: BVA - Biên a+c = b (4+3=7)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(4, 7, 3));
    }
    
    @Test
    void testB07_NotTriangle_BVA_bPluscEqualsA() {
        // NOTE: BVA - Biên b+c = a (7+3=10)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(10, 7, 3));
    }
    
    // BVA B8-B10: Gần biên trên (Giả sử Max = 100)
    @Test
    void testB08_Equilateral_BVA_NearMax() {
        // NOTE: BVA - Gần Biên trên (99, 99, 99)
        assertEquals("Deu", classifier.classify(99, 99, 99));
    }
    
    @Test
    void testB09_Isosceles_BVA_NearMax() {
        // NOTE: BVA - Gần Biên trên (99, 99, 98)
        assertEquals("Can", classifier.classify(99, 99, 98));
    }
    
    @Test
    void testB10_Scalene_BVA_NearMax() {
        // NOTE: BVA - Gần Biên trên (97, 98, 99)
        assertEquals("Thuong", classifier.classify(97, 98, 99));
    }

    // BVA B11-B13: Bất đẳng thức (Ngay ngoài biên) - a+b < c
    @Test
    void testB11_NotTriangle_BVA_aPlusbLessC() {
        // NOTE: BVA - Ngay ngoài Biên (3+4 < 8)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(3, 4, 8));
    }

    @Test
    void testB12_NotTriangle_BVA_aPluscLessB() {
        // NOTE: BVA - Ngay ngoài Biên (4+3 < 8)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(4, 8, 3));
    }

    @Test
    void testB13_NotTriangle_BVA_bPluscLessA() {
        // NOTE: BVA - Ngay ngoài Biên (8, 4, 3)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(8, 4, 3));
    }
    
    // BVA B14-B15: Cạnh âm (Ngay ngoài biên dưới)
    @Test
    void testB14_NotTriangle_BVA_NegativeOne() {
        // NOTE: BVA - Biên (-1)
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(-1, 5, 5));
    }
    
    @Test
    void testB15_NotTriangle_BVA_AllNegative() {
        // NOTE: BVA - Biên (-1, -1, -1)
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(-1, -1, -1));
    }

    // =======================================================================
    // C. BẢNG QUYẾT ĐỊNH (Decision Table - DT) - 10 Tests
    // =======================================================================

    // DT C1: Đều (T-T-T)
    @Test
    void testC01_Equilateral_DT() {
        // NOTE: DT - Deu (a=b, b=c, a=c la True)
        assertEquals("Deu", classifier.classify(7, 7, 7));
    }

    // DT C2: Cân (a=b, b!=c, a!=c)
    @Test
    void testC02_Isosceles_DT_ab() {
        // NOTE: DT - Can (a=b)
        assertEquals("Can", classifier.classify(6, 6, 8));
    }

    // DT C3: Cân (a!=b, b=c, a!=c)
    @Test
    void testC03_Isosceles_DT_bc() {
        // NOTE: DT - Can (b=c)
        assertEquals("Can", classifier.classify(8, 6, 6));
    }

    // DT C4: Cân (a!=b, b!=c, a=c)
    @Test
    void testC04_Isosceles_DT_ac() {
        // NOTE: DT - Can (a=c)
        assertEquals("Can", classifier.classify(6, 8, 6));
    }

    // DT C5: Thường (F-F-F)
    @Test
    void testC05_Scalene_DT() {
        // NOTE: DT - Thuong (Khong canh nao bang nhau)
        assertEquals("Thuong", classifier.classify(5, 6, 7));
    }

    // DT C6-C8: K.Tam giác (Không thỏa mãn Bất đẳng thức)
    @Test
    void testC06_NotTriangle_DT_aPlusbLessC() {
        // NOTE: DT - K.TG (a+b < c)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(2, 3, 8));
    }
    
    @Test
    void testC07_NotTriangle_DT_aPluscLessB() {
        // NOTE: DT - K.TG (a+c < b)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(2, 8, 3));
    }
    
    @Test
    void testC08_NotTriangle_DT_bPluscLessA() {
        // NOTE: DT - K.TG (b+c < a)
        assertEquals("Khong_phai_Tam_giac", classifier.classify(8, 2, 3));
    }

    // DT C9-C10: K.Tam giác (Cạnh không dương)
    @Test
    void testC09_NotTriangle_DT_aNegative() {
        // NOTE: DT - K.TG (a < 0)
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(-5, 5, 5));
    }
    
    @Test
    void testC10_NotTriangle_DT_bZero() {
        // NOTE: DT - K.TG (b = 0)
        assertEquals("Khong_phai_Tam_giac_Sai_du_lieu", classifier.classify(5, 0, 5));
    }

  

}
