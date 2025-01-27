package de.adorsys.multibanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    value = HttpStatus.BAD_REQUEST,
    code = HttpStatus.BAD_REQUEST,
    reason = "SELECT_CONSENT_AUTHORISATION"
)
public class MissingConsentAuthorisationSelectionException extends ParametrizedMessageException {
    public MissingConsentAuthorisationSelectionException() {
        super("Select SCA Method");
    }
}
