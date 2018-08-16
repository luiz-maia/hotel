/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.itstep.javaee.hotel.ejb.ManagerBO;
import org.itstep.javaee.hotel.modelo.Manager;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Admin
 */
@Named(value = "managerView")
@ViewScoped
public class ManagerView implements Serializable {

    @EJB
    ManagerBO managerBO;

    private Manager manager;
    private List<Manager> managers;
    private boolean skip;

    /**
     * Creates a new instance of ManagerView
     */
    public ManagerView() {
        manager = new Manager();
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public void create() {
        managerBO.create(manager);
        managers = null;
        FacesMessage msg = new FacesMessage("Successful", "Gravou :" + manager.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void delete(Manager manager) {
        managerBO.excluir(manager);
        managers = null;
        FacesMessage msg = new FacesMessage("Successful", "Excluiu :" + manager.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Manager> getManagers() {
        if (managers == null) {
            managers = managerBO.findByAll();
        }
        return managers;
    }

    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}
