package com.athenas.am.athenas.classes;

import com.google.firebase.firestore.Exclude;

public class Note {

    private String documentId;
    private String title;
    private String description;
    private String hourInit;
    private String hourEnd;
    private String day;
    private int priority;

    public Note(){
        //public no-arg constructor need
    }
    public Note(String title, String description, String hourInit, String hourEnd, String day,int priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.day = day;
        this.hourInit = hourInit;
        this.hourEnd = hourEnd;
    }

    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHourInit(String hourInit) {
        this.hourInit = hourInit;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDay() {return day; }

    public String getHourEnd() {return hourEnd;}

    public String getHourInit() {return hourInit;}
}
