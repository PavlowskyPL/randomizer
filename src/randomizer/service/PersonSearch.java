package randomizer.service;

import randomizer.repositories.PersonRepositories;

import java.util.Scanner;

public class PersonSearch {

    private final PersonRepositories personRepositories = new PersonRepositories();


    public PersonSearch() {
        Menu.showStartMenu();
        start();
    }

    public String choose() {
        return new Scanner(System.in).nextLine();
    }

    public void start() {
        switch (choose()) {
            case "1":
                showStudent();
                break;
            case "2":
                showStudent();
                System.out.println("Сколько студентов вы хотите удалить?");
                deleteStudent();
                showStudent();
                break;
            case "3":
                randomStudents();

                break;
            case "0":
                System.exit(0);
        }
        Menu.showStartMenu();
        start();
    }

    public void randomStudents() {
        System.out.println("---------------------------------------------------------------");
        int countNoTest = 0;
        for (int i = 0; i < personRepositories.getPersonMas().length; i++) {
            if (personRepositories.getPersonMas()[i].getStatus() == 1) {
                System.out.println("В ожидании: " + personRepositories.getPersonMas()[i]);
                countNoTest++;
            }
        }
        System.out.println("-------------------------------------------------------------");
        for (int i = 1; i <= 2; i++) {
            int random = (int) ((Math.random()) * (personRepositories.getPersonMas().length));
            if (countNoTest == 1) {
                for (int j = 0; j < personRepositories.getPersonMas().length; j++) {
                    if (personRepositories.getPersonMas()[j].getStatus() == 1) {
                        System.out.println("Остался 1 ученик " + personRepositories.getPersonMas()[j]);
                        System.out.println("Всем спасибо!");
                        getPersonRepositories();
                        System.out.println();
                        return;
                    }
                }
            }
            if (personRepositories.getPersonMas()[random].getStatus() == 1) {
                System.out.println(personRepositories.getPersonMas()[random]);
                personRepositories.getPersonMas()[random].setStatus(0);
            } else {
                i--;
            }
        }
        int count = 0;
        for (int i = 0; i < personRepositories.getPersonMas().length; i++) {

            if (personRepositories.getPersonMas()[i].getStatus() == 0){
                ++count;
            }
            if (count == personRepositories.getPersonMas().length){
                Menu.showFinishMenu();
                useFinishMenu();
            }
        }

        System.out.println();

        Menu.showInnerMenu();
        useInnerMenu();
    }
    public void useFinishMenu(){
        switch (choose()){
            case "1":
                Menu.showStartMenu();
                getPersonRepositories();
                start();
                break;
            case "0":
                System.exit(123);
                break;
        }
    }
    public void useInnerMenu(){
        switch (choose()) {
            case "1":
                randomStudents();
                break;
            case "2":
                Menu.showStartMenu();
                getPersonRepositories();
                break;
            case "0":
                System.exit(1);
                break;
        }
    }

    public void deleteStudent() {
        String delete = choose();
        System.out.println("Введите их ID:");
        int countDeletePerson = Integer.parseInt(delete);
        while (countDeletePerson > 0) {
            String s = choose();
            for (int i = 0; i < personRepositories.getPersonMas().length; i++) {
                if (personRepositories.getPersonMas()[i] != null &&
                        personRepositories.getPersonMas()[i].getNumberID() == Integer.parseInt(s)) {
                    personRepositories.getPersonMas()[i].setStatus(0);
                }
            }
            countDeletePerson--;
        }
        System.out.println("Отсутствующие ученики: ");
        for (int i = 0; i < personRepositories.getPersonMas().length; i++) {
            if (personRepositories.getPersonMas()[i].getStatus() == 0) {
                System.out.println(personRepositories.getPersonMas()[i]);
            }
        }
        System.out.println();
        System.out.println("Ученики, учавстующие в битве: ");
    }

    public void showStudent() {
        for (int i = 0; i < personRepositories.getPersonMas().length; i++) {
            if (personRepositories.getPersonMas()[i].getStatus() == 1) {
                System.out.println(personRepositories.getPersonMas()[i]);
            }

        }
        System.out.println();

    }

    public void getPersonRepositories() {
        for (int i = 0; i < personRepositories.getPersonMas().length; i++) {
            personRepositories.getPersonMas()[i].setStatus(1);
        }
    }
}
