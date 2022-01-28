package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

// AS USER
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "TEACHER_ID")
    private Long id;

    @NotEmpty
    //@Column(name = "TEACHER_FIRST_NAME")
    private String firstName;

    @NotEmpty
    //@Column(name = "TEACHER_LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonbTransient
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
