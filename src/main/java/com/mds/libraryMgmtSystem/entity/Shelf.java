package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    private Long id;

    @Column
    @NotEmpty
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
