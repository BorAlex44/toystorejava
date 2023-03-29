package toystore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static toystore.IdGenerator.createId;

public class ToyStore {
    public static void main(String[] args) {
        menuToyStore();

    }

    public static void menuToyStore() {
        Scanner in = new Scanner(System.in);
        List<Toy> toyList = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Выберите действие:
                    1 - Добавить игрушку в базу
                    2 - Показать все игрушки
                    3 - Изменить вес игрушки для розыгрыша
                    4 - Розыгрыш игрушки
                    0 - Выход""");
            String choice = in.nextLine();
            switch (choice) {
                case "1" -> {
                    UUID id = createId();
                    System.out.println("Введите название игрушки: ");
                    Scanner sc = new Scanner(System.in);
                    String nameToy = sc.nextLine().toUpperCase();
                    System.out.println("Введите цену игрушки: ");
                    double priceToy = sc.nextDouble();
                    System.out.println("Введите вес игрушки для розыгрыша: ");
                    int weightToy = sc.nextInt();
                    Toy newToy = new Toy(id, nameToy, priceToy, weightToy);
                    toyList.add(newToy);
                }
                case "2" -> {
                    for (Toy toy : toyList) {
                        toy.printInfo();

                    }
                }
                case "3" -> {
                    System.out.println("Введите id игрушки у которой надо изменить вес:");
                    Scanner sc = new Scanner(System.in);
                    String inputId = sc.nextLine().toUpperCase();
                    for (Toy toy: toyList) {
                        String strId = toy.getId().toString();
                        if (strId.equalsIgnoreCase(inputId)){
                            System.out.println("Введите новый вес: ");
                            int newWeight = sc.nextInt();
                            toy.setWeightToy(newWeight);
                        }
                    }
                }
                case "4" -> {
                    double completeWeight = 0.0;
                    for (Toy toy : toyList) {
                        completeWeight += toy.getWeightToy();
                    }
                    boolean rnd = true;
                    double randomWeight = 0;
                    while (rnd) {
                        randomWeight = Math.random() * completeWeight;
                        rnd = randomWeight > 100;
                    }
                    double selectWeight;
                    List<Toy> selectToys = new ArrayList<>();
                    for (Toy toy : toyList) {
                        selectWeight = toy.getWeightToy();
                        if (selectWeight >= randomWeight) {
                            selectToys.add(toy);
                        }
                    }
                    if (selectToys.size() == 0) {
                        System.out.println("К сожалению вы ничего не выиграли((( Попробуйте еще раз)))");
                    } else {
                        int index = (int) (Math.random() * selectToys.size());
                        System.out.println("Поздравляю!!!!! Вы выиграли - " + selectToys.get(index));
                    }
                }
                case "0" -> {
                    flag = false;
                    System.out.println("Работа завершена");
                }
                default -> System.out.println("Неверный выбор!! Повторите выбор!!");
            }
        }
    }
}
