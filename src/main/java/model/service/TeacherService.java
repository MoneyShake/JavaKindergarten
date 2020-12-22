package model.service;

import model.dao.jdbcImplementation.JDBCTeacherDao;
import model.dao.TeacherDao;
import model.domain.Child;
import model.domain.Group;
import model.domain.Teacher;

import java.util.List;

public class TeacherService {

    private final TeacherDao teacherDao;

    public TeacherService() {
        this.teacherDao = new JDBCTeacherDao();
    }

    public Teacher getById(long id) {
        return teacherDao.get(id);
    }

    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    public void insert(String[] params) {
        Teacher teacher = new Teacher(-1, params[0], params[1], params[2]);
        teacherDao.insert(teacher);
    }
    public void update(long id, String[] params){
        teacherDao.update(getById(id), params);
    }

    public void delete(long id) {
        teacherDao.delete(getById(id));
    }

    public void addTeacherToGroup(String teacherId, String groupId) {
        teacherDao.addTeacherToGroup(Long.parseLong(teacherId), Long.parseLong(groupId));
    }

    public void deleteFromExtraClass(String teacherId, String extraClassId) {
        teacherDao.deleteFromExtraClass(teacherId, extraClassId);
    }

    public void deleteFromGroup(String teacherId, String groupId) {
        teacherDao.deleteFromGroup(teacherId, groupId);
    }

    public List<Group> getTeacherGroupsByTeacherId (String teacherId){
        return teacherDao.getTeacherGroupsByTeacherId(teacherId);
    }
}
