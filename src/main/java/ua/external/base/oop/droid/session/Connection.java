package ua.external.base.oop.droid.session;


import ua.external.base.oop.droid.exceptions.AdminLoginException;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Connection {
    ResourceManager resourceManager = ResourceManager.INSTANCE;

    public void register(){
        System.out.println("We develop registration");
    }

    public void signInAsAdminUser() throws IOException {
//        String inputLogin = null;
//
//        System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
//
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            inputLogin = bufferedReader.readLine();
//            System.out.println(inputLogin);
//        }catch (AdminLoginException e){
//            System.out.println("Wrong login");
//            e.printStackTrace();
//        }
    }

    public void signInAsUsualUser(){
        System.out.println("We develop this part");
    }

    public boolean isLoginPresent(String login, String sourcePath) throws IOException{
        boolean result=false;

        return result;
    }


}
