package com.challengeappmarceloscaccia.com.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Categorias {

    public String id;
    public int parent_id;
    @SerializedName("name")
    public String Name;
    public String description;
    public int child_count;
    public int children;
    public String slug;

    public Categorias(String id, int parent_id, String name, String description, int child_count, int children, String slug) {
        this.id = id;
        this.parent_id = parent_id;
        this.Name = name;
        this.description = description;
        this.child_count = child_count;
        this.children = children;
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}
