package ssst.healthdiary.models;

public enum MaritalStatus {
    ANNULLED("Annulled"),
    DIVORCED("Divorced"),
    LEGALLY_SEPARATED("Legally Separated"),
    INTERLOCUTORY("Interlocutory"),
    MARRIED("Married"),
    POLYGAMOUS("Polygamous"),
    NEVER_MARRIED("Never Married"),
    DOMESTIC_PARTNER("Domestic Partner"),
    UNMARRIED("Unmarried"),
    WIDOWED("Widowed"),
    UNKNOWN("Unknown");

    private final String name;

    MaritalStatus(String name) {
        this.name=name;
    }
}
