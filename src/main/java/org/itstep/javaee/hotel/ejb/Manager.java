/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.itstep.javaee.hotel.dao.ManagerDao;

/**
 *
 * @author Admin
 */
@Stateless
public class Manager implements ManagerBeanLocal {

    @PersistenceContext(unitName = "ManagerPU")
    private EntityManager em;

    public Manager salvar(Manager manager) throws Exception {
        ManagerDAO dao = new ManagerDAO(em);
        return dao.salvar(manager);
    }

    public void excluir(Long id) {
        ManagerDAO dao = new ManagerDAO(em);
        dao.excluir(id);
    }

    public Manager findById(Long id) {
        ManagerDao dao = new ManagerDAO(em);
        return dao.consultarPorId(id);
    }
}
