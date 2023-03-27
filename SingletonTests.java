import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;


public class SingletonTests {
    
    private DatabaseSingleton access = DatabaseSingleton.getOnlyInstance();
    public String test = "Test upload to database";
    public String ID = "123";
    public LocalDate time = LocalDate.now();


        @BeforeClass
        public void uploadPostsTest(){
            access.addPost(ID, test, time);
        }

        @Test
        public void getPostsTest(){
            ArrayList<String> cmp = access.getPosts(ID);
            boolean flag = false;
            for(String elem : cmp){
                if(test.equals(elem)){
                    flag = true;
                }
            }
            assertTrue("Test upload to database was not succesfully retrived", flag);
        }

        @Test
        public void removePostTest(){
            access.addPost("098", "to be removed", LocalDate.now());
            ArrayList<String> cmp = access.getPosts(ID);
            boolean flag = false;
            for(String elem : cmp){
                if(test.equals(elem)){
                    flag = true;
                }
            }
            if(flag == true){
                access.removePost("098");
            }else{
                fail("Post was not succesfully uploaded when testing the remove function");
            }
            for(String elem : cmp){
                if(test.equals(elem)){
                    flag = false;
                }
            }
            assertTrue("Post was not removed from database succesfully", flag);
        }
}
