package by.rymko.designpatterns.behavioral.b_03_iterator;

public class Program {
    public static void main(String[] args) {

        String[] skills = {"Java 8", "Spring Framework", "Hibernate", "MySQL", "Maven"};
        JavaDeveloper developer = new JavaDeveloper("Evgeniy", skills);
        System.out.printf("%s has next skills: %n", developer.getName());

        Iterator developerIterator = developer.getIterator();
        while (developerIterator.hasNext()) {
            System.out.println((String) developerIterator.next());
        }
    }
}
