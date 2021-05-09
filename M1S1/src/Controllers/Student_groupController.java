package Controllers;

import Models.Student_group;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Student_groupController {

    Connector con = Connector.getInstance();

    private Student_groupController() {
    }

    private static final Student_groupController obj = new Student_groupController();

    public static Student_groupController getInstance() {
        return obj;
    }

    public void Save(Student_group data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO student_group(year_sem,programme,group_no,group_id,sub_group_no,sub_group_id) values ('" + data.getYear_sem() + "','" + data.getProgramme() + "','" + data.getGroup_no() + "','" + data.getGroup_id() + "','" + data.getSub_group_no() + "','" + data.getSub_group_id() + "') ");
    }

    public void Update(Student_group data) throws Exception {
        con.getConnection();
        con.aud("UPDATE student_group SET year_sem  = '" + data.getYear_sem() + "',programme  = '" + data.getProgramme() + "',group_no  = '" + data.getGroup_no() + "',group_id  = '" + data.getGroup_id() + "',sub_group_no  = '" + data.getSub_group_no() + "',sub_group_id  = '" + data.getSub_group_id() + "' WHERE id = '" + data.getId() + "'");
    }

    public void Delete(Student_group data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM student_group WHERE id = '" + data.getId() + "'");
    }

    public List<Student_group> SearchAll() throws Exception {
        List<Student_group> objList = new ArrayList<Student_group>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM student_group");
        while (rset.next()) {
            Student_group obj = new Student_group();
            obj.setId(rset.getInt(1));
            obj.setYear_sem(rset.getString(2));
            obj.setProgramme(rset.getString(3));
            obj.setGroup_no(rset.getInt(4));
            obj.setGroup_id(rset.getString(5));
            obj.setSub_group_no(rset.getInt(6));
            obj.setSub_group_id(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Student_group> Search(Student_group data) throws Exception {
        List<Student_group> objList = new ArrayList<Student_group>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM student_group WHERE id = '" + data.getId() + "'");
        while (rset.next()) {
            Student_group obj = new Student_group();
            obj.setId(rset.getInt(1));
            obj.setYear_sem(rset.getString(2));
            obj.setProgramme(rset.getString(3));
            obj.setGroup_no(rset.getInt(4));
            obj.setGroup_id(rset.getString(5));
            obj.setSub_group_no(rset.getInt(6));
            obj.setSub_group_id(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }
    
    public int getCount() throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM student_group");
        while (rset.next()) {
            count++;
        }

        return count;
    }
    
    public String getLastStudent() throws Exception {
        String value = "";
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM student_group ORDER BY id DESC LIMIT 1;");
        if (rset.next()) {
            value = rset.getString(7);
        }
        return value;
    }

}
