public class Organizer {
    private String name;
    private String department;

    public Organizer(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void displayOrganizer() {
        System.out.println("Организатор: " + name + " из отдела " + department);
    }
}