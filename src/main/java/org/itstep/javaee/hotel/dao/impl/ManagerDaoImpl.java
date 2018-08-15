/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.dao.impl;

import java.sql.Connection;
import java.util.List;
import org.itstep.javaee.hotel.modelo.Manager;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.itstep.javaee.hotel.dao.DBConnect;
import org.itstep.javaee.hotel.dao.ManagerDao;
import org.itstep.javaee.hotel.exception.BusinessException;
import org.itstep.javaee.hotel.modelo.EmployeeRole;

/**
 *
 * @author Admin
 */
@Named(value = "managerDao")
public class ManagerDaoImpl implements ManagerDao {

    private EntityManager entityManager;

    public ManagerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    @Inject
    Manager manager;
     */
    @Override
    public Manager create(Manager manager) {
        /* Verifica se ainda não está salvo no banco de dados. */
        if (manager.getId() == null) {
            /* Salva no banco de dados. */
            this.entityManager.persist(manager);
        } else {
            /* Verifica se o manager não está no estado managed. */
            if (!this.entityManager.contains(manager)) {
                /* Se o manager não está no estado managed verifica se ele existe na base. */
                if (findById(manager.getId()) == null) {
                    throw new BusinessException("Manager não existe!");
                }
            }
            /* Faz uma atualização do manager. */
            return entityManager.merge(manager);
        }

        /* Retorna o manager que foi salvo, este retorno ocorre para modemos ter o id que foi salvo. */
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        /* Faz uma atualização do manager. */
        this.entityManager.getTransaction();
        return entityManager.merge(manager);
    }

    @Override
    public void delete(Manager manager) {
        this.entityManager.getTransaction();
        /* Verifica se ainda não está salvo no banco de dados. */
        if (manager.getId() == null) {
            /* Se o manager não está no estado managed verifica se ele existe na base. */
            throw new BusinessException("Manager id não existe!");
        } else {
            /* Verifica se o manager não está no estado managed. */
            if (!this.entityManager.contains(manager)) {
                /* Se o manager não está no estado managed verifica se ele existe na base. */
                throw new BusinessException("Manager id não existe!");
            } else {
                /* Exclui no banco de dados. */
                this.entityManager.remove(manager);
            }
        }
        this.entityManager.getTransaction();
    }

    @Override
    public List<Manager> findAll() {
        return entityManager.createNamedQuery("Manager.all", Manager.class).getResultList();
//        return entityManager.createQuery("SELECT e FOM Empregado e", Manager.class).getResultList();
    }

    @Override
    public Manager findById(Integer id) {
        return entityManager.find(Manager.class, id);
    }
}
