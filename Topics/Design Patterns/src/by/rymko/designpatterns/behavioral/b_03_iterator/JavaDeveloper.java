package by.rymko.designpatterns.behavioral.b_03_iterator;

public class JavaDeveloper implements Collection {

    private String name;

    private String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < skills.length) return true;
            return false;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}
