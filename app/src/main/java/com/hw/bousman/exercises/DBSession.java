package com.hw.bousman.exercises;

import java.util.Date;

public class DBSession {
    public int SessionId;
    public Date StartDate;
    public String Name;

    @Override
    public String toString() {
        return "ID:" + SessionId + " Name:" + Name;
    }
}
