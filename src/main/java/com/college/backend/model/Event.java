package com.college.backend.model;
import java.time.LocalDate;
public record Event (
    int eventid,
    String eventname,
    String descrp,
    LocalDate eventdate,
    String Loc,
    int createdby
){}


