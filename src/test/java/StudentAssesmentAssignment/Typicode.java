package StudentAssesmentAssignment;
/*
Access below API
        • https://jsonplaceholder.typicode.com/posts
        • API will return JSON response.
        • Parse the JSON
        • Check if response has " userId": "7"
        ➢ Pass the test and display the title of that userId
        ➢ Simple Maven Project
        ➢ Java
        ➢ Restassured Framework
*/

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Typicode {
    Response response;
    @BeforeMethod
    public void getResponse(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
        response=RestAssured.given().when().get();
    }
    @Test
    public void parseResponse() throws IOException, InterruptedException {
        System.out.println(response.asString());
        //write in the file
        File fData= new File("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\test\\java\\StudentAssesmentAssignment\\Typicode.json");
       //We need Object Mapper class to write inside the file
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootnode= mapper.readTree(response.asString());
        mapper.writeValue(fData,rootnode);
        //parsing Using Jsonpath
        JsonPath jpath = new JsonPath(response.asString());
        List<Integer> list=jpath.get("userId");
        System.out.println(list);
        String title;
        for(int index=0;index<list.size();index++){
            if(list.get(index)==7){
            System.out.println("True");
            title=jpath.get("title["+index+"]");
            System.out.println(title);
            }
        }

        //parsing using Jaction
        List<JsonNode> list1=new ArrayList<>();
        if(rootnode.isArray()){
            int size=rootnode.size();
            for(int i=0;i<size;i++){
               JsonNode node=rootnode.get(i).get("userId");
                if(node.toString().equals("7")){
                    System.out.println("True");
               JsonNode titlenode=rootnode.get(i).get("title");
               System.out.println(titlenode);
                }

            }

        }
    }
}
