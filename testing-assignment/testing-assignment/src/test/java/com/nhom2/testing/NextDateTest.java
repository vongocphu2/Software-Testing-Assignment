package com.nhom2.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextDateTest {

    // --- BVA & ECP ---
    @Test
    void testBienDayMonthYear() {
        assertEquals("2/1/1812", NextDate.run(1, 1, 1812)); 
       
        assertEquals("1/1/2031", NextDate.run(31, 12, 2030)); 
    }

    @Test
    void testGiaTriKhongHopLe() {
        assertEquals("Ngay khong hop le", NextDate.run(0, 1, 2000));
        assertEquals("Ngay khong hop le", NextDate.run(32, 1, 2000));
        assertEquals("Thang khong hop le", NextDate.run(15, 0, 2000));
        assertEquals("Thang khong hop le", NextDate.run(15, 13, 2000));
        
        // Test nam khong hop le: 2031 moi bi loi (vi code cho pheo  den nam 2030)
        assertEquals("Nam khong hop le", NextDate.run(15, 6, 1811));
        assertEquals("Nam khong hop le", NextDate.run(15, 6, 2031)); 
    }

    // --- Decision Table ---
    @Test
    void testThang30Ngay() { 
        assertEquals("16/4/2022", NextDate.run(15, 4, 2022)); 
        assertEquals("1/5/2022", NextDate.run(30, 4, 2022));  
        assertEquals("Ngay khong hop le", NextDate.run(31, 4, 2022)); 
    }

    @Test
    void testThang31Ngay() { 
        assertEquals("16/1/2022", NextDate.run(15, 1, 2022));
        assertEquals("1/2/2022", NextDate.run(31, 1, 2022));
    }

    @Test
    void testCuoiNam() { 
        assertEquals("1/1/2023", NextDate.run(31, 12, 2022));
    }

    @Test
    void testThang2_NamThuong() { 
        assertEquals("16/2/2021", NextDate.run(15, 2, 2021)); 
        assertEquals("1/3/2021", NextDate.run(28, 2, 2021));  
        assertEquals("Ngay khong hop le", NextDate.run(29, 2, 2021)); 
    }

    @Test
    void testThang2_NamNhuan() { 
        assertEquals("29/2/2020", NextDate.run(28, 2, 2020)); 
        assertEquals("1/3/2020", NextDate.run(29, 2, 2020));  
        assertEquals("29/2/2000", NextDate.run(28, 2, 2000));
        assertEquals("1/3/1900", NextDate.run(28, 2, 1900));
    }

    // --- PICT ---
    @Test
    void testCombinatorial_PICT() {
        assertEquals("2/1/2000", NextDate.run(1, 1, 2000));
        assertEquals("1/3/2001", NextDate.run(28, 2, 2001));
        assertEquals("1/5/2012", NextDate.run(30, 4, 2012));
    }
    @Test
    void testConstructor() {
        NextDate nextDate = new NextDate();
        assertNotNull(nextDate);
    }
}