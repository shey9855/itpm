package Models;

public class Lecture {

    private int id;
    private String name;
    private String emp_id;
    private String faculty;
    private int level;
    private String department;
    private String center;
    private String building;
    private int rand;

    public Lecture() {
    }

    public Lecture(int id) {
        this.id = id;
    }

    public Lecture(int id, String name, String emp_id, String faculty, int level, String department, String center, String building, int rand) {
        this.id = id;
        this.name = name;
        this.emp_id = emp_id;
        this.faculty = faculty;
        this.level = level;
        this.department = department;
        this.center = center;
        this.building = building;
        this.rand = rand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

}
