/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.itstep.javaee.hotel.dao.ManagerDao;
import org.itstep.javaee.hotel.dao.impl.ManagerDaoImpl;
import org.itstep.javaee.hotel.modelo.Manager;

/**
 *
 * @author Admin
 */
@Stateless
public class ManagerBO implements ManagerBeanLocal {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    public Manager create(Manager manager) {
        ManagerDao dao = new ManagerDaoImpl(em);
        return dao.create(manager);
    }

    public void excluir(Manager manager) {
        ManagerDao dao = new ManagerDaoImpl(em);
        dao.delete(manager);
    }

    public Manager update(Manager manager) {
        ManagerDao dao = new ManagerDaoImpl(em);
        return dao.update(manager);
    }

    public Manager findById(Integer id) {
        ManagerDao dao = new ManagerDaoImpl(em);
        return dao.findById(id);
    }

    public List<Manager> findByAll() {
        ManagerDao dao = new ManagerDaoImpl(em);
        return dao.findAll();
    }
}
