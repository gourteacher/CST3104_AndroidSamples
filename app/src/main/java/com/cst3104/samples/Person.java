package com.cst3104.samples;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int uid;

    @ColumnInfo(name="last_name")
    public String last_name;

    public String first_name;

    public Person(String lname, String fname) {
        last_name = lname;
        first_name = fname;
    }

    public Person() {}


}

