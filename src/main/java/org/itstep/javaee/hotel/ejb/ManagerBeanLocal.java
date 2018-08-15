/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.ejb;

import java.util.List;
import javax.ejb.Local;
import org.itstep.javaee.hotel.dao.ManagerDao;
import org.itstep.javaee.hotel.dao.impl.ManagerDaoImpl;
import org.itstep.javaee.hotel.modelo.Manager;

/**
 *
 * @author Admin
 */
@Local
public interface ManagerBeanLocal {
    public Manager create(Manager manager);
    public void excluir(Manager manager);
    public Manager update(Manager manager);
    public Manager findById(Integer id);
    public List<Manager> findByAll();
}
