package com.whitecatdeveloper.scoringforthegameerudite.model;

public class Settings {
    private String language;
    private String mainTheme;
    private static Settings settingsInstance;

    private Settings() {}

    public static Settings getInstance() {
        if (settingsInstance == null) settingsInstance = new Settings();
        return settingsInstance;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMainTheme() {
        return mainTheme;
    }

    public void setMainTheme(String mainTheme) {
        this.mainTheme = mainTheme;
    }
}
