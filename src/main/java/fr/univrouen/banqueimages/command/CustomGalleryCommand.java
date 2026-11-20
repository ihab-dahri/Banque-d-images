package fr.univrouen.banqueimages.command;

import fr.univrouen.banqueimages.model.Image;
import fr.univrouen.banqueimages.service.GalleryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@ApplicationScoped
public class CustomGalleryCommand extends Command {

    public static final String PAGE_SELECT = "select";
    public static final String PAGE_CUSTOM = "custom";

    @Inject
    private GalleryService galleryService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        if (PAGE_SELECT.equals(page)) {
            request.setAttribute("categories", galleryService.getCategoryNames());
            return CUSTOM_VIEW;
        }

        String category = request.getParameter("category");
        String countParam = request.getParameter("count");

        if (category == null || category.isBlank()) {
            return error(request, "Aucune catégorie n'a été choisie.");
        }

        int count;
        try {
            count = Integer.parseInt(countParam.trim());
        } catch (NumberFormatException | NullPointerException e) {
            return error(request, "Le nombre d'images doit être un entier.");
        }

        try {
            List<Image> images = galleryService.getRandomImages(category, count);
            request.setAttribute("title", "Catégorie " + category + " (" + images.size() + " images)");
            request.setAttribute("images", images);
            return GALLERY_VIEW;
        } catch (IllegalArgumentException e) {
            return error(request, e.getMessage());
        }
    }

    private String error(HttpServletRequest request, String message) {
        request.setAttribute("errorMessage", message);
        return ERROR_VIEW;
    }
}