package se.iths.Util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        Student student1 =  new Student("Aris","Liapis","aris.liapis@email.com",
                "210-5231212");
        Student student2 =  new Student("Ioannis", "Latremenos", "ioannis.latremenos@email.com",
                "210-5326555");
        Student student3 =  new Student("Nasos", "Gliatas", "nasos.gliatas@email.com",
                "");
        Student student4 =  new Student("Giorgos", "Proklos", "giorgos.proklos@email.com",
                "210-4321367");

        Teacher teacher1 = new Teacher("Manos", "Chatzidakis");
        Teacher teacher2 = new Teacher("Anders", "Nordlund");

        Subject subject1 = new Subject("Nuclear Engineering", "Engineering Physics");
        Subject subject2 = new Subject("Numerical Analysis", "Mathematics");
        Subject subject3 = new Subject("Sociology of Science", "Humanitarian Sciences");

        subject1.addStudent(student1);
        subject1.addStudent(student2);
        subject1.addStudent(student3);

        subject2.addStudent(student3);

        subject3.addStudent(student4);
        subject3.addStudent(student2);

        teacher1.addSubject(subject3);
        teacher2.addSubject(subject1);
        teacher2.addSubject(subject2);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
    }



}

