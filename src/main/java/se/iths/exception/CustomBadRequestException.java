package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CustomBadRequestException extends WebApplicationException {
    public CustomBadRequestException() {
        super(Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Bad Request :( Check the info you send ;)")
                .type(MediaType.TEXT_PLAIN)
                .build()
        );
    }
}
