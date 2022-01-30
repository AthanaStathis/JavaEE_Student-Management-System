package se.iths.service;

import se.iths.entity.Subject;
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

// AS ITEMSERVICE
@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        try {
            entityManager.persist(subject);
            return subject;
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public Subject findSubjectById(Long id) {
        try {
            entityManager.find(Subject.class, id);
            return entityManager.find(Subject.class, id);
        }catch (Exception e) {
            throw new CustomNotFoundException();
        }
    }

    public List<Subject> getAllSubjects() {
        List<Subject> allSubjects = entityManager
                .createQuery("SELECT s from Subject s", Subject.class)
                .getResultList();
        if (allSubjects.isEmpty())
            throw new CustomEmptyListException("Subject");
        return allSubjects;
    }

    public void updateSubject(Subject subject) {
        try {
            entityManager.merge(subject);
        }catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public Subject updateSubjectName(Long id, String subjectsNewName) {
        try {
            Subject foundSubject = entityManager.find(Subject.class, id);
            foundSubject.setName(subjectsNewName);
            return entityManager.merge(foundSubject);
        }
        catch (Exception e) {
            throw new CustomBadRequestException();
        }
    }

    public void deleteSubject(Long id) {
        Subject subjectToBeDeleted = entityManager.find(Subject.class, id);
        if (subjectToBeDeleted == null)
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Couldn't delete Subject. Subject with id "+ id +" doesn't exist in database " +":( ")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        entityManager.remove(subjectToBeDeleted);
    }

}
