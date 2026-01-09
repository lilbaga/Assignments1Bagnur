import java.util.Objects;

public class Participant extends Person {
    private String email;

    public Participant(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Participant, Email: " + email);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Participant that = (Participant) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}