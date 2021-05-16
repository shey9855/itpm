package Models;

public class Subject {

    private int id;
    private String name;
    private String code;
    private String year;
    private String sem;
    private int lecture_hrs;
    private int tutorial_hrs;
    private int lab_hrs;
    private int evaluation_hrs;

    public Subject() {
    }

    public Subject(int id) {
        this.id = id;
    }

    public Subject(int id, String name, String code, String year, String sem, int lecture_hrs, int tutorial_hrs, int lab_hrs, int evaluation_hrs) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.year = year;
        this.sem = sem;
        this.lecture_hrs = lecture_hrs;
        this.tutorial_hrs = tutorial_hrs;
        this.lab_hrs = lab_hrs;
        this.evaluation_hrs = evaluation_hrs;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public int getLecture_hrs() {
        return lecture_hrs;
    }

    public void setLecture_hrs(int lecture_hrs) {
        this.lecture_hrs = lecture_hrs;
    }

    public int getTutorial_hrs() {
        return tutorial_hrs;
    }

    public void setTutorial_hrs(int tutorial_hrs) {
        this.tutorial_hrs = tutorial_hrs;
    }

    public int getLab_hrs() {
        return lab_hrs;
    }

    public void setLab_hrs(int lab_hrs) {
        this.lab_hrs = lab_hrs;
    }

    public int getEvaluation_hrs() {
        return evaluation_hrs;
    }

    public void setEvaluation_hrs(int evaluation_hrs) {
        this.evaluation_hrs = evaluation_hrs;
    }

}
