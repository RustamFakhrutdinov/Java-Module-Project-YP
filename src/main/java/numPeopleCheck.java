import java.util.Scanner;

public class numPeopleCheck {// класс, который проверяет количество человек, на которых нужно разделить счет
    int checkStart() {
        System.out.println("Здравствуйте! На сколько человек необходимо разделить счёт?");
        int billCount;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                billCount = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не целое число. Пожалуйста, введите целое значение");
                continue;
            }
            if (billCountCheck(billCount)) {
                break;
            }
        }
        return billCount;
    }
    boolean billCountCheck(int billCount) {
        boolean flag = false;
        if (billCount < 1) {
            System.out.println("Невозможно разделить счет на количество человек меньших 1. Пожалуйста, введите значение еще раз.");
        } else if (billCount == 1) {
            System.out.println("Нет смысла делить счет на одного человека. Пожалуйста, введите значение еще раз.");
        } else {
            System.out.println("Отлично, вы хотите разделить счет на " + billCount + " " + padejForChelovek(billCount));
            flag = true;
        }
        return flag;
    }
    String padejForChelovek(int billCount) {
        String name;
        if (billCount % 10 == 2 || billCount % 10 == 3 || billCount % 10 == 4) {
            name = "человека";
        } else {
            name = "человек";
        }
        return name;
    }
}
