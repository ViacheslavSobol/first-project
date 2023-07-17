package main;

import java.util.Scanner;

/**
 * Приложение должно предоставлять следующую функциональность:
 * 1. консольный интерфейс для управления программой;
 * 2. хранение данных о количестве пройденных шагов за несколько месяцев;
 * 3. ввод цели по количеству шагов в день;
 * 4. ввод пройденного количества шагов за день;
 * 5. вывод статистики за определённый месяц.
 */

public class Main {
    public static void main(String[] args) throws ProgramException {
        int command;
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();

        while (true) {
            System.out.println(MenuChoice.ACTION_MAIN_MENU.getValue());

            command = scanner.nextInt();
            if (command == 1) {
                utils.addGoal(scanner.nextInt());
            } else if (command == 2) {
                System.out.println(MenuChoice.DATA_GET_DATE.getValue());
                String date = scanner.next();
                System.out.println(MenuChoice.DATA_GET_STEP.getValue());
                Integer step = scanner.nextInt();
                utils.addSteps(date, step);
            } else if (command == 3) {
                if (utils.goal == 0) {
                    System.out.println("Необходимо сначала ввести целевое количество шагов - пункт 1.");
                    continue;
                }
                utils.getStats();
            } else if (command == 4) {
                break;
            }
        }
    }
}