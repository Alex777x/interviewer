package pl.aliaksandrou.interviewer.enums;

public enum Language {
    ENGLISH("English"),
    POLISH("Polish"),
    MANDARIN("Mandarin");

    public final String label;

    Language(final String label) {
        this.label = label;
    }
}
