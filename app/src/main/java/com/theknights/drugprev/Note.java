package com.theknights.drugprev;

import com.google.firebase.firestore.Exclude;
public class Note {
    private String documentId;
    private String message;

    public Note() {
        //public no-arg constructor needed
    }
    @Exclude
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public Note(String title, String description) {
        this.message = title;
    }
    public String getMessage() {
        return message;
    }

}
