package fr.univrouen.banqueimages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageCategory {

    private final String name;
    private final List<Image> images = new ArrayList<>();

    public ImageCategory(String name) {
        this.name = name;
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public String getName() {
        return name;
    }

    public List<Image> getImages() {
        return Collections.unmodifiableList(images);
    }

    public int size() {
        return images.size();
    }
}