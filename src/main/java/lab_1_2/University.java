package lab_1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class University {
    private static final int NUMBER_OF_POINTS = 10;
    private static final int MAX_POINT = 10;
    private static final int MIN_POINT_SUM = 60;

    List<Student> students;

    public University(String studentsStr) {
        fillStudents(studentsStr);
    }

    public Map<String, Set<String>> task1() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGroup,
                        TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toCollection(TreeSet::new))));
    }

    public Map<String, Map<String, List<Integer>>> task2() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGroup,
                        TreeMap::new,
                        Collectors.toMap(Student::getName, Student::getPoints,
                                (v1, v2) -> v1, TreeMap::new)));
   }

    public Map<String, Map<String, Integer>> task3() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGroup,
                        TreeMap::new,
                        Collectors.toMap(Student::getName, student -> student.getPoints().stream()
                                        .mapToInt(Integer::intValue).sum(),
                                (v1, v2) -> v1, TreeMap::new)));
    }

    public Map<String, Map<String, Double>> task4() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGroup,
                        TreeMap::new,
                        Collectors.toMap(Student::getName, student -> student.getPoints().stream()
                                        .mapToInt(Integer::intValue).average().getAsDouble(),
                                (v1, v2) -> v1, TreeMap::new)));
    }

    public Map<String, Set<String>> task5() {
        return students.stream()
                .filter(student -> student.getPoints().stream().mapToInt(Integer::intValue).sum() >= MIN_POINT_SUM)
                .collect(Collectors.groupingBy(Student::getGroup,
                        TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toCollection(TreeSet::new))));
    }

    private void fillStudents(String studentsStr) {
        this.students =  Arrays.stream(studentsStr.split(";"))
                .map(s -> s.split(" - "))
                .map(s -> new Student(s[1].trim(), s[0].trim(), fillPoints()))
                .collect(Collectors.toList());
    }

    private List<Integer> fillPoints() {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            points.add((int) (Math.random() * MAX_POINT) + 1);
        }
        return points;
    }
}
