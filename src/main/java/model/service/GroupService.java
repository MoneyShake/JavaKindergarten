package model.service;

import model.dao.GroupDao;
import model.dao.jdbcImplementation.JDBCGroupDao;
import model.domain.Child;
import model.domain.Group;
import model.domain.Teacher;

import java.util.List;

public class GroupService {

    private final GroupDao groupDao;

    public GroupService() {
        this.groupDao = new JDBCGroupDao();
    }

    public Group getById(Long id) {
        return groupDao.get(id);
    }

    public List<Group> getAll() {
        return groupDao.getAll();
    }

    public void insert(String[] params) {
        Group group = new Group(-1, params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        groupDao.insert(group);
    }

    public void update(long id, String[] params) {
        groupDao.update(getById(id), params);
    }

    public void delete(long id) {
        groupDao.delete(getById(id));
    }

    public List<Child> getChildrenByGroupId(long id) {
        return groupDao.getChildByGroupId(id);
    }

    public List<Teacher> getTeachersByGroupId(long id) {
        return groupDao.getTeachersByGroupId(id);
    }

}
