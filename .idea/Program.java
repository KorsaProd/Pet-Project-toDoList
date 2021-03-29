import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> toDoList = new ArrayList<>();

        //toDoList.add("Нулевое дело");

        boolean stopped = false;
        do {
            String choice = input("Введите действие " + "( list, add, edit, delete или exit )");

            if (choice.equals("list")) {
                System.out.println("Ваши дела: ");
                if (toDoList.isEmpty()) {
                    ifListEmpty(toDoList);
                }
                listOfToDo(toDoList);
            }

            if (choice.equals("add")) {
                addingDelo(toDoList);
            }


            if (choice.equals("edit")) {
                String newToDo = input("Введите номер дела");
                toDoList.get(Integer.parseInt(newToDo));
                String newToDo2 =input("Введите новое название дела");
                toDoList.set(Integer.parseInt(newToDo), newToDo2);

            }
            if (choice.equals("delete")) {
                String numToDelete = input("Введите номер дела который нужно удалить");
                toDoList.remove(Integer.parseInt(numToDelete));

                System.out.println("Текущий список дел: ");
                listOfToDo(toDoList);

                if (toDoList.isEmpty()) {
                    ifListEmpty(toDoList);
                }
            }
            if(choice.equals("exit")){
                stopped = true;
            }
        } while (!stopped);

    }

    public static void addingDelo(ArrayList<String> box) {
        String adding = input("Введите дело");
        box.add(adding);

        System.out.println("Список дел");
        listOfToDo(box);
    }

    public static void ifListEmpty (ArrayList<String> box) {
        String reply = input("Список пуст, создать новое дело? (y) or (n) ");
        if (reply.compareToIgnoreCase("n") == 0) {
            System.out.println("Надо дело ввести, бро");
        } else {
            addingDelo(box);
        }
    }

    public static void listOfToDo (ArrayList<String> box) {
        for (int i = 0; i < box.size(); i++) {
            System.out.println(i + ": " + box.get(i));
        }
    }


    public static String input (String msg) {
        System.out.println(msg + " ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }
}
