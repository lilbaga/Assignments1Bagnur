import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Organizer boss = new Organizer("Samat", "Islamov", "IT");
        Event event = new Event("Java Conf", LocalDate.of(2026, 12, 31), boss);

        event.addParticipant(new Participant("Saniya", "Masutova", "saniya@mail.ru"));
        event.addParticipant(new Participant("Anna", "Sayanbekova", "anna@gmail.com"));

        event.getDaysUntilEvent();
        event.sortParticipants();
        event.displayInfo();
    }
}