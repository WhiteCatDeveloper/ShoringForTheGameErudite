package com.whitecatdeveloper.scoringforthegameerudite.database;

import android.provider.BaseColumns;

public class SettingsContract {
    
    public static final class SettingsEntry implements BaseColumns {
        public static final String TABLE_NAME = "settings";
        public static final String COLUMN_LANGUAGE = "language";
        public static final String COLUMN_BACKGROUND_COLORS = "background_colors";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";

        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS "  + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_LANGUAGE +
                " " + TYPE_TEXT + ", " + COLUMN_BACKGROUND_COLORS + " " + TYPE_TEXT + ")";


        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
