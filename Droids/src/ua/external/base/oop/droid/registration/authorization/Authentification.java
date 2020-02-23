package ua.external.base.oop.droid.registration.authorization;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

    public class Authentification  {
        public void authentification() throws IOException {
            Registration reg = new Registration();
            Scanner scanner = new Scanner(System.in);
            List<String> lines = Files.readAllLines(Paths.get("Users.txt"), Charset.defaultCharset());

            String log;
            System.out.println("Input your login:");
            log = scanner.nextLine();
            if (lines.contains("Login: " + log)) {
                System.out.println("Input your password: ");
            } else {
                System.out.println("Not found");
            }

            String password;
            password = scanner.nextLine();
            if (lines.contains("Password: " + password)) {
                System.out.println("Welcome!");
            } else {
                System.out.println("Not found");
            }
            scanner.close();
        }
    }
