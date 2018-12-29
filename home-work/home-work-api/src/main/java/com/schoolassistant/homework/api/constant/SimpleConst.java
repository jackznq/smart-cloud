package com.schoolassistant.homework.api.constant;

public enum SimpleConst {

    one("y", 1), zero("n", 0);

    private String key;

    private int value;

    SimpleConst(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
