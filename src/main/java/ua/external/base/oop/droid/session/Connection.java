package ua.external.base.oop.droid.session;

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

    public void authorisation (){
        System.out.println("We develop this part");
    }

    public void signInAsAdminUser() throws IOException{
        System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
        String inputLogin;

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            inputLogin=bufferedReader.readLine();
        }
        System.out.println(inputLogin);


    }

    public void signInAsUsualUser(){
        System.out.println("We develop this part");
    }

    public boolean checkValue(String value){
        boolean checkResult=false;

        return checkResult;
    }
}
