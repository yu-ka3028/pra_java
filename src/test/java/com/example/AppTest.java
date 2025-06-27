package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Appクラスのテスト
 */
@DisplayName("Appクラスのテスト")
class AppTest {

    @Test
    @DisplayName("addメソッドのテスト")
    void testAdd() {
        // 正常なケース
        assertEquals(5, App.add(2, 3), "2 + 3 = 5");
        assertEquals(0, App.add(-1, 1), "-1 + 1 = 0");
        assertEquals(-5, App.add(-2, -3), "-2 + (-3) = -5");
    }

    @Test
    @DisplayName("addメソッドの境界値テスト")
    void testAddBoundary() {
        // 境界値テスト
        assertEquals(Integer.MAX_VALUE, App.add(Integer.MAX_VALUE, 0));
        assertEquals(Integer.MIN_VALUE, App.add(Integer.MIN_VALUE, 0));
    }
} 