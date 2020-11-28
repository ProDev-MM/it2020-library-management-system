package com.mds.libraryMgmtSystem.pojo;

import javax.validation.constraints.NotEmpty;

public class ShelfPojo {
    private Long id;
    @NotEmpty
    private String room;

    public ShelfPojo(Long id, String room) {
        this.id = id;
        this.room = room;
    }

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
