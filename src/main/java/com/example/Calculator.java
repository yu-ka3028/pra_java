package com.example;


public class Calculator {

    public double add(double a, double b){
        return a + b;
    }

    public double subtract(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("ゼロ除算はできません");
        }
        return a / b;
    }

    public double power(double a, double b){
        return Math.pow(a, b);
    }

    public double sqrt(double a){
        if(a < 0){
            throw new IllegalArgumentException("負の数の平方根は計算できません");
        }
        return Math.sqrt(a);
    }
}
