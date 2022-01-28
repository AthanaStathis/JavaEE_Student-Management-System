package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

// AS ITEM
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    //@Column(name = "SUBJECT_NAME")
    private String name;

    @NotEmpty
    //@Column(name = "SUBJECT_CATEGORY")
    private String category;

    @ManyToOne
    @JoinColumn(name="SUBJ_ID")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name="SUBJ_STUD",
            joinColumns=@JoinColumn(name="SUBJ_ID"),
            inverseJoinColumns=@JoinColumn(name="STUD_ID"))
    private List<Student> students = new ArrayList<>();

    public Subject(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Subject() {}

    public void addStudent(Student student) {
        students.add(student);
    }

    //    @JsonbTransient
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Student> getStudents() {
        return students;
    }

}
