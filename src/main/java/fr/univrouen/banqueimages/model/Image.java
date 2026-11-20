package fr.univrouen.banqueimages.model;


public class Image {

    private final String name;
    private final String path;

    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Image[" + name + ", " + path + "]";
    }
}