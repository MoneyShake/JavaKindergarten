package model.service;

import model.dao.ChildDao;
import model.dao.jdbcImplementation.JDBCChildDao;
import model.domain.Child;

import java.util.List;

public class ChildService {

    private final ChildDao childDao;

    public ChildService() {
        this.childDao = new JDBCChildDao();
    } //для возможности изменять реализацию(к примеру брать детей из файла)

    public Child getById(long id) {
        return childDao.get(id);
    }

    public List<Child> getAll() {
        return childDao.getAll();
    }

    public void insert(String[] params) {
        Child child = new Child(-1, params[0], params[1], params[2], Long.parseLong(params[3]), Integer.parseInt(params[4]));
        childDao.insert(child);
    }

    public void update(long id, String[] params){
        childDao.update(getById(id), params);
    }

    public void delete(long id){
        childDao.delete(getById(id));
    }

    public void deleteFromExtraClass(String childId, String extraClassId) {
         childDao.deleteFromExtraClass(childId, extraClassId);
    }
}
