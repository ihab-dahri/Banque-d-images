package fr.univrouen.banqueimages.model;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@ApplicationScoped
public class ImageBank {

    
    private final Map<String, ImageCategory> categories = new TreeMap<>();

    public void addCategory(ImageCategory category) {
        categories.put(category.getName(), category);
    }

    public void clear() {
        categories.clear();
    }

    public List<ImageCategory> getCategories() {
        return new ArrayList<>(categories.values());
    }

    public List<String> getCategoryNames() {
        return new ArrayList<>(categories.keySet());
    }

    public ImageCategory getCategory(String name) {
        return categories.get(name);
    }

    
    public List<Image> getRandomImages(int n) {
        List<Image> all = new ArrayList<>();
        for (ImageCategory c : categories.values()) {
            all.addAll(c.getImages());
        }
        return pickRandom(all, n);
    }

    
    public List<Image> getRandomImages(String categoryName, int n) {
        ImageCategory category = categories.get(categoryName);
        if (category == null) {
            throw new IllegalArgumentException("La catégorie \"" + categoryName + "\" n'existe pas.");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Le nombre d'images doit être supérieur à 0.");
        }
        if (n > category.size()) {
            throw new IllegalArgumentException("La catégorie \"" + categoryName + "\" ne contient que "
                    + category.size() + " images (demandé : " + n + ").");
        }
        return pickRandom(category.getImages(), n);
    }

    private List<Image> pickRandom(List<Image> source, int n) {
        List<Image> copy = new ArrayList<>(source);
        Collections.shuffle(copy);
        return copy.subList(0, Math.min(n, copy.size()));
    }
}