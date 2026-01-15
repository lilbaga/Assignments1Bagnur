import java.util.Objects;

public class Organizer extends Person {
    private String department;

    public Organizer(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public void displayRole() {
        System.out.println("Role: Organizer, Dept: " + department);
    }

    @Override
    public String toString() {
        return super.toString() + " [Organizer: " + department + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Organizer organizer = (Organizer) o;
        return Objects.equals(department, organizer.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}