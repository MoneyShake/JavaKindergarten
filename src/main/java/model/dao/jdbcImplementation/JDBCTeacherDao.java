package model.dao.jdbcImplementation;

import model.DatabaseUtils;
import model.dao.TeacherDao;
import model.domain.Group;
import model.domain.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTeacherDao implements TeacherDao {
    @Override
    public Teacher get(long id) {
        String sql = "SELECT * FROM teacher WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        Teacher teacher = new Teacher(-1, "teacher not found", "", "");
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("id"));
            String currName = resultSet.getString("first_name");
            String currSurname = resultSet.getString("last_name");
            String currSex = resultSet.getString("sex");
            teacher = new Teacher(currId, currName, currSurname, currSex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        List<Teacher> allTeacher = new ArrayList<>();
        String sql = "SELECT * FROM teacher;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("first_name");
                    String currSurname = resultSet.getString("last_name");
                    String currSex = resultSet.getString("sex");
                    allTeacher.add(new Teacher(currId, currName, currSurname, currSex));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTeacher;
    }

    @Override
    public void insert(Teacher teacher) {
        String sql = "INSERT INTO teacher (first_name, last_name, sex) VALUES (" +
                "'" + teacher.getFirstName() + "', '" + teacher.getLastName() + "', '" + teacher.getSex() + "')";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void update(Teacher teacher, String[] params) {
        String sql = "UPDATE teacher SET (first_name, last_name, sex) = ("
                + "'" + params[0] + "', '" + params[1] + "', '" + params[2] + "') WHERE id = " + teacher.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void delete(Teacher teacher) {
        String sql = "DELETE FROM teacher WHERE id = " + teacher.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void addTeacherToGroup(long teacherId, long groupId) {
        String sql = "INSERT INTO gr_teacher (teacher_id, group_id) VALUES (" +
                "'" + teacherId + "', '" + groupId + "')";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void deleteFromExtraClass (String teacherId, String extraClassId) {
        String sql = "DELETE FROM extra_class_teacher AS ect WHERE ect.teacher_id = " + teacherId + " AND ect.extra_class_id = " + extraClassId;
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void deleteFromGroup(String teacherId, String groupId) {
        String sql = "DELETE FROM gr_teacher AS gt WHERE gt.teacher_id = " + teacherId + " AND gt.group_id = " + groupId;
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public List<Group> getTeacherGroupsByTeacherId(String teacherId) {
        List<Group> allGroup = new ArrayList<>();
        String sql = "SELECT * FROM gr AS g JOIN gr_teacher AS gt ON g.id = gt.group_id JOIN teacher AS t ON t.id = gt.teacher_id WHERE t.id = " + teacherId;
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


}
