package model.service;

import model.dao.ExtraClassDao;
import model.dao.jdbcImplementation.JDBCExtraClassDao;
import model.domain.Child;
import model.domain.ExtraClass;
import model.domain.Teacher;

import java.util.List;

public class ExtraClassService {

    private final ExtraClassDao extraClassDao;

    public ExtraClassService() {
        this.extraClassDao = new JDBCExtraClassDao();
    }

    public void insert(String[] params) {
        ExtraClass extraClass = new ExtraClass(-1, params[0], params[1]);
        extraClassDao.insert(extraClass);
    }

    public ExtraClass getById(long id) {
        return extraClassDao.get(id);
    }

    public List<ExtraClass> getAll() {
        return extraClassDao.getAll();
    }

    public void update(long id, String[] params){
        extraClassDao.update(getById(id), params);
    }

    public void delete(long id) {
        extraClassDao.delete(getById(id));
    }

    public void addTeacherToExtraClass(String teacherId, String classId) {
        extraClassDao.addTeacherToExtraClass(Long.parseLong(teacherId), Long.parseLong(classId));
    }

    public void addChildToExtraClass(String childId, String classId) {
        extraClassDao.addChildToExtraClass(Long.parseLong(childId), Long.parseLong(classId));
    }

    public List<Child> getChildrenByExtraClassId(String classId) {
        return extraClassDao.getChildrenByExtraClassId(Long.parseLong(classId));
    }

    public List<Teacher> getTeachersByExtraClassId(String classId) {
        return extraClassDao.getTeachersByExtraClassId(Long.parseLong(classId));
    }


}
