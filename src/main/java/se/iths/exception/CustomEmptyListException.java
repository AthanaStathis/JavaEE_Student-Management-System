package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CustomEmptyListException extends WebApplicationException {

    public CustomEmptyListException() {
        super(Response
                .status(Response.Status.NOT_FOUND)
                .entity("Student List Empty!! :O")
                .type(MediaType.TEXT_PLAIN)
                .build()
        );
    }
}
