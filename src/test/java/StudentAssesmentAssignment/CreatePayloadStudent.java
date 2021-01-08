package StudentAssesmentAssignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePayloadStudent {
   public StudentPojo studentobj;
    @Test
    public void createPayload() throws IOException {

         studentobj= new StudentPojo();
        Adresss add1= new Adresss();
        Adresss add2= new Adresss();
        Students stud1 = new Students();
        Students stud2 = new Students();

        add1.setCity("durg");
        add1.setState("Chh");
        add2.setCity("durg1");
        add2.setState("Chh1");


        List<Adresss> listAddress =new ArrayList<>();
        listAddress.add(add1);listAddress.add(add2);

        stud1.setId(1);
        stud1.setAdresss(listAddress);
        List<String> contactList1=new ArrayList<>();
        contactList1.add("1234");contactList1.add("3456");
        stud1.setContact(contactList1);
        List<Integer> marksList1=new ArrayList<>();
        marksList1.add(20);marksList1.add(25);marksList1.add(22);
        stud1.setMarks(marksList1);
        stud1.setName("Anju");

        stud2.setId(2);
        stud2.setAdresss(listAddress);
        List<String> contactList2=new ArrayList<>();
        contactList2.add("5678");contactList2.add("1234");
        stud2.setContact(contactList2);
        List<Integer> marksList2=new ArrayList<>();
        marksList2.add(2);marksList2.add(5);marksList2.add(222);
        stud2.setMarks(marksList2);
        stud2.setName("Pranay");


        List<Students> sList= new ArrayList<>();
        sList.add(stud1);sList.add(stud2);

        studentobj.setUsername("anjugothi");
        studentobj.setPassword("pppp");
        List<Integer> sessoinList= new ArrayList<>();
        sessoinList.add(12);sessoinList.add(23);sessoinList.add(34);sessoinList.add(56);
        studentobj.setSessionid(sessoinList);
        studentobj.setStudents(sList);

        //Marshaling, Serialization ,converting Pojo to Json
        String json;

        ObjectMapper mapper = new ObjectMapper();
       json= mapper.writeValueAsString(studentobj);
       System.out.println(json);
        File file = new File("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\test\\java\\StudentAssesmentAssignment\\serializedpojo.json");
        mapper.writeValue(file,json);


    }
    /*Find values of all sessionid
    Find last value of sessionid
    Find all marks of second student
    Find the second state value of first student
    Find the second contact value of second student
    Find all cities of second student
    Find contacts of all students
    Find adress of first student*/
    @Test(priority = 2)
    public void query(){
       //Find values of all sessionid
        int size=studentobj.getSessionid().size();
        for(int index=0;index<size;index++){
            System.out.println(studentobj.getSessionid().get(index));
        }
        System.out.println("**********************************************************************");
        //Find all marks of second student
        List<Integer> marks=studentobj.getStudents().get(1).getMarks();
        System.out.println(marks);
        System.out.println("***********************************************************************");
        // Find the second state value of first student
        System.out.println(studentobj.getStudents().get(0).getAdresss().get(1).getState());
        System.out.println("************************************************************************");
        //Find all cities of second student
        int s=studentobj.getStudents().get(1).getAdresss().size();
        String city;
        for(int i=0;i<s;i++){
           city=studentobj.getStudents().get(1).getAdresss().get(i).getCity();
           System.out.println(city);

        }



    }
}
