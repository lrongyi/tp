package seedu.address.model.appointment.exceptions;

import seedu.address.model.person.Person;

/**
 * Signals that the operation will result in duplicate Appointments
 * (Appointments are considered duplicates if they have the same identity).
 */
public class DuplicateAppointmentException extends RuntimeException {
    public DuplicateAppointmentException(Person person) {
        super(String.format("Existing appointment for %s encountered", person.getName().toString()));
    }
}
