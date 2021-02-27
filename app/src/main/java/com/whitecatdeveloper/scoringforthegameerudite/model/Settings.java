package com.whitecatdeveloper.scoringforthegameerudite.model;

public class Settings {
    private Language language;

    private static Settings instance;

    public static Settings getInstance() {
        if (instance == null) instance = new Settings();
        return instance;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
