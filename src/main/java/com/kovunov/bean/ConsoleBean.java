package com.kovunov.bean;

import com.kovunov.entity.Console;
import com.kovunov.service.GameService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class ConsoleBean implements Serializable {

    private Console console;

    @EJB
    GameService gameService;

    public ConsoleBean() {
    }

    @PostConstruct
    public void init() {
        console = new Console();
    }

    public void addConsole() {
        FacesContext context = FacesContext.getCurrentInstance();
        Boolean result = gameService.saveConsole(console);
        if (result) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Console Add Successful."));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Console Can't Add Successful."));
        }
        console = new Console();
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}
