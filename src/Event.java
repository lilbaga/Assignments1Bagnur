import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Event {
    private String title;
    private LocalDate date;
    private Organizer organizer;
    private List<Participant> participants;

    public Event(String title, LocalDate date, Organizer organizer) {
        this.title = title;
        this.date = date;
        this.organizer = organizer;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public void getDaysUntilEvent() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), date);
        System.out.println("Days until " + title + ": " + days);
    }

    public void sortParticipants() {
        participants.sort(Comparator.comparing(Person::getLastName));
    }

    public void displayInfo() {
        System.out.println("Event: " + title + " | Organizer: " + organizer);
        for (Participant p : participants) {
            p.displayRole();
        }
    }
}