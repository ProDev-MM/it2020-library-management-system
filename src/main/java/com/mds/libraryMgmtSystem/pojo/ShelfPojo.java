package com.mds.libraryMgmtSystem.pojo;

public class ShelfPojo {
    Long id;
    String room;

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
