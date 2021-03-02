package com.whitecatdeveloper.scoringforthegameerudite.model;


public class Settings {
    private Language language;
    private MyBackgroundColors colors;


    private static Settings instance;

    private Settings() {}

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

    public MyBackgroundColors getColors() {
        return colors;
    }

    public void setColors(MyBackgroundColors colors) {
        this.colors = colors;
    }
}
