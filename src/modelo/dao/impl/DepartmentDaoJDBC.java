package modelo.dao.impl;

import db.DB;
import db.DbExcecao;
import modelo.dao.DepartmentDao;
import modelo.entidade.Departament;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Departament obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department "
                        + "(Name) "
                        + "VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbExcecao("Nenhuma linha afetada!");
            }
        }
        catch (SQLException e) {
            throw new DbExcecao(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Departament obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Departament findById(Integer id) {
        return null;
    }

    @Override
    public List<Departament> findAll() {
        return List.of();
    }
}
