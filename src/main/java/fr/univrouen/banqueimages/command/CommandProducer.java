package fr.univrouen.banqueimages.command;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;

@ApplicationScoped
public class CommandProducer {

    @Inject
    private HttpServletRequest request;

    @Inject
    private RandomGalleryCommand randomGalleryCommand;

    @Produces
    @RequestScoped
    @CurrentCommand
    public Command produceCommand() {
        return randomGalleryCommand;
    }
}