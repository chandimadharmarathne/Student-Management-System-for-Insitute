package com.chandima.edumanagement.database;

import com.chandima.edumanagement.model.Users;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Users> usersTable = new ArrayList<>();


    static {
        usersTable.add(new Users("a","a","a","a"));
    }
}

