import models.Auto;
import models.User;
import services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Данная программа выполняет три команды: \n'Регистрация' \n'Редактирование' \n'Удаление'");
        System.out.print("Введите вашу команду: ");
        Scanner str = new Scanner(System.in);
        String request = str.nextLine();

        if (request.equals("Регистрация")) {
            System.out.println("Введите имя пользователя:");
            String dewName = str.nextLine();

            System.out.println("Введите возраст пользователя:");
            int dewAge = str.nextInt();
            UserService userService = new UserService();
            User user = new User("" + dewName, +dewAge);
            userService.saveUser(user);
            userService.updateUser(user);

            for (int i = 0; i < 100; i++) {
                String ddd = str.nextLine();//Почему так?????
                System.out.println("Введите название автомобиля:");
                String dewModel = str.nextLine();


                System.out.println("Введите цвет автомобиля:");
                String dewColor = str.nextLine();
                Auto autoOne = new Auto("" + dewModel, "" + dewColor);
                autoOne.setUser(user);
                user.addAuto(autoOne);
                userService.updateUser(user);


            }
        }
        if (request.equals("Удаление")) {
            for (int i = 0; i < 1000; i++) {
                System.out.print("Введите id пользователя:");
                int dewId = str.nextInt();
                UserService userService = new UserService();
                User user = new User(+dewId);
                userService.deleteUser(user);
            }
        }

        if (request.equals("Редактирование")) {
            System.out.println("Введите id пользователя:");
            int nextId = str.nextInt();

            User user = new User(+nextId);


            System.out.println("Введите новое имя:");
            String kkk = str.nextLine(); //Почему?????
            String newName = str.nextLine();
            user.setName("" + newName);


            System.out.println("Введите новый возраст:");
            int newAge = str.nextInt();
            user.setAge(+newAge);

            UserService userService = new UserService();
            userService.updateUser(user);


        }

        }
    }
