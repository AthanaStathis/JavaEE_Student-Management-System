package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.lang.String.format;


public class CustomNotFoundException extends WebApplicationException {
    public CustomNotFoundException () {
        super(Response
                .status(Response.Status.NOT_FOUND)
                .entity("Student not found :(")
                .type(MediaType.TEXT_PLAIN)
                .build());
    }
}
