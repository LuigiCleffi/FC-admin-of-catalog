package com.fullcycle.admin.catalogo.domain.exceptions;

import java.util.List;
import com.fullcycle.admin.catalogo.domain.validation.Error;

public class DomainException extends NoStackTraceException{
    private final List<Error> errors;

    private DomainException(final String aMessage, final List<Error> errors) {
        super(aMessage);
        this.errors = errors;
    }

    public static DomainException with(final Error anError){
        return new DomainException(anError.message(), List.of(anError));
    }

    public static DomainException with(final List<Error> errors){
        return new DomainException("", errors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
