import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Event {
    private String title;
    private LocalDate eventDate;
    private Organizer organizer;
    private ArrayList<Participant> participantList;

    public Event(String title, LocalDate eventDate, Organizer organizer) {
        this.title = title;
        this.eventDate = eventDate;
        this.organizer = organizer;
        this.participantList = new ArrayList<>();
    }

    public void addParticipant(Participant p) {
        participantList.add(p);
    }

    public void getDaysUntilEvent() {
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), eventDate);
        if (daysBetween < 0) {
            System.out.println("Мероприятие '" + title + "' уже прошло.");
        } else {
            System.out.println("До мероприятия '" + title + "' осталось дней: " + daysBetween);
        }
    }

    public void displayAllParticipants() {
        System.out.println("\n--- Список всех участников ---");
        for (Participant p : participantList) {
            System.out.println(p);
        }
    }

    public void findParticipantByName(String searchName) {
        boolean found = false;
        for (Participant p : participantList) {
            if (p.getFirstName().equalsIgnoreCase(searchName) || p.getLastName().equalsIgnoreCase(searchName)) {
                System.out.println("Найден участник: " + p);
                found = true;
            }
        }
        if (!found) System.out.println("Участник с именем \"" + searchName + "\" не найден.");
    }

    public void checkForDuplicates() {
        System.out.println("\nПроверка списка на дубликаты...");
        boolean hasDuplicates = false;
        for (int i = 0; i < participantList.size(); i++) {
            for (int j = i + 1; j < participantList.size(); j++) {
                if (participantList.get(i).equals(participantList.get(j))) {
                    System.out.println("! Внимание: найден дубликат: " + participantList.get(i));
                    hasDuplicates = true;
                }
            }
        }
        if (!hasDuplicates) System.out.println("Дубликатов не обнаружено.");
    }
}