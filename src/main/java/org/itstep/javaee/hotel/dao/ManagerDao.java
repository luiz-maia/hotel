/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.dao;

import java.util.List;
import org.itstep.javaee.hotel.modelo.Manager;

/**
 *
 * @author Admin
 */
public interface ManagerDao {
    public Manager create(Manager manager);
    public Manager update(Manager manager);
    public void delete(Manager manager);
    public List<Manager> read();
    public Manager findById(Integer id);
}
