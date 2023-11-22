package org.example.models;

public class User {
    private String email;
    private String passcode;
    private boolean deleted;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passcode='" + passcode + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
