package com.challengeappmarceloscaccia.com.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Subcategorias {

    public String id;
    public String parent_id;
    @SerializedName("name")
    public String Name;
    public String normalized_name;
    public String description;
    public int child_count;
    public int children;
    public String icon;


    public Subcategorias(String id, String parent_id, String name, String normalized_name, String description, int child_count, int children, String icon) {
        this.id = id;
        this.parent_id = parent_id;
        Name = name;
        this.normalized_name = normalized_name;
        this.description = description;
        this.child_count = child_count;
        this.children = children;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNormalized_name() {
        return normalized_name;
    }

    public void setNormalized_name(String normalized_name) {
        this.normalized_name = normalized_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getChild_count() {
        return child_count;
    }

    public void setChild_count(int child_count) {
        this.child_count = child_count;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
