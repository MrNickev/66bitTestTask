package com.example.test66bit.Entities;

public enum Gender {
    Male("Мужской"), Female("Женский");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender fromString(String gender) {
        for (Gender g : Gender.values()) {
            if (g.value.equalsIgnoreCase(gender))
                return g;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
