package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;

@Entity
public class Librarian extends User{

    @Enumerated(EnumType.STRING)
    private Position position;

    public enum Position{
       Teacher, Clerk;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
