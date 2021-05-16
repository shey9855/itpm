package Controllers;

import Models.Lecture;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LectureController {

    Connector con = Connector.getInstance();

    private LectureController() {
    }

    private static final LectureController obj = new LectureController();

    public static LectureController getInstance() {
        return obj;
    }

    public void Save(Lecture data) throws Exception {
        con.getConnection();
        //con.aud("INSERT INTO lecture(name,emp_id,faculty,level,department,center,building,rand) values ('" + data.getName() + "','" + data.getEmp_id() + "','" + data.getFaculty() + "','" + data.getLevel() + "','" + data.getDepartment() + "','" + data.getCenter() + "','" + data.getBuilding() + "','" + data.getRand() + "') ");
        con.aud("INSERT INTO lecturer(id,lecturer_name,lecturer_ID,lecturer_level,lecturer_rank,faculty,department,center,building) values ('" + data.getEmp_id()+ "','"+data.getName()+"','"+data.getEmp_id()+"','"+data.getLevel()+"','"+data.getRand()+"','"+data.getFaculty()+"','"+data.getDepartment()+"','"+data.getCenter()+"','"+data.getBuilding()+"') ");
    }

    public void Update(Lecture data) throws Exception {
        con.getConnection();
        con.aud("UPDATE lecturer SET name  = '" + data.getName() + "',emp_id  = '" + data.getEmp_id() + "',faculty  = '" + data.getFaculty() + "',level  = '" + data.getLevel() + "',department  = '" + data.getDepartment() + "',center  = '" + data.getCenter() + "',building  = '" + data.getBuilding() + "',rand  = '" + data.getRand() + "' WHERE id = '" + data.getId() + "'");
    }

    public void Delete(Lecture data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM lecturer WHERE id = '" + data.getId() + "'");
    }

    public List<Lecture> SearchAll() throws Exception {
        List<Lecture> objList = new ArrayList<Lecture>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM lecturer");
        while (rset.next()) {
            Lecture obj = new Lecture();
            obj.setId(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setEmp_id(rset.getString(3));
            obj.setFaculty(rset.getString(4));
            obj.setLevel(rset.getInt(5));
            obj.setDepartment(rset.getString(6));
            obj.setCenter(rset.getString(7));
            obj.setBuilding(rset.getString(8));
            obj.setRand(rset.getInt(9));
            objList.add(obj);
        }

        return objList;
    }

    public List<Lecture> Search(Lecture data) throws Exception {
        List<Lecture> objList = new ArrayList<Lecture>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM lecturer WHERE id = '" + data.getId() + "'");
        while (rset.next()) {
            Lecture obj = new Lecture();
            obj.setId(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setEmp_id(rset.getString(3));
            obj.setFaculty(rset.getString(4));
            obj.setLevel(rset.getInt(5));
            obj.setDepartment(rset.getString(6));
            obj.setCenter(rset.getString(7));
            obj.setBuilding(rset.getString(8));
            obj.setRand(rset.getInt(9));
            objList.add(obj);
        }

        return objList;
    }

    public int getCount() throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM lecturer");
        while (rset.next()) {
            count++;
        }

        return count;
    }

    public String getLastLecture() throws Exception {
        String value = "";
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM lecturer ORDER BY id DESC LIMIT 1;");
        if (rset.next()) {
            value = rset.getString(3);
        }
        return value;
    }
    
    

}
