package com.mitrais.psms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DaoStuff implements StuffDao {
    private DaoStuff {

    }

    private static class SingletonHelper {
        private static final DaoStuff INSTANCE = new DaoStuff();
    }


    public static DaoStuff getInstance() {
        return SingletonHelper.INSTANCE;
    }



    @Override
    public Optional<Stuff> find(String id) throws SQLException {
        String sql = "SELECT stuff_id, name, description, quantity, location FROM stuff WHERE stuff_id = ?";
        int id_stuff = 0, quantity = 0;
        String name = "", description = "", location = "";
        Connection conn = DataSourceFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            id_stuff = resultSet.getInt("stuff_id");
            name = resultSet.getString("name");
            description = resultSet.getString("description");
            quantity = resultSet.getInt("quantity");
            location = resultSet.getString("location");
        }
        return Optional.of(new Stuff(id_stuff, name, description, quantity, location));
    }

    @Override
    public List<Stuff> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Stuff o) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Stuff o) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Stuff o) throws SQLException {
        return false;
    }





}
