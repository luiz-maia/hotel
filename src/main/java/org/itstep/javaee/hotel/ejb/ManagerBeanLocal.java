/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.ejb;

import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface ManagerBeanLocal {
    public Manager salvar(Manager manager) throws Exception;
    public void excluir(Long id);
    public Manager findById(Long id);
}
