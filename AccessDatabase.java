
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;



public class AccessDatabase {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    EventStore eventStore = new EventStore();
    StringCommandQuery commandHandler = new StringCommandQuery(eventStore);
    StringQueryHandler queryHandler = new StringQueryHandler(eventStore);

    public ArrayList<String> getPosts(int id){
        ArrayList<String> post = new ArrayList<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "EVENTS");
            while(results.next()){
                if(results.getInt("eventId") == id){
                    post.add(results.getString("aggregateId"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return post;

    }
    public void updatePost(String val){
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "EVENTS");
            while(results.next()){
                if(results.getString("aggregateID").equals(val)){
                    results.updateString("aggregateId", val);
                    break;
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }

    }
    public void removePost(String val){
        try {
            String delete = "DELETE FROM " + "EVENTS" + " WHERE aggregateId='"+val+"'";
            Statement myStmt = dbConnect.createStatement();
            myStmt.executeUpdate(delete);
            myStmt.close();
        }catch(SQLException e){

        }

    }

    public void addPost(String id, String val, LocalDate timeStamp){
        try{
            commandHandler.handle(new ChangeStringCommand(id, val));

            Statement myStmt = dbConnect.createStatement();
                
            String tmp = "INSERT INTO EVENTS " + "VALUES ("+id+", '"+queryHandler.getValue(id)+"', "+timeStamp+")";
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void dbConnectClose(){
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public AccessDatabase(String url, String user, String pw){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }


    //Must create a connection to the database, no arguments, no return value
    public void initializeConnection(){
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }

    String getPassword(){
        return this.PASSWORD;
    }

    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
