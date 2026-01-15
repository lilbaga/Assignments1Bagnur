import java.time.LocalDate;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Organizer boss = new Organizer("Samat", "Islamov", "IT");
        Event event = new Event("Java Conf", LocalDate.of(2026, 12, 31), boss);

        Participant p1 = new Participant("Saniya", "Masutova", "saniya@mail.ru");
        Participant p2 = new Participant("Anna", "Sayanbekova", "anna@gmail.com");

        event.addParticipant(p1);
        event.addParticipant(p2);

        event.getDaysUntilEvent();
        event.displayInfo();

        // Работа с Базой Данных
        DatabaseManager db = new DatabaseManager();
        try {
            db.saveParticipant(p1);
            db.saveParticipant(p2);
            System.out.println("--- Reading from Database ---");
            db.readParticipants();
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}