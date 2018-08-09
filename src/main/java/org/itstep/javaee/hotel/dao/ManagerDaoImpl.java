/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.dao;

import java.sql.Connection;
import java.util.List;
import org.itstep.javaee.hotel.modelo.Manager;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.itstep.javaee.hotel.modelo.EmployeeRole;

/**
 *
 * @author Admin
 */
@Named(value = "managerDao")
@RequestScoped
public class ManagerDaoImpl implements ManagerDao {

    public ManagerDaoImpl() {
    }

    /*
    @Inject
    Manager manager;
     */
    @Override
    public void create(Manager manager) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into employee (id, name, telephone, address, role) value(?,?,?,?,?)";
//import com.mysql.cj.jdbc.JdbcPreparedStatement;
        JdbcPreparedStatement ps;
        try {
            ps = (JdbcPreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, manager.getId());
            ps.setString(2, manager.getNome());
            ps.setString(3, manager.getTelefone());
            ps.setString(4, manager.getEndereco());
            ps.setInt(5, EmployeeRole.MANAGER.ordinal());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Not supported yet. " + e.getMessage());
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Manager manager) {
        Connection con = DBConnect.getConnecttion();
        String sql = "delete employee where id = ?";
        JdbcPreparedStatement ps;
        try {
            ps = (JdbcPreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, manager.getId());
            int numLinhasExcluidas = ps.executeUpdate();
            if (numLinhasExcluidas != 1)
                throw new UnsupportedOperationException("Linha não excluída");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Not supported yet. " + e.getMessage());
        }
    }

    @Override
    public List<Manager> read() {
        List<Manager> managers = new ArrayList<Manager>();
        try {
            Connection con = DBConnect.getConnecttion();
            String sql = "select id, name, telephone, address from employee where role = " + EmployeeRole.MANAGER.ordinal();
            Statement statement;
            statement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Manager manager = new Manager(rs.getString(2), rs.getInt(1), rs.getString(3), rs.getString(4));
                managers.add(manager);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Not supported yet. " + e.getMessage());
        }
        return managers;
    }

    @Override
    public Manager findById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
