/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.exception;

/**
 *
 * @author pauloborges
 */
public class EmailAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public EmailAlreadyExistException() {
        super();
    }

    public EmailAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyExistException(final String message) {
        super(message);
    }

    public EmailAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}