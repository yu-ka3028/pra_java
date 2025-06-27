package com.example;

/**
 * メインアプリケーションクラス
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Java Development Environment!");
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java home: " + System.getProperty("java.home"));
    }
    
    /**
     * 簡単な計算を行うメソッド
     * @param a 最初の数値
     * @param b 2番目の数値
     * @return 合計
     */
    public static int add(int a, int b) {
        return a + b;
    }
} 