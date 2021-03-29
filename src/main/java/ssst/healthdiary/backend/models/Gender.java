package ssst.healthdiary.backend.models;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String name;

    Gender(String name) {
        this.name=name;
    }
}
