import java.util.Objects;

public class Participant {
    private String firstName;
    private String lastName;
    private String email;

    public Participant(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant other = (Participant) obj;

        return firstName.equalsIgnoreCase(other.firstName) &&
                lastName.equalsIgnoreCase(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")";
    }
}