package fr.univrouen.banqueimages.command;

import fr.univrouen.banqueimages.service.GalleryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ApplicationScoped
public class RandomGalleryCommand extends Command {

    @Inject
    private GalleryService galleryService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("title", "Galerie aléatoire");
        request.setAttribute("images", galleryService.getRandomImages());
        return GALLERY_VIEW;
    }
}