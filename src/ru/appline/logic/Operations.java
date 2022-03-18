package ru.appline.logic;

public class Operations {

    public double results;

    private int a;

    private int b;

    private String math;

    public double results(double res){
        double result = res;
        return result;
    }

    public Operations(int a, int b, String math) {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public double mines(int a, int b, String math) {

        double result;

        result = a - b;

        return result;

    }

    public double plus(int a, int b, String math) {
        double result;

        result = a + b;

        return result;

    }

    public double division(int a, int b, String math) {
        double result;

        result = (double) a / b;

        return result;

    }

    public double multiplication(int a, int b, String math) {
        double result;

        result = a * b;

        return result;

    }

}
