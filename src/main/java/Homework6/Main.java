package Homework6;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook();
        notebook1.tradeMark = "Acer";
        notebook1.processorSequence = 2.4;
        notebook1.screenSize = 15;
        notebook1.ram = 8;
        notebook1.ssd = 256;
        notebook1.colour = "Black";
        notebook1.system = "Windows";

        Notebook notebook2 = new Notebook();
        notebook2.tradeMark = "Asus";
        notebook2.processorSequence = 3.2;
        notebook2.screenSize = 19;
        notebook2.ram = 16;
        notebook2.ssd = 512;
        notebook2.colour = "Dark grey";
        notebook2.system = "Windows";

        Notebook notebook3 = new Notebook();
        notebook3.tradeMark = "Mac";
        notebook3.processorSequence = 3.0;
        notebook3.screenSize = 17;
        notebook3.ram = 8;
        notebook3.ssd = 1024;
        notebook3.colour = "White";
        notebook3.system = "Linux";

        Notebook notebook4 = new Notebook();
        notebook4.tradeMark = "Hp";
        notebook4.processorSequence = 2.8;
        notebook4.screenSize = 12;
        notebook4.ram = 2;
        notebook4.ssd = 128;
        notebook4.colour = "Red";
        notebook4.system = "Linux";

        Set<Notebook> laptops = new HashSet<>();
        laptops.add(notebook1);
        laptops.add(notebook2);
        laptops.add(notebook3);
        laptops.add(notebook4);

        System.out.println("Выберите критерии для поиска:");
        System.out.println("1 - Диагональ экрана");
        System.out.println("2 - Оперативная память");
        System.out.println("3 - Цвет");
        System.out.println("4 - Операционная система");
        System.out.println("0 - Завершить выбор и начать поиск" + "\n");

        Scanner scanner = new Scanner(System.in);
        int choice;
        Map<String, Object> choiceResult = new HashMap<>();

        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Минимальная диагональ экрана?");
                    choiceResult.put("Screen Size", scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Минимальный объем оперативной памяти?");
                    choiceResult.put("RAM", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Выберите цвет: Black, Dark Grey, Red, White");
                    choiceResult.put("Colour", scanner.next());
                    break;
                case 4:
                    System.out.println("Выберите операционную систему: Windows, Linux.");
                    choiceResult.put("Operational system", scanner.next());
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

        }
        Set<Notebook> findByDemand = laptops.stream()
                .filter(laptop -> choiceResult.getOrDefault("Screen Size", 0) instanceof Double
                        && laptop.screenSize >= (double) choiceResult.getOrDefault("Screen Size", 0))
                .filter(laptop -> choiceResult.getOrDefault("RAM", 0) instanceof Integer
                        && laptop.ram >= (int) choiceResult.getOrDefault("RAM", 0))
                .filter(laptop -> choiceResult.getOrDefault("Colour", "").equals("")
                        || laptop.colour.equalsIgnoreCase((String) choiceResult.getOrDefault("Colour", "")))
                .filter(laptop -> choiceResult.getOrDefault("Operational system", "").equals("")
                        || laptop.system.equalsIgnoreCase((String) choiceResult.getOrDefault("Operational system", "")))
                .collect(Collectors.toSet());

        System.out.println("Результат поиска:");
        for (Notebook laptop : findByDemand) {
            System.out.println(laptop);
        }

    }

}
