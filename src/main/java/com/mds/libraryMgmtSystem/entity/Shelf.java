package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "Shelf")
public class Shelf {

    @Id
    private Long id;

    @Column
    private String room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
