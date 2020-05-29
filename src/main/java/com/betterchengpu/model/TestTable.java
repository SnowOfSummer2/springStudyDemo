package com.betterchengpu.model;

public class TestTable {
    private String keyId;

    private Integer a;

    private String b;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "the keyId is " + this.getKeyId() + " ,A is " + this.getA() + " ,B is " + this.getB();
    }
}
