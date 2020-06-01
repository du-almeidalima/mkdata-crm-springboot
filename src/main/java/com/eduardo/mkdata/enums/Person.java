package com.eduardo.mkdata.enums;

public enum Person {
    FISICA("FISICA"),
    JURIDICA("JURIDICA");

    public String personValue;

    Person(String value) {
        this.personValue = value;
    }
}
