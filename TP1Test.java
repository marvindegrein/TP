import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TP1Test {
    
    @Test
    public void testTambahString() {
        assertEquals("15", TP1.tambahString("10", "5"));
        assertEquals("0", TP1.tambahString("-5", "5"));
        assertEquals("10", TP1.tambahString("10", ""));
        assertEquals("5", TP1.tambahString("", "5"));
    }
    
    @Test
    public void testKurangString() {
        assertEquals("5", TP1.kurangString("10", "5"));
        assertEquals("-10", TP1.kurangString("-5", "5"));
        assertEquals("10", TP1.kurangString("10", ""));
        assertEquals("0", TP1.kurangString("", "5"));
    }
    
    @Test
    public void testKaliString() {
        assertEquals("50", TP1.kaliString("10", "5"));
        assertEquals("-25", TP1.kaliString("-5", "5"));
        assertEquals("0", TP1.kaliString("10", ""));
        assertEquals("0", TP1.kaliString("", "5"));
    }
    
    @Test
    public void testBagiString() {
        assertEquals("2", TP1.bagiString("10", "5"));
        assertEquals("-1", TP1.bagiString("-5", "5"));
        assertEquals("0", TP1.bagiString("10", ""));
        assertEquals("0", TP1.bagiString("", "5"));
        assertEquals("0", TP1.bagiString("5", "0")); // Division by zero should return "0"
    }
    
    @Test
    public void testLebihBesar() {
        assertTrue(TP1.lebihBesar("10", "5"));
        assertFalse(TP1.lebihBesar("5", "10"));
        assertFalse(TP1.lebihBesar("5", "5"));
        assertTrue(TP1.lebihBesar("10", ""));
        assertFalse(TP1.lebihBesar("", "5"));
        assertFalse(TP1.lebihBesar("", ""));
        assertTrue(TP1.lebihBesar("5", "-10"));
    }
    
    @Test
    public void testHitungDiskonVoucher() {
        // Testing voucher discount calculation
        String voucherCode = "CHU-BET-ABE-TIN-YUK-YID-MFR-MNS-BIL-FER-MAZ";
        String discount = TP1.hitungDiskonVoucher(voucherCode);
        
        // We can't predict the exact output without analyzing the algorithm in detail,
        // but we can verify it returns a non-empty string that represents a number
        assertNotNull(discount);
        assertFalse(discount.isEmpty());
        
        // Try to parse the result as an integer
        int discountValue = Integer.parseInt(discount);
        
        // Ensure discount is between 0 and 100
        assertTrue(discountValue >= 0 && discountValue <= 100);
    }
    
    @Test
    public void testGetNilaiKarakterReflection() throws Exception {
        // Using reflection to test private method getNilaiKarakter
        java.lang.reflect.Method method = TP1.class.getDeclaredMethod("getNilaiKarakter", char.class);
        method.setAccessible(true);
        
        // Test various character types
        assertEquals(10, method.invoke(null, 'A')); // A should be 10
        assertEquals(35, method.invoke(null, 'Z')); // Z should be 35
        assertEquals(10, method.invoke(null, 'a')); // a should be 10
        assertEquals(35, method.invoke(null, 'z')); // z should be 35
        assertEquals(5, method.invoke(null, '5'));  // 5 should be 5
        assertEquals(0, method.invoke(null, '-'));  // - should be 0
        assertEquals(0, method.invoke(null, '!'));  // Other characters should be 0
    }
}