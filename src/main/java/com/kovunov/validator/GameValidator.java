package com.kovunov.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;

@FacesValidator
public class GameValidator implements Validator {
    private String[] gameNames = {"God of War", "Legend of Zelda", "Rainbow Six"};


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object name) {
        if (!Arrays.asList(gameNames).contains(name)) {
            FacesMessage msg = new FacesMessage("Games name should be one of these: " + Arrays.toString(gameNames));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
