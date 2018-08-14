package org.itstep.javaee.hotel.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7501841894817917239L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(String msg, Exception e) {
        super(msg, e);
    }
}
