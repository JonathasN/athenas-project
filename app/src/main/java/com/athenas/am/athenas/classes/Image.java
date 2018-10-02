package com.athenas.am.athenas.classes;

public class Image {

    private String imageId;
    private String url;
    private String documentId;

    public Image() {

    }

    public Image(String imageId, String url, String documentId) {
        this.imageId = imageId;
        this.url = url;
        this.documentId = documentId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
