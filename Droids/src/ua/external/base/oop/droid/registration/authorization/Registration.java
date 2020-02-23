package ua.external.base.oop.droid.registration.authorization;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Registration {

        public void registration() throws IOException {

            FileWriter fileWriter = new FileWriter("Users.txt", true);
            Scanner scanner = new Scanner(System.in);

            String login;
            System.out.println("Input login for registration (like name@mail.com): ");
            login = scanner.nextLine();
            Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
            Matcher matcher = pattern.matcher(login);
            while (matcher.find()) {
                System.out.println("Login correct!");
                fileWriter.write("Login: " + login + "\r\n");
            }

            String password;
            System.out.println("Input password (password should consist of 6-18 symbols): ");
            password = scanner.nextLine();
            Pattern pattern1 = pattern.compile("^[a-zA-Z0-9_-]{6,18}$");
            Matcher matcher1 = pattern1.matcher(password);
            while (matcher1.find()) {
                System.out.println("Password correct!");
                fileWriter.write("Password: " + password + "\r\n");
            }

            scanner.close();
            fileWriter.close();
        }
    }


