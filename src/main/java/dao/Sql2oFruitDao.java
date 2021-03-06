package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oFruitDao implements FruitDao{

    private final Sql2o sql2o;

    public Sql2oFruitDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    public void add(Fruit fruit) {
        String sql = "INSERT INTO fruits (userId, name, location, pub, description, barter) VALUES (:userId, :name, :location, :pub, :description, :barter)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(fruit)
                    .executeUpdate()
                    .getKey();
            fruit.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Fruit> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM fruits")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Fruit.class);
        }
    }

    @Override
    public Fruit findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM fruits WHERE id = :id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Fruit.class);
        }
    }

    @Override
    public void update(Fruit fruit, String newName, String newLocation, boolean pub, String newDescription, boolean barter){
        String sql = "UPDATE fruits SET (name, location, pub, description, barter) = (:name, :location, :pub, :description, :barter) WHERE id=:id";

        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("location", newLocation)
                    .addParameter("pub", pub)
                    .addParameter("description", newDescription)
                    .addParameter("barter", barter)
                    .addParameter("id", fruit.getId())
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from fruits WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}

