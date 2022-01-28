package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    //@Column(name = "STUDENT_FIRST_NAME")
    private String firstName;

    @NotEmpty
    //@Column(name = "STUDENT_LAST_NAME")
    private String lastName;

    @NotEmpty
    //@Column(name = "STUDENT_EMAIL")
    private String email;

    //@Column(name = "STUDENT_PHONE_NUMBER")
    private String phoneNumber;

//    @ManyToMany(mappedBy="students")
//    private List<Subject> subjects = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

//    public void addSubject(Subject subject) {
//        subjects.add(subject);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean hasRequiredFields() {
        return this.getFirstName() != null || this.getLastName() != null || this.getEmail() != null;
    }

//    @JsonbTransient
//    public List<Subject> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(List<Subject> subjects) {
//        this.subjects = subjects;
//    }

}
