package com.kovunov.bean;

import com.kovunov.entity.Console;
import com.kovunov.entity.Games;
import com.kovunov.service.GameService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AllGamesViewBean implements Serializable {

    private Games games;
    private List<Console> consoles;
    private String gamePrice;

    @EJB
    private GameService gameService;

    @PostConstruct
    public void init() {
        games = new Games();
        consoles = gameService.getAllConsole();
    }

    public String addPlayerInformation() {
        FacesContext context = FacesContext.getCurrentInstance();
        games.setPrice(Integer.valueOf(gamePrice));
        Boolean result = gameService.create(games);
        if (result) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Games Add Successful."));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Games Can't Add Successful."));
        }
        System.out.println("Games List Size::"+ gameService.getAll().size());
        return "/dashboard.xhtml?faces-redirect=true";
    }

    public void refresh() {
        games = new Games();
        consoles = gameService.getAllConsole();
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
    }

    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }
}
