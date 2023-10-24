import java.util.Scanner;
public class Calculator {
    String productList = "";
    double sum = 0;

    void calculatorStart() { //начало работы калькулятор
        int peopleCount;
        numPeopleCheck check = new numPeopleCheck();
        peopleCount = check.checkStart();
        Scanner scanner = new Scanner(System.in);
        double price;
        boolean flag = true;// флаг, который позволяет при некорректном вводе стоимости снова ввести
                                            //стоимость товара, не вводя  снова его название
        while(true) {
            if (flag) {
               getName();
            }

            System.out.println("Введите стоимость товара в формте '00,00':");
            flag = true;

            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price < 0) {
                    System.out.println("Цена не может быть отрицательной. Повторите ввод");
                    flag = false;
                    continue;
                }
            } else {
                System.out.println("Не верный формат. Пожалуйста, повторите ввод стоимости");
                scanner.nextLine();
                flag = false;
                continue;
            }
            System.out.println("Товар успешно добавлен!");
            sum += price;
            if (checkEnd()) {
                break;
            }
            productList += "\n";
        }
        finalOutput(peopleCount, sum);
    }
   void getName() { //метод добавления товара
        Scanner scanner = new Scanner(System.in);
        String productName;
        System.out.println("Введите назвние товара");
        productName = scanner.nextLine();
        productList += productName;
    }
    boolean checkEnd() {//метод, проверяющий на завершение
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Если хотите завершить ввод товаров, напишите 'Завершить'. Для продолжения введите любой символ");
        if (scanner.nextLine().equalsIgnoreCase("Завершить")) {
            flag = true;
        }
        return flag;
    }

    void finalOutput(int peopleCount, double sum) {//метод, выводящий итог
        System.out.println("Добавленные товары:");
        System.out.println(productList);
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", sum/peopleCount) +" " + padejForRubles(sum/peopleCount));
    }

    String padejForRubles(double billForMan) {// метод, склоняющий слово "рубль"
        String name;
        double billForManFloor = Math.floor(billForMan);
        if (billForManFloor % 100 > 4 && billForManFloor % 100 < 21) {
            name = "рублей";
        } else if (billForManFloor % 10 == 1){
            name = "рубль";
        } else if ((billForManFloor % 10 > 4 && billForManFloor % 10 <= 9) || billForManFloor == 0){
            name = "рублей";
        } else {
            name = "рубля";
        }
        return name;
    }
}


