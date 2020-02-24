package ua.external.base.oop.droid.session;

import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;

import java.io.*;

public class Connection {
    ResourceManager resourceManager = ResourceManager.INSTANCE;
    private boolean haveAccessRight=false;
    private boolean signedInAsAdminUser=false;
    private String login;
    private String password;
    private String sourcePathAdminUsers="src\\main\\resources\\additionalData\\adminUsers.csv";
    private String sourcePathUsualUsers="src\\main\\resources\\additionalData\\usualUsers.csv";

    public void register(){
        System.out.println("We develop registration");
    }

    public void signInAsAdminUser() throws IOException {
        signIn(sourcePathAdminUsers);
    }

    public void signInAsUsualUser() throws IOException {
        signIn(sourcePathUsualUsers);
    }

    public void signIn(String sourcePath) throws IOException {
        String inputLogin = null;
        String inputPass = null;
        System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            inputLogin = bufferedReader.readLine();
            while(inputLogin==null||inputLogin.length()==0||inputLogin.equals("\n")) {
                System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
                inputLogin = bufferedReader.readLine();
            }
            if(isLoginPresent(inputLogin,sourcePath)){
                while (!isPasswordPresent(bufferedReader)){
                    if(isPasswordPresent(bufferedReader)) break;
                }
                break;
            }else {
                System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
                continue;
            }
        }
    }

    private boolean isLoginPresent(String login, String sourcePath) throws IOException{
        boolean result=false;
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(sourcePath))){
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                String tempLogin=line.substring(0,line.indexOf(";"));
                if(tempLogin.equals(login)){
                    this.password=line.substring(line.indexOf(";")+1);
                    this.haveAccessRight=true;
                    result=true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isPasswordPresent(BufferedReader bufferedReader) throws IOException{
        boolean result=false;
        String inputPass = null;
        System.out.println(resourceManager.getString(Keys.INPUT_PASSWORD));
        inputPass=bufferedReader.readLine();
        while(inputPass==null||inputPass.length()==0||inputPass.equals("\n")){
            System.out.println(resourceManager.getString(Keys.INPUT_PASSWORD));
            inputPass=bufferedReader.readLine();
        }
        if(inputPass.equals(this.password)) result=true;
        return result;
    }
}
