package model.dao;

import model.domain.Group;
import model.domain.Teacher;

import java.util.List;

public interface TeacherDao extends Dao<Teacher> {

    void addTeacherToGroup(long teacherId, long groupId);
    void deleteFromExtraClass (String teacherId, String extraClassId);
    void deleteFromGroup (String teacherId, String groupId);
    List<Group> getTeacherGroupsByTeacherId (String teacherId);
}
