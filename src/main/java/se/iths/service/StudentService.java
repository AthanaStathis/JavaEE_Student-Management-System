package se.iths.service;

import se.iths.entity.Student;
import se.iths.exception.CustomBadRequestException;
import se.iths.exception.CustomEmptyListException;
import se.iths.exception.CustomNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        try {
            entityManager.persist(student);
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = entityManager
                .createQuery("SELECT i from Student i", Student.class)
                .getResultList();
        if (allStudents.isEmpty())
            throw new CustomEmptyListException("Student");
        return allStudents;
    }

    public Student findStudentById(Long id) {
        try {
            entityManager.find(Student.class, id);
        }catch (Exception e) {
            throw new CustomNotFoundException();
        }
        return entityManager.find(Student.class, id);
    }

    public List<Student> findByLastName(String lastName) {
        List<Student> foundStudent = entityManager.createQuery("SELECT s from Student s " +
                "where s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
        if (foundStudent.isEmpty())
            throw new CustomEmptyListException("Student");
        return foundStudent;
    }

    public void deleteStudentById(Long id) {
        Student studentToBeDeleted = entityManager.find(Student.class, id);
        if (studentToBeDeleted == null)
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Couldn't delete Student. Student with id "+ id +" doesn't exist in database " +":( ")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        entityManager.remove(studentToBeDeleted);
    }

    public void updateStudent(Student student) {
        try {
            entityManager.merge(student);
        }catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public Student updateFirstName(Long id, String name) {
        try {
            Student foundStudent = entityManager.find(Student.class, id);
            foundStudent.setFirstName(name);
            return entityManager.merge(foundStudent);
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }
}
