package model.dao.jdbcImplementation;

import model.DatabaseUtils;
import model.dao.ChildDao;
import model.domain.Child;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCChildDao implements ChildDao {

    @Override
    public Child get(long id) {
        String sql = "SELECT * FROM child WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        Child child = new Child(-1, "child not found", "", "", -1, -1);
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("id"));
            String currName = resultSet.getString("first_name");
            String currSurname = resultSet.getString("last_name");
            String currSex = resultSet.getString("sex");
            long currGroupId = Long.parseLong(resultSet.getString("group_id"));
            int currAge = Integer.parseInt(resultSet.getString("age"));
            child = new Child(currId, currName, currSurname, currSex, currGroupId, currAge);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return child;
    }

    @Override
    public List<Child> getAll() {
        List<Child> allChild = new ArrayList<>();
        String sql = "SELECT * FROM child;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("first_name");
                    String currSurname = resultSet.getString("last_name");
                    String currSex = resultSet.getString("sex");
                    long currGroupId = Long.parseLong(resultSet.getString("group_id"));
                    int currAge = Integer.parseInt(resultSet.getString("age"));
                    allChild.add(new Child(currId, currName, currSurname, currSex, currGroupId, currAge));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allChild;
    }

    @Override
    public void insert(Child child) {
        String sql = "INSERT INTO child (first_name, last_name, sex, group_id, age) VALUES (" +
                "'" + child.getFirstName() + "', '" + child.getLastName() + "', '" + child.getSex() + "', '" + child.getGroupId()
                + "', " + child.getAge() + ")";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void update(Child child, String[] params) {
        String sql = "UPDATE child SET (first_name, last_name, sex, group_id, age) = ("
                + "'" + params[0] + "', '" + params[1] + "', '" + params[2] + "', '" + Long.parseLong(params[3]) + "', " + child.getAge()
                + ") WHERE id = " + child.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void delete(Child child) {
        String sql = "DELETE FROM child WHERE id = " + child.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void deleteFromExtraClass(String childId, String extraClassId) {
        String sql = "DELETE FROM extra_class_child AS ecc WHERE ecc.child_id = " + childId + " AND ecc.extra_class_id = " + extraClassId;
        DatabaseUtils.getInstance().update(sql);
    }
}
