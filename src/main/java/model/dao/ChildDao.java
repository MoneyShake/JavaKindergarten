package model.dao;

import model.domain.Child;

public interface ChildDao extends Dao<Child> {
    void deleteFromExtraClass (String childId, String extraClassId);
}
