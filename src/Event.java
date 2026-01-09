import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Event {
    private String title;
    private LocalDate eventDate;
    private Organizer organizer;
    private List<Participant> participantList;

    public Event(String title, LocalDate eventDate, Organizer organizer) {
        this.title = title;
        this.eventDate = eventDate;
        this.organizer = organizer;
        this.participantList = new ArrayList<>();
    }

    public void addParticipant(Participant p) {
        participantList.add(p);
    }

    public void sortParticipants() {
        participantList.sort(Comparator.comparing(Person::getLastName));
    }

    public void findParticipant(String name) {
        boolean found = false;
        for (Participant p : participantList) {
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
                found = true;
            }
        }
        if (!found) System.out.println("Not found.");
    }

    public void getDaysUntilEvent() {
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), eventDate);
        System.out.println("Days until " + title + ": " + (daysBetween < 0 ? "Expired" : daysBetween));
    }

    public void displayInfo() {
        System.out.println("\nEvent: " + title);
        organizer.displayRole();
        System.out.println("Participants:");
        for (Participant p : participantList) {
            System.out.println("- " + p);
        }
    }
}