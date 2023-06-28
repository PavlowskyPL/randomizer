package randomizer.repositories;

import randomizer.entity.Person;

import java.util.Arrays;

public class PersonRepositories {
    private final Person[] personMas = {
            new Person("Сущевич Александр", 1),
            new Person("Илья", 2),
            new Person("Александр Чалов", 3),
            new Person("Кристина", 4),
            new Person("Диана", 5),
            new Person("Андрей", 6),
            new Person("Ангелина", 7),
            new Person("Северин Александр", 8),
            new Person("Пётр", 9),
            new Person("Антон", 10)
    };

    @Override
    public String toString() {
        return "" +  Arrays.toString(personMas);
    }

    public Person[] getPersonMas() {
        return personMas;
    }



}
