package ua.external.base.oop.droid.session;

import org.apache.log4j.Logger;
import ua.external.base.oop.droid.exceptions.PassDoesNotMatchesPatternException;
import ua.external.base.oop.droid.exceptions.WrongInputLoginByRegistrationException;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;
import ua.external.base.oop.droid.session.users.User;
import ua.external.base.oop.droid.session.users.UserRole;
import java.io.*;


public class Connection {
    ResourceManager resourceManager = ResourceManager.INSTANCE;

    private String sourcePathUsers = "src/main/resources/additionalData/users.csv";
    private final static Logger logger = Logger.getLogger(Connection.class);

    public User register() throws IOException {
        String inputLogin = null;
        String inputPass = null;

        System.out.println(resourceManager.getString(Keys.INPUT_SIGN_UP));

        for (; ; ) {
            try{
                System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                inputLogin = bufferedReader.readLine();
                if (isLoginCorrect(inputLogin) && !isLoginExist(inputLogin)) {
                    break;
                }else {
                    throw new WrongInputLoginByRegistrationException();
                }
            }catch (IOException e){
                System.out.println(resourceManager.getString(Keys.INPUT_LOGIN_INCORRECT));
                logger.info(getLoggerMessage(e,inputLogin));
            }
        }

        for (; ; ) {
            try{
                System.out.println(resourceManager.getString(Keys.INPUT_PASSWORD));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                inputPass = bufferedReader.readLine();
                if (isPassCorrect(inputPass)) {
                    break;
                }else {
                    throw new PassDoesNotMatchesPatternException();
                }
            }catch(IOException e){
                System.out.println(resourceManager.getString(Keys.INPUT_PASSWORD_INCORRECT));
                logger.info(getLoggerMessage(e,inputLogin,inputPass));
            }
        }

        User user = new User(inputLogin, inputPass, UserRole.USER_ROLE);

        saveUser(user);

        return user;
    }

    public boolean isLoginCorrect(String login) {
        return login.matches("[A-Za-z\\d.-]{3,20}");
    }

    public boolean isLoginExist(String login) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(sourcePathUsers))) {

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                String userLogin = line.substring(0,line.indexOf(";"));

                if (userLogin.equals(login)) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean isPassCorrect(String password) {
        return password.matches("^(?![0-9]{6,20})[0-9a-zA-Z]{6,20}$");
    }

    public void saveUser(User user) throws IOException{
        try(FileWriter fw = new FileWriter(sourcePathUsers, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(user.getLogin()+";"+user.getPassword()+";"+user.getRole());
        }catch (IOException e){
            logger.info(e.toString());
        }
    }

    public User signIn() throws IOException {
        String inputLogin = null;
        String inputPass = null;

        System.out.println(resourceManager.getString(Keys.INPUT_SIGN_IN));
        System.out.println(resourceManager.getString(Keys.INPUT_LOGIN));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputLogin = bufferedReader.readLine();

        System.out.println(resourceManager.getString(Keys.INPUT_PASSWORD));
        inputPass = bufferedReader.readLine();

        User user = isUserPresent(inputLogin, inputPass);
        if (user != null)
            return user;
        else return register();
    }

    private User isUserPresent(String login, String pass) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(sourcePathUsers))) {

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split(";");

                if (userInfo[0].equals(login)) {
                    if (userInfo[1].equals(pass)) {
                        String role = userInfo[2];
                        return new User(login, pass, UserRole.valueOf(role));
                    }
                }
            }
            System.out.println(resourceManager.getString(Keys.INPUT_USER_INCORRECT));
            return null;
        }
    }

    private String getLoggerMessage(IOException e, String inputValue){
        StringBuilder sb= new StringBuilder(e.getClass().getSimpleName());
        sb.append(" ");
        sb.append(inputValue);
        return sb.toString();
    }

    private String getLoggerMessage(IOException e, String login, String pass){
        StringBuilder sb= new StringBuilder(e.getClass().getSimpleName());
        sb.append(" ");
        sb.append(login);
        sb.append(" ");
        sb.append(pass);
        return sb.toString();
    }

}
