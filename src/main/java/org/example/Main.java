package org.example;

import java.util.Scanner;

//1. Задача: Проверка логина и пароля
//1 - Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//2 - Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
//3 -Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//4 - WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
//5 - В основном классе программы необходимо по-разному обработать исключения.
//6 - Метод возвращает true, если значения верны или false в другом случае.

public class Main {
    public static void main(String[] args) throws Exception, WrongPasswordException {
        // code
        Scanner in = new Scanner(System.in);
        String login = in.next();
        String password = in.next();
        String confirmPassword = in.next();
        System.out.println(checkingConditions(login, password, confirmPassword));
    }

    public static boolean checkingConditions(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {


        try {
            checkLength(login); // Выбросит исключение WrongLoginException
        } catch (WrongLoginException e) {
            throw new WrongLoginException("Длина строки должна быть меньше 20 символов"); // Выведет "Длина строки должна быть меньше 20 символов"

        }
        try {
            checkLength(password);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            throw new WrongLoginException("Длина строки должна быть меньше 20 символов");
        }
        try {
            equalsPasswords(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            //throw new WrongPasswordException("Пароли не совпадают");
            throw new WrongPasswordException();
        }
        return true;
    }

    private static void checkLength(String str) throws WrongLoginException {
        if (str.length() >= 20) {
            throw new WrongLoginException("Длина строки должна быть меньше 20 символов");
        }
    }

    private static void equalsPasswords(String password, String password2) throws WrongPasswordException {
        if (!password.equals(password2)) {
            throw new WrongPasswordException("Пароли не равны!");
        }
    }
}