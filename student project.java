import java.util.ArrayList;
import java.util.List;

class Project {
    private String name;
    private int daysTaken;

    public Project(String name, int daysTaken) {
        this.name = name;
        this.daysTaken = daysTaken;
    }

    public int getDaysTaken() {
        return daysTaken;
    }
}

class Student {
    private String name;
    private List<Project> projects;

    public Student(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }
}

public class ProjectTracker {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        // Add some sample data
        Student student1 = new Student("John");
        student1.addProject(new Project("Project1", 5));
        student1.addProject(new Project("Project2", 7));
        students.add(student1);

        Student student2 = new Student("Alice");
        student2.addProject(new Project("Project1", 4));
        student2.addProject(new Project("Project2", 10));
        students.add(student2);

        for (Student student : students) {
            int totalDays = 0;
            int onTime = 0;
            int late = 0;
            int early = 0;

            List<Project> projects = student.getProjects();
            for (Project project : projects) {
                totalDays += project.getDaysTaken();
                if (project.getDaysTaken() <= 7) {
                    onTime++;
                } else if (project.getDaysTaken() > 7) {
                    late++;
                } else {
                    early++;
                }
            }

            System.out.println("Student: " + student.getName());
            System.out.println("Number of projects completed on time: " + onTime);
            System.out.println("Number of projects completed late: " + late);
            System.out.println("Number of projects completed early: " + early);
            System.out.println("Average time taken to complete projects: " + (totalDays / (double) projects.size()) + " days");
            System.out.println();
        }
    }
}
