
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseSingleton {
    private static DatabaseSingleton onlyInstance;
    private AccessDatabase access;
    private DatabaseSingleton(){
        access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    }

    public static DatabaseSingleton getOnlyInstance(){
        if(onlyInstance == null){
            onlyInstance = new DatabaseSingleton();
        }
        return onlyInstance;
    }

    public static void setOnlyInstance(DatabaseSingleton onlyInstace){
        DatabaseSingleton.onlyInstance = onlyInstace;
    }

    public ArrayList<String> getPosts(String id){
        ArrayList<String> tmp = new ArrayList<>();
        access.initializeConnection();
        tmp = access.getPosts(id);
        access.dbConnectClose();
        return tmp;
    }
    public void updatePost(String val){
        access.initializeConnection();
        access.updatePost(val);
        access.dbConnectClose();
        
    }
    public void removePost(String val){
        access.initializeConnection();
        access.removePost(val);
        access.dbConnectClose();
        
    }
    public void addPost(String id, String val, LocalDate timestamp){
        access.initializeConnection();
        access.addPost(id, val, timestamp);
        access.dbConnectClose();
    }
}
