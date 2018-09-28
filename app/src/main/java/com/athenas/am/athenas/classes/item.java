package com.athenas.am.athenas.classes;

public class item {

    int backgound ;
    String profileName;
    int profilePhoto;
    int nbFollowers;

    public item(){
    }

    public item(int backgound,String profileName,int profilePhoto, int nbFollowers){
        this.backgound = backgound;
        this.profileName = profileName;
        this.profilePhoto = profilePhoto;
        this.nbFollowers = nbFollowers;
    }

    public int getBackgound() {
        return backgound;
    }

    public String getProfileName() {
        return profileName;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public int getNbFollowers() {
        return nbFollowers;
    }

    public void setBackgound(int backgound) {
        this.backgound = backgound;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public void setNbFollowers(int nbFollowers) {
        this.nbFollowers = nbFollowers;
    }
}
