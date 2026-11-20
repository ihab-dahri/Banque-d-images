package fr.univrouen.banqueimages.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Command {

    public static final String GALLERY_VIEW = "gallery.jsp";
    public static final String CUSTOM_VIEW = "custom.jsp";
    public static final String ERROR_VIEW = "error.jsp";

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}