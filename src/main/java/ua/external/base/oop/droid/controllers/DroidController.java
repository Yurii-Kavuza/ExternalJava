package ua.external.base.oop.droid.controllers;


import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;
import ua.external.base.oop.droid.session.Connection;
import ua.external.base.oop.droid.session.users.User;
import ua.external.base.oop.droid.session.users.UserRole;
import ua.external.base.oop.droid.views.DroidView;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DroidController {
    private ArrayList<Droid> droids;
    ArrayList<Droid> droidsTournament;
    private Droid droid1;
    private Droid droid2;
    private DroidView view;
    private Connection connection = new Connection();
    private User user;

    public DroidController(ArrayList<Droid> droids, DroidView view) {
        this.droids = droids;
        this.view = view;
        droidsTournament = new ArrayList<>(droids.subList(0, 4));
    }

    public void startGame() throws IOException {
        chooseLanguage();
        startGameMenu();
    }

    public void chooseLanguage() {
        Scanner scanner = new Scanner(System.in);

        view.printMessage(Keys.CHOOSE_LANG);
        int numOfLang;

        if (scanner.hasNextInt())
            numOfLang = scanner.nextInt();
        else numOfLang = 2;

        Locale locale = numOfLang == 1 ?
                new Locale("ua", "UA") :
                new Locale("en", "EN");

        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.changeResource(locale);
    }

    public void startGameMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numOfAction = 0;

        view.printStartMenu();
        while (true) {
            while (!scanner.hasNextInt()) {
                view.printStartMenu();
                scanner.next();
            }

            numOfAction = scanner.nextInt();
            if (numOfAction == 1) {
                user = connection.register();
                break;
            } else if (numOfAction == 2) {
                user = connection.signIn();
                break;
            } else if (numOfAction == 0) {
                System.exit(0);
            } else {
                view.printStartMenu();
                continue;
            }
        }
        gameUserMenu();
    }

    public void gameUserMenu() throws IOException {
        if (user.getRole() == UserRole.USER_ROLE) {
            userMenu();
        } else if (user.getRole() == UserRole.ADMIN_ROLE) {
            adminMenu();
        }
    }

    public void adminMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printAdminMenu();

            while (!scanner.hasNextInt()) {
                view.printStartMenu();
                scanner.next();
            }

            int numOfAction = scanner.nextInt();
            if (numOfAction == 1) {
                startTournament();
            } else if (numOfAction == 2) {
                view.printDroidsInfo(droids);
            } else if (numOfAction == 3) {
                startGameMenu();
            } else if (numOfAction == 4) {
                addDroidInTournament();
            } else if (numOfAction == 5) {
                deleteDroidFromTournament();
            } else if (numOfAction == 0) {
                System.exit(0);
            }
        }
    }

    public void userMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printUserMenu();

            while (!scanner.hasNextInt()) {
                view.printStartMenu();
                scanner.next();
            }

            int numOfAction = scanner.nextInt();
            if (numOfAction == 1) {
                startTournament();
            } else if (numOfAction == 2) {
                droidBet();
            } else if (numOfAction == 3) {
                startGameMenu();
            } else if (numOfAction == 0) {
                System.exit(0);
            }
        }
    }

    public ArrayList<Droid> startTournament() {
        //ArrayList<Droid> droidsTournament  =  new ArrayList<>(droids);
        view.printGreeting();
        view.printQuantityOfCompetitors(droidsTournament.size());

        while (droidsTournament.size() > 1) {
            int firstCompetitor = (int) (Math.random() * droidsTournament.size());
            droid1 = droidsTournament.get(firstCompetitor);
            droidsTournament.remove(firstCompetitor);

            int secondCompetitor = (int) (Math.random() * droidsTournament.size());
            droid2 = droidsTournament.get(secondCompetitor);
            droidsTournament.remove(secondCompetitor);

            view.printCompetitors(droid1, droid2);

            droid1.fight(droid2);

            if (droid1.getAlive() && !droid2.getAlive()) {
                view.printWinnerOfFight(droid1.getResultAfterFight());
                droidsTournament.add(droid1);
            } else if (!droid1.getAlive() && droid2.getAlive()) {
                view.printWinnerOfFight(droid2.getResultAfterFight());
                droidsTournament.add(droid2);
            } else if (droid1.getAlive() && droid2.getAlive()) {
                view.printNoWinner(droid1.getResultAfterFight());
                droidsTournament.add(droid1);
                droidsTournament.add(droid2);
            }

            if (droidsTournament.size() > 1) {
                view.printQuantityOfCompetitors(droidsTournament.size());
            }
        }

        view.printWinnerOfTournament(droidsTournament.get(0));
        view.printBeforeWePart();

        return droidsTournament;
    }

    public void droidBet() {
        view.printMessageByKey(Keys.OUTPUT_BET_CHOOSE);
        view.printDroidsInfo(droidsTournament);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int winner = scanner.nextInt();
            Droid droidWinner = droids.get(winner);
            ArrayList<Droid> winners = startTournament();
            if (winners.contains(droidWinner)) {
                view.printMessageByKey(Keys.OUTPUT_BET_SUCCESS);
            } else view.printMessageByKey(Keys.OUTPUT_BET_FAIL);
        }
    }

    public void addDroidInTournament() {
        view.printMessageByKey(Keys.OUTPUT_ADD_DROID_CHOOSE);
        ArrayList<Droid> freeDroids = new ArrayList<>(droids);
        freeDroids.removeAll(droidsTournament);
        view.printDroidsInfo(freeDroids);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int indDroid = scanner.nextInt();
            Droid droid = freeDroids.get(indDroid);
            droidsTournament.add(droid);
        }
    }

    public void deleteDroidFromTournament() {
        view.printMessageByKey(Keys.OUTPUT_DELETE_DROID_CHOOSE);
        view.printDroidsInfo(droidsTournament);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int droid = scanner.nextInt();
            droidsTournament.remove(droidsTournament.get(droid));
        }
    }

    public ArrayList<Droid> sortDroidsByHealth() {
        ArrayList<Droid> result = new ArrayList<>(droids);
        result.sort((o1, o2) -> o1.getHealth() - o2.getHealth());
        return result;
    }

    public List<Droid> findDroidsByFirstLetterName(String letter) {
        List<Droid> result = droids.stream().filter(x -> x.getName().startsWith(letter)).collect(Collectors.toList());
        return result;
    }
}
