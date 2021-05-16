package Models;

public class Student_group {

    private int id;
    private String year_sem;
    private String programme;
    private int group_no;
    private String group_id;
    private int sub_group_no;
    private String sub_group_id;

    public Student_group() {
    }

    public Student_group(int id) {
        this.id = id;
    }

    public Student_group(int id, String year_sem, String programme, int group_no, String group_id, int sub_group_no, String sub_group_id) {
        this.id = id;
        this.year_sem = year_sem;
        this.programme = programme;
        this.group_no = group_no;
        this.group_id = group_id;
        this.sub_group_no = sub_group_no;
        this.sub_group_id = sub_group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear_sem() {
        return year_sem;
    }

    public void setYear_sem(String year_sem) {
        this.year_sem = year_sem;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getGroup_no() {
        return group_no;
    }

    public void setGroup_no(int group_no) {
        this.group_no = group_no;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public int getSub_group_no() {
        return sub_group_no;
    }

    public void setSub_group_no(int sub_group_no) {
        this.sub_group_no = sub_group_no;
    }

    public String getSub_group_id() {
        return sub_group_id;
    }

    public void setSub_group_id(String sub_group_id) {
        this.sub_group_id = sub_group_id;
    }

}
