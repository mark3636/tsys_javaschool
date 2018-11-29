package ru.tsystems.medicalinstitute.bo;

public class Role {
    private int id;
    private String name;
    private String alias;
    private String description;

    public Role() {
    }

    public Role(int id, String name, String alias, String description) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
