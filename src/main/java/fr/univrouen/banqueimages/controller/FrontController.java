package fr.univrouen.banqueimages.controller;

import fr.univrouen.banqueimages.command.Command;
import fr.univrouen.banqueimages.command.CurrentCommand;
import fr.univrouen.banqueimages.service.GalleryService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "", loadOnStartup = 1)
public class FrontController extends HttpServlet {

    private static final String VIEWS_FOLDER = "/WEB-INF/views/";

    @Inject
    private GalleryService galleryService;

    @Inject
    @CurrentCommand
    private Command command;

    @Override
    public void init() throws ServletException {
        String imagesPath = getServletContext().getRealPath("/" + GalleryService.IMAGES_FOLDER);
        galleryService.loadImages(imagesPath);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String view = command.execute(request, response);
        request.getRequestDispatcher(VIEWS_FOLDER + view).forward(request, response);
    }
}