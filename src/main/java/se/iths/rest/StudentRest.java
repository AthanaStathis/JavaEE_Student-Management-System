package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exception.CustomBadRequestException;
import se.iths.exception.CustomEmptyListException;
import se.iths.exception.CustomNotFoundException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("")
    @GET
    public Response getAll() {
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        return Response.ok(foundStudent).build();
    }

    @Path("lastname")
    @GET
    public Response getStudentLastName(@QueryParam("lastName") String lastName) {
        List<Student> studentList = studentService.findByLastName(lastName);
        return Response.status(Response.Status.FOUND).entity(studentList).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudentById(@PathParam("id") Long id) {
        studentService.deleteStudentById(id);
        return Response.ok().build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("update/first-name/{id}")
    @PATCH
    public Response updateFirstName(@PathParam("id") Long id, @QueryParam("firstName") String firstName) {
        Student updatedStudent = studentService.updateFirstName(id, firstName);
        return Response.ok(updatedStudent).build();
    }


}
