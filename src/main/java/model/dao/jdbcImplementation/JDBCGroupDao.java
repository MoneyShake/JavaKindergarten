package model.dao.jdbcImplementation;

import model.DatabaseUtils;
import model.dao.GroupDao;
import model.domain.Child;
import model.domain.Group;
import model.domain.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCGroupDao implements GroupDao {
    @Override
    public Group get(long id) {
        String sql = "SELECT * FROM gr WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        Group group = new Group(-1, "group not found", -1, -1);
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("id"));
            String currName = resultSet.getString("gr_name");
            int minAge = Integer.parseInt(resultSet.getString("min_age"));
            int maxAge = Integer.parseInt(resultSet.getString("max_age"));
            group = new Group(currId, currName, minAge, maxAge);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public List<Group> getAll() {
        List<Group> allGroup = new ArrayList<>();
        String sql = "SELECT * FROM gr;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("gr_name");
                    int minAge = Integer.parseInt(resultSet.getString("min_age"));
                    int maxAge = Integer.parseInt(resultSet.getString("max_age"));
                    allGroup.add(new Group(currId, currName, minAge, maxAge));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allGroup;
    }

    @Override
    public void insert(Group group) {
        String sql = "INSERT INTO gr (gr_name, min_age, max_age) VALUES (" +
                "'" + group.getName() + "', " + group.getMinAge() + ", " + group.getMaxAge() + ")";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void update(Group group, String[] params) {
        String sql = "UPDATE gr SET (gr_name, min_age, max_age) = ("
                + "'" + params[0] + "', " + Integer.parseInt(params[1]) + ", " + Integer.parseInt(params[2]) + ") WHERE id = " + group.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void delete(Group group) {
        String sql = "DELETE FROM gr WHERE id = " + group.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public List<Child> getChildByGroupId(long id) {
        List<Child> allChildInGroup = new ArrayList<>();
        String sql = "SELECT * FROM child WHERE child.group_id = " + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("first_name");
                    String currSurname = resultSet.getString("last_name");
                    String currSex = resultSet.getString("sex");
                    long currGroupId = Long.parseLong(resultSet.getString("group_id"));
                    int age = Integer.parseInt(resultSet.getString("age"));
                    allChildInGroup.add(new Child(currId, currName, currSurname, currSex, currGroupId, age));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allChildInGroup;
    }

    @Override
    public List<Teacher> getTeachersByGroupId(long id) {
        List<Teacher> allTeachersInGroup = new ArrayList<>();
        String sql = "SELECT t.id AS id, t.first_name AS first_name, t.last_name AS last_name, t.sex AS sex  FROM gr AS g JOIN gr_teacher AS gt ON g.id = gt.group_id JOIN teacher as t ON gt.teacher_id = t.id WHERE g.id = " + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("first_name");
                    String currSurname = resultSet.getString("last_name");
                    String currSex = resultSet.getString("sex");
                    allTeachersInGroup.add(new Teacher(currId, currName, currSurname, currSex));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTeachersInGroup;
    }
}
