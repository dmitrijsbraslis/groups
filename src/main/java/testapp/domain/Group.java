package testapp.domain;

import java.io.Serializable;

public class Group implements Serializable{
    private String name;
    private long id;
    private String description;
    private boolean open;
    private int category;
    private long admin;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean is_open) {
        this.open = is_open;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getAdmin() {
        return admin;
    }

    public void setAdmin(long user_id) {
        this.admin = user_id;
    }
}
