import java.util.Scanner;

// Класс комнаты
class Room {
    private String description;
    private String[] actions;

    public Room(String description, String[] actions) {
        this.description = description;
        this.actions = actions;
    }

    public void displayDescription() {
        System.out.println(description);
    }

    public String[] getActions() {
        return actions;
    }
}

// Класс игры
public class ${NAME} {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в подземное царство!");
        System.out.println("Вы находитесь в комнате с тремя дверями. В какую дверь вы пойдете? (1, 2 или 3)");

        int doorChoice = scanner.nextInt();
        scanner.nextLine(); // Переход на следующую строку после ввода числа

        Room[] rooms = createRooms(); // Создание комнат

        if (doorChoice >= 1 && doorChoice <= 3) {
            Room currentRoom = rooms[doorChoice - 1];
            currentRoom.displayDescription();

            while (true) {
                String[] actions = currentRoom.getActions();
                for (int i = 0; i < actions.length; i++) {
                    System.out.println((i + 1) + ". " + actions[i]);
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Переход на следующую строку после ввода числа

                if (choice >= 1 && choice <= actions.length) {
                    performAction(actions[choice - 1]); // Выполнение действия в комнате
                } else if (choice == 0) {
                    System.out.println("Игра завершена.");
                    break;
                } else {
                    System.out.println("Недопустимый выбор.");
                }
            }
        } else {
            System.out.println("Вы выбрали неправильное число. Игра закончена.");
        }

        scanner.close();
    }

    // Метод для обработки выбранного действия в комнате
    public static void performAction(String action) {
        switch (action) {
            case "лестница":
                System.out.println("Вы спустились вниз и нашли сокровища! Поздравляем, вы выиграли!");
                break;
            case "сундук":
                System.out.println("Сундук был заперт. Вы идете обратно.");
                break;
            case "включить фонарь":
                System.out.println("Фонарь загорелся, и вы увидели выход из пещеры! Поздравляем, вы выбрались!");
                break;
            case "идти вперед":
                System.out.println("Вы потерялись во тьме. Игра закончена.");
                break;
            case "левая":
                System.out.println("Вы нашли выход! Поздравляем, вы выбрались!");
                break;
            case "правая":
                System.out.println("Это была ловушка! Игра закончена.");
                break;
            case "ключ":
                System.out.println("Вы взяли ключ. Теперь выберите дверь для открытия ('левая' или 'правая').");
                break;
            default:
                System.out.println("Недопустимый выбор.");
        }
    }

    // Создание комнат и их описаний
    public static Room[] createRooms() {
        String[] actionsRoom1 = { "лестница", "сундук" };
        Room room1 = new Room("Вы вошли в первую комнату. Вы видите лестницу вниз и сундук.", actionsRoom1);

        String[] actionsRoom2 = { "включить фонарь", "идти вперед" };
        Room room2 = new Room("Вы вошли во вторую комнату. Здесь темно и вы слышите шум.", actionsRoom2);

        String[] actionsRoom3 = { "левая", "правая", "ключ" };
        Room room3 = new Room("Вы в третьей комнате. Здесь есть ключ на столе и две двери: 'левая' и 'правая'.", actionsRoom3);

        Room[] rooms = { room1, room2, room3 };
        return rooms;
    }
}