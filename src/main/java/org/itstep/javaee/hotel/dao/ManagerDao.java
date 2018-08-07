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
    
    public void create(Manager manager);
    public void update();
    public void delete();
    public List<Manager> read();
    public Manager findById();
    
}
