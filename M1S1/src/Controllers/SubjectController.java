package Controllers;

import Models.Subject;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectController {

    Connector con = Connector.getInstance();

    private SubjectController() {
    }

    private static final SubjectController obj = new SubjectController();

    public static SubjectController getInstance() {
        return obj;
    }

    public void Save(Subject data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO subject(name,code,year,sem,lecture_hrs,tutorial_hrs,lab_hrs,evaluation_hrs) values ('" + data.getName() + "','" + data.getCode() + "','" + data.getYear() + "','" + data.getSem() + "','" + data.getLecture_hrs() + "','" + data.getTutorial_hrs() + "','" + data.getLab_hrs() + "','" + data.getEvaluation_hrs() + "') ");
    }

    public void Update(Subject data) throws Exception {
        con.getConnection();
        con.aud("UPDATE subject SET name  = '" + data.getName() + "',code  = '" + data.getCode() + "',year  = '" + data.getYear() + "',sem  = '" + data.getSem() + "',lecture_hrs  = '" + data.getLecture_hrs() + "',tutorial_hrs  = '" + data.getTutorial_hrs() + "',lab_hrs  = '" + data.getLab_hrs() + "',evaluation_hrs  = '" + data.getEvaluation_hrs() + "' WHERE id = '" + data.getId() + "'");
    }

    public void Delete(Subject data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM subject WHERE id = '" + data.getId() + "'");
    }

    public List<Subject> SearchAll() throws Exception {
        List<Subject> objList = new ArrayList<Subject>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM subject");
        while (rset.next()) {
            Subject obj = new Subject();
            obj.setId(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setCode(rset.getString(3));
            obj.setYear(rset.getString(4));
            obj.setSem(rset.getString(5));
            obj.setLecture_hrs(rset.getInt(6));
            obj.setTutorial_hrs(rset.getInt(7));
            obj.setLab_hrs(rset.getInt(8));
            obj.setEvaluation_hrs(rset.getInt(9));
            objList.add(obj);
        }

        return objList;
    }

    public List<Subject> Search(Subject data) throws Exception {
        List<Subject> objList = new ArrayList<Subject>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM subject WHERE id = '" + data.getId() + "'");
        while (rset.next()) {
            Subject obj = new Subject();
            obj.setId(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setCode(rset.getString(3));
            obj.setYear(rset.getString(4));
            obj.setSem(rset.getString(5));
            obj.setLecture_hrs(rset.getInt(6));
            obj.setTutorial_hrs(rset.getInt(7));
            obj.setLab_hrs(rset.getInt(8));
            obj.setEvaluation_hrs(rset.getInt(9));
            objList.add(obj);
        }

        return objList;
    }

    public int getCount() throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM subject");
        while (rset.next()) {
            count++;
        }

        return count;
    }

    public String getLastSubject() throws Exception {
        String value = "";
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM subject ORDER BY id DESC LIMIT 1");
        if (rset.next()) {
            value = rset.getString(3);
        }
        return value;
    }

}
