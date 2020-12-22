package model.dao;

import model.domain.Child;
import model.domain.ExtraClass;
import model.domain.Teacher;

import java.util.List;

public interface ExtraClassDao extends Dao<ExtraClass> {

    void addChildToExtraClass(long childId, long classId);

    void addTeacherToExtraClass(long teacherId, long classId);

    List<Child> getChildrenByExtraClassId(long classId);

    List<Teacher> getTeachersByExtraClassId(long classId);

}
