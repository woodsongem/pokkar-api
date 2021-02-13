package org.cana.handlers.exceptions;

import org.cana.resources.models.ErrorMessageModel;

import javax.inject.Provider;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@javax.ws.rs.ext.Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {
    @Context
    private Provider<Request> request;

    @Context
    private Configuration config;

    @Override
    public Response toResponse(final ValidationException exception) {
        final List<Variant> variants = Variant.mediaTypes(MediaType.APPLICATION_XML_TYPE, MediaType.APPLICATION_JSON_TYPE).build();
       // final Variant variant = this.request.get().selectVariant(variants);
        final Response.ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST);
//        if (variant != null) {
//            response.type(variant.getMediaType());
//        }
//        else
//        {
//            response.type(MediaType.APPLICATION_JSON_TYPE);
//        }

        response.type(MediaType.APPLICATION_JSON_TYPE);

        if (exception instanceof ConstraintViolationException) {
            List<ErrorMessageModel> errorMessageModels = new ArrayList<>();
            final ConstraintViolationException cve = (ConstraintViolationException) exception;
            final Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();
            for (final ConstraintViolation<?> violation : violations) {
                errorMessageModels.add(new ErrorMessageModel(violation.getMessage()));
            }
            response.entity(new GenericEntity<>(errorMessageModels, new GenericType<List<ErrorMessageModel>>() {
            }.getType()));
            return response.build();
        }
        return Response.serverError().entity(exception.getMessage()).build();
    }
}
