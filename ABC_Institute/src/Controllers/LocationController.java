package Controllers;

import Models.Location;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationController {

    Connector con = Connector.getInstance();

    private LocationController() {
    }

    private static final LocationController obj = new LocationController();

    public static LocationController getInstance() {
        return obj;
    }

    public void Save(Location data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO location(building,room,room_type,capacity) values ('" + data.getBuilding() + "','" + data.getRoom() + "','" + data.getRoom_type() + "','" + data.getCapacity() + "') ");
    }

    public void Update(Location data) throws Exception {
        con.getConnection();
        con.aud("UPDATE location SET building  = '" + data.getBuilding() + "',room  = '" + data.getRoom() + "',room_type  = '" + data.getRoom_type() + "',capacity  = '" + data.getCapacity() + "' WHERE id = '" + data.getId() + "'");
    }

    public void Delete(Location data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM location WHERE id = '" + data.getId() + "'");
    }

    public List<Location> SearchAll() throws Exception {
        List<Location> objList = new ArrayList<Location>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM location");
        while (rset.next()) {
            Location obj = new Location();
            obj.setId(rset.getInt(1));
            obj.setBuilding(rset.getString(2));
            obj.setRoom(rset.getString(3));
            obj.setRoom_type(rset.getString(4));
            obj.setCapacity(rset.getInt(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Location> Search(Location data) throws Exception {
        List<Location> objList = new ArrayList<Location>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM location WHERE id = '" + data.getId() + "'");
        while (rset.next()) {
            Location obj = new Location();
            obj.setId(rset.getInt(1));
            obj.setBuilding(rset.getString(2));
            obj.setRoom(rset.getString(3));
            obj.setRoom_type(rset.getString(4));
            obj.setCapacity(rset.getInt(5));
            objList.add(obj);
        }

        return objList;
    }

    public int getCount() throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM location");
        while (rset.next()) {
            count++;
        }

        return count;
    }

    public int getCountLoc(String value) throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM location WHERE room_type = '" + value + "'");
        while (rset.next()) {
            count++;
        }

        return count;
    }

}
