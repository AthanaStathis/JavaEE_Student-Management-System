package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.CustomBadRequestException;
import se.iths.exception.CustomEmptyListException;
import se.iths.exception.CustomNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// AS USERSERVICE
@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id) {
        try {
            return entityManager.find(Teacher.class, id);
        }catch (Exception e) {
            throw new CustomNotFoundException();
        }
    }

    public Teacher createTeacher(Teacher teacher) {
        try {
            entityManager.persist(teacher);
            return teacher;
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public void updateTeacher(Teacher teacher) {
        try {
            entityManager.merge(teacher);
        }catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> allTeachers = entityManager
                .createQuery("SELECT t from Teacher t", Teacher.class)
                .getResultList();
        if (allTeachers.isEmpty())
            throw new CustomEmptyListException("Teacher");
        return allTeachers;
    }

    public Teacher updateLastName(Long id, String name) {
        try {
            Teacher foundTeacher = entityManager.find(Teacher.class, id);
            foundTeacher.setLastName(name);
            return entityManager.merge(foundTeacher);
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public void deleteTeacherById(Long id) {
        Teacher teacherToBeDeleted = entityManager.find(Teacher.class, id);
        if (teacherToBeDeleted == null)
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Couldn't delete Teacher. Teacher with id "+ id +" doesn't exist in database " +":( ")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        entityManager.remove(teacherToBeDeleted);
    }
}
