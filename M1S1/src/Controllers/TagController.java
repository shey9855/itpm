package Controllers;

import Models.Tag;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TagController {

    Connector con = Connector.getInstance();

    private TagController() {
    }

    private static final TagController obj = new TagController();

    public static TagController getInstance() {
        return obj;
    }

    public void Save(Tag data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO tag(tag_name,tag_code,related_tag) values ('" + data.getTag_name() + "','" + data.getTag_code() + "','" + data.getRelated_tag() + "') ");
    }

    public void Update(Tag data) throws Exception {
        con.getConnection();
        con.aud("UPDATE tag SET tag_name  = '" + data.getTag_name() + "',tag_code  = '" + data.getTag_code() + "',related_tag  = '" + data.getRelated_tag() + "' WHERE id = '" + data.getId() + "'");
    }

    public void Delete(Tag data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM tag WHERE id = '" + data.getId() + "'");
    }

    public List<Tag> SearchAll() throws Exception {
        List<Tag> objList = new ArrayList<Tag>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tag");
        while (rset.next()) {
            Tag obj = new Tag();
            obj.setId(rset.getInt(1));
            obj.setTag_name(rset.getString(2));
            obj.setTag_code(rset.getString(3));
            obj.setRelated_tag(rset.getString(4));
            objList.add(obj);
        }

        return objList;
    }

    public List<Tag> Search(Tag data) throws Exception {
        List<Tag> objList = new ArrayList<Tag>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tag WHERE id = '" + data.getId() + "'");
        while (rset.next()) {
            Tag obj = new Tag();
            obj.setId(rset.getInt(1));
            obj.setTag_name(rset.getString(2));
            obj.setTag_code(rset.getString(3));
            obj.setRelated_tag(rset.getString(4));
            objList.add(obj);
        }

        return objList;
    }

}
