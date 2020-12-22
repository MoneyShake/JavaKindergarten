package model.dao;

import model.domain.Child;
import model.domain.Group;
import model.domain.Teacher;

import java.util.List;

public interface GroupDao extends Dao<Group> {

    List<Child> getChildByGroupId(long id);

    List<Teacher> getTeachersByGroupId(long id);
}
