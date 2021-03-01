package lab_1_2;

import java.util.List;

class Student {
    private final String group;
    private final String name;
    private final List<Integer> points;

    public Student(String group, String name, List<Integer> points) {
        this.group = group;
        this.name = name;
        this.points = points;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPoints() {
        return points;
    }
}
