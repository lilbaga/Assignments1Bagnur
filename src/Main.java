import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Organizer mainOrganizer = new Organizer("Александр Смирнов", "IT-отдел");
        Event myEvent = new Event("Конференция разработчиков", LocalDate.of(2025, 12, 31), mainOrganizer);

        myEvent.addParticipant(new Participant("Сания", "Масутова", "san@mail.ru"));
        myEvent.addParticipant(new Participant("Анна", "Саянбекова", "anya@mail.ru"));
        myEvent.addParticipant(new Participant("Иван", "Дорн", "ivan_duplicate@mail.ru"));
        myEvent.addParticipant(new Participant("Зарина", "Юсупова", "zarkinzz@mail.ru"));

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Система управления мероприятием ---");
            System.out.println("1. Сколько дней осталось до события?");
            System.out.println("2. Показать список участников");
            System.out.println("3. Найти участника по имени/фамилии");
            System.out.println("4. Проверить наличие дубликатов");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Ошибка: введите число от 1 до 5.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    myEvent.getDaysUntilEvent();
                    break;
                case 2:
                    mainOrganizer.displayOrganizer();
                    myEvent.displayAllParticipants();
                    break;
                case 3:
                    System.out.print("Введите имя или фамилию для поиска: ");
                    String name = scanner.nextLine();
                    myEvent.findParticipantByName(name);
                    break;
                case 4:
                    myEvent.checkForDuplicates();
                    break;
                case 5:
                    System.out.println("Завершение работы программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
        scanner.close();
    }
}