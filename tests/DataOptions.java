package com.example.tests;

public class DataOptions {

        public static final String DATABASE_NAME = "emergencyFinder.db";
        public static final int DATABASE_VERSION = 3;

        public static final String USER_TABLE = "user";

        public static final String ID = "user_id";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String FULL_NAME = "full_name";
        public static final String GENDER = "gender";
        public static final String BIRTH_DATE = "birthDate";
        public static final String USER_CITY = "user_city";
        public static final String MOBILE = "mobile";

        public static final String CREATE_TABLE_USER_ =
                "CREATE TABLE  " + USER_TABLE + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        EMAIL + " TEXT NOT NULL," +
                        FULL_NAME + " TEXT NOT NULL," +
                        GENDER + " TEXT NOT NULL," +
                        BIRTH_DATE + " TEXT NOT NULL," +
                        USER_CITY + " TEXT NOT NULL," +
                        MOBILE + " TEXT );";}