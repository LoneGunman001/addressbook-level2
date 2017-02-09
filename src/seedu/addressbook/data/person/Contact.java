package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in respective link
 */
public class Contact {
    public final String value;
    
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String messageContactConstraints, String contactValidationRegex) throws IllegalValueException {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedContact, contactValidationRegex)) {
            throw new IllegalValueException(messageContactConstraints);
        }
        this.value = trimmedContact;
    }

    @Override
    public String toString() {
        return value;
    }
    
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidContact(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}