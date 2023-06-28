package randomizer.service;

public class Menu {
        public static void showStartMenu(){
            System.out.println(
                    "1. Показать весь список учеников\n" +
                    "2. Исключить отсутствующих\n" +
                    "3. Начать битву студентов");
        }
        public static void showInnerMenu(){
            System.out.println("Для продолжения, нажмите \"1\": \n" +
                    "Для выхода в главное меню, нажмите \"2\": \n" +
                    "Для завершения, нажмите \"0\": ");
        }
        public static void showFinishMenu(){
            System.out.println("\n " +
                      "Все опрошены!\n" +
                    "Выйти в главное меню, нажмите \"1\": \n" +
                    "Для завершения, нажмите \"0\": ");
        }
}
