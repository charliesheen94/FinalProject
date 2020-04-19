package com.kovunov.bean;

import com.kovunov.entity.Console;
import com.kovunov.entity.Games;
import com.kovunov.service.GameService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EditGameViewBean implements Serializable {

    private Games games;
    private List<Games> gamesList;
    private List<Console> consoles;
    private String gamePrice;

    @EJB
    private GameService gameService;

    public EditGameViewBean() {
    }

    @PostConstruct
    public void init() {
        games = new Games();
        gamesList = gameService.getAll();
        consoles = gameService.getAllConsole();
        System.out.println("Console Size: "+ consoles.size());
    }

    public void editGameInfo(Games requestObj){
        this.games = requestObj;
        this.gamePrice = String.valueOf(requestObj.getPrice());
    }

    public String updateGame() {
        FacesContext context = FacesContext.getCurrentInstance();
        games.setPrice(Integer.valueOf(gamePrice));
        Boolean result = gameService.update(games);
        if (result) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Games Update Successful."));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Games Can't Update Successful."));
        }
        return "/dashboard.xhtml?faces-redirect=true";
    }

    public String deleteGame(Long gameIdNo) {
        FacesContext context = FacesContext.getCurrentInstance();
        Games games = gameService.findById(gameIdNo);
        Boolean result = gameService.delete(games);
        if (result) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Games Delete Successful."));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Games Can't Delete Successful."));
        }
        return "/dashboard.xhtml?faces-redirect=true";
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public List<Games> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Games> gamesList) {
        this.gamesList = gamesList;
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
