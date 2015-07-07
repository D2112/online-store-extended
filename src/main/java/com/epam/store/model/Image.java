package com.epam.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
public class Image extends BaseEntity {
    public static final int STANDARD_WIDTH = 300;
    public static final int STANDARD_HEIGHT = 200;
    private String name;
    private byte[] content;

    @Column(name = "last_modified")
    private Timestamp lastModified;

    @Column(name = "content_type")
    private String contentType;

    public Image() {
    }

    public Image(String name, String contentType, byte[] content) {
        lastModified = new Timestamp(System.currentTimeMillis());
        this.name = name;
        this.contentType = contentType;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (name != null ? !name.equals(image.name) : image.name != null) return false;
        if (!Arrays.equals(content, image.content)) return false;
        if (lastModified != null ? !lastModified.equals(image.lastModified) : image.lastModified != null) return false;
        return !(contentType != null ? !contentType.equals(image.contentType) : image.contentType != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (content != null ? Arrays.hashCode(content) : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", content=" + Arrays.toString(content) +
                "} " + super.toString();
    }
}
