package fr.univrouen.banqueimages.service;

import fr.univrouen.banqueimages.model.Image;
import fr.univrouen.banqueimages.model.ImageBank;
import fr.univrouen.banqueimages.model.ImageCategory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class GalleryService {

    public static final String IMAGES_FOLDER = "images";
    public static final int RANDOM_GALLERY_SIZE = 50;

    @Inject
    private ImageBank imageBank;

    public void loadImages(String imagesRealPath) {
        imageBank.clear();
        File root = new File(imagesRealPath);
        File[] folders = root.listFiles(File::isDirectory);
        if (folders == null) {
            return;
        }
        Arrays.sort(folders);
        for (File folder : folders) {
            ImageCategory category = new ImageCategory(folder.getName());
            File[] files = folder.listFiles(f -> f.isFile() && isImage(f.getName()));
            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    String path = IMAGES_FOLDER + "/" + folder.getName() + "/" + file.getName();
                    category.addImage(new Image(stripExtension(file.getName()), path));
                }
            }
            imageBank.addCategory(category);
        }
    }

    public List<Image> getRandomImages() {
        return imageBank.getRandomImages(RANDOM_GALLERY_SIZE);
    }

    public List<Image> getRandomImages(String category, int n) {
        return imageBank.getRandomImages(category, n);
    }

    public List<String> getCategoryNames() {
        return imageBank.getCategoryNames();
    }

    private boolean isImage(String fileName) {
        String lower = fileName.toLowerCase();
        return lower.endsWith(".jpg") || lower.endsWith(".jpeg")
                || lower.endsWith(".png") || lower.endsWith(".gif");
    }

    private String stripExtension(String fileName) {
        int dot = fileName.lastIndexOf('.');
        return dot > 0 ? fileName.substring(0, dot) : fileName;
    }
}