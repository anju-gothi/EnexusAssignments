package StudentAssesmentAssignment;
/*
Find value of username
        Find values of all sessionid
        Find last value of sessionid
        Find all marks of second student
        Find the ssecond state value of first student
        Find the ssecond contact value of second student
        Find all cities of second student
        Find contacts of all students
        Find adress of first student
*/

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Student {
    String response;
    @BeforeMethod
    public void readResponse() throws IOException {
        response=new String(Files.readAllBytes(Paths.get("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\test\\java\\StudentAssesmentAssignment\\Studentdata.json")));
    }
    @Test
    public void parse(){
        System.out.println(response);
        //Find values of all sessionid
        JsonPath jpath= new JsonPath(response);
        //we can directly put the array value in a list using jsonPath
       List<Integer> list= jpath.get("sessionid");
       System.out.println("SessionId:"+list);
       // Find last value of sessionid
        System.out.println("Last value of Session Id:"+list.get(list.size()-1));
        //Find all marks of second student
       List<Integer> marks= jpath.get("students[1].marks");
       System.out.println("Marks of Second Student:"+marks);
       //Find the second state value of first student
       String state= jpath.get("students[0].adresss[1].state");
       System.out.println("Second State value of first Student:"+state);
       //Find the ssecond contact value of second student
       String contact= jpath.get("students[1].contact[1]");
       System.out.println("Second Contact value of Second Student:"+contact);
        // Find all cities of second student
        System.out.println("All cities");
        int size=jpath.get("students[1].adresss.size()");
        String city;
        for(int i=0;i<size;i++){
            city=jpath.get("students[1].adresss["+i+"].city");
            System.out.println(city);
        }
        // Find contacts of all students
        int sSize=jpath.get("students.size()");
        List<String> listContacts;
        System.out.println("Contacts of all students:");
        for(int index=0;index<sSize;index++){
          listContacts=  jpath.get("students["+index+"].contact");
          System.out.println(listContacts);
        }
        //Find adress of first student
        int aSize=jpath.get("students[1].adresss.size()");
        //We can directly put om map.
        Map<String,String> map;
        for(int j=0;j<aSize;j++){
           map= jpath.get("students[1].adresss["+j+"]");
           System.out.println(map);

        }

    }
}
