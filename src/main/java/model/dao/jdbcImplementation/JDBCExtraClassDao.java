package model.dao.jdbcImplementation;

import model.DatabaseUtils;
import model.dao.ExtraClassDao;
import model.domain.Child;
import model.domain.ExtraClass;
import model.domain.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCExtraClassDao implements ExtraClassDao {
    @Override
    public ExtraClass get(long id) {
        String sql = "SELECT * FROM extra_class WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        ExtraClass extraClass = new ExtraClass(-1, "group not found", "");
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("id"));
            String currName = resultSet.getString("class_name");
            String description = resultSet.getString("description");
            extraClass = new ExtraClass(currId, currName, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraClass;
    }

    @Override
    public List<ExtraClass> getAll() {
        List<ExtraClass> allExtra = new ArrayList<>();
        String sql = "SELECT * FROM extra_class;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("class_name");
                    String description = resultSet.getString("description");
                    allExtra.add(new ExtraClass(currId, currName, description));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allExtra;
    }

    @Override
    public void insert(ExtraClass extraClass) {
        String sql = "INSERT INTO extra_class (class_name, description) VALUES (" +
                "'" + extraClass.getName() + "', '" + extraClass.getDescription() + "')";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void update(ExtraClass extraClass, String[] params) {
        String sql = "UPDATE extra_class SET (class_name, description) = ("
                + "'" + params[0] + "', '" + params[1] + "') WHERE id = " + extraClass.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void delete(ExtraClass extraClass) {
        String sql = "DELETE FROM extra_class WHERE id = " + extraClass.getId();
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void addChildToExtraClass(long childId, long classId) {
        String sql = "INSERT INTO extra_class_child (child_id, extra_class_id) VALUES (" +
                "'" + childId + "', '" + classId + "')";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public void addTeacherToExtraClass(long teacherId, long classId) {
        String sql = "INSERT INTO extra_class_teacher (teacher_id, extra_class_id) VALUES (" +
                "'" + teacherId + "', '" + classId + "')";
        DatabaseUtils.getInstance().update(sql);
    }

    @Override
    public List<Child> getChildrenByExtraClassId(long classId) {
        List<Child> allChildInExtraClass = new ArrayList<>();
        String sql = "SELECT c.id AS id, c.first_name AS first_name, c.last_name AS last_name, c.sex AS sex, c.group_id AS group_id FROM child AS c JOIN extra_class_child AS ecc ON c.id = ecc.child_id JOIN extra_class AS ec ON ec.id = ecc.extra_class_id WHERE ec.id = " + classId;
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
                    allChildInExtraClass.add(new Child(currId, currName, currSurname, currSex, currGroupId, age));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allChildInExtraClass;
    }

    @Override
    public List<Teacher> getTeachersByExtraClassId(long classId) {
        List<Teacher> allTeachersInExtraClass = new ArrayList<>();
        String sql = "SELECT t.id AS id, t.first_name AS first_name, t.last_name AS last_name, t.sex AS sex FROM teacher AS t JOIN extra_class_teacher AS ect ON t.id = ect.teacher_id JOIN extra_class AS ec ON ec.id = ect.extra_class_id WHERE ec.id = " + classId;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("id"));
                    String currName = resultSet.getString("first_name");
                    String currSurname = resultSet.getString("last_name");
                    String currSex = resultSet.getString("sex");
                    allTeachersInExtraClass.add(new Teacher(currId, currName, currSurname, currSex));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTeachersInExtraClass;
    }
}
