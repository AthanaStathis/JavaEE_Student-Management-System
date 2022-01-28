package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// AS ITEMSERVICE
@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s from Subject s", Subject.class).getResultList();
    }

    public void updateSubject(Subject item) {
        entityManager.merge(item);
    }

    public Subject updateName(Long id, String name) {
        Subject foundSubject = entityManager.find(Subject.class, id);
        foundSubject.setName(name);
        return foundSubject;
    }

    public void deleteSubject(Long id) {
        Subject foundSubject = entityManager.find(Subject.class, id);
        entityManager.remove(foundSubject);
    }

}
