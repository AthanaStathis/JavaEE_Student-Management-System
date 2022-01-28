package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// AS USERSERVICE
@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher createTeacher(Teacher teacher) {
        teacher.addSubject(new Subject("History I", "Humanitarian Sciences"));
        teacher.addSubject(new Subject("History II", "Humanitarian Sciences"));
        teacher.addSubject(new Subject("History IV", "Humanitarian Sciences"));

        entityManager.persist(teacher);
        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();
    }

    public Teacher updateLastName(Long id, String name) {
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        foundTeacher.setLastName(name);
        return foundTeacher;
    }

    public void deleteTeacher(Long id) {
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(foundTeacher);
    }
}
