package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import com.studentApp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class StudentPostTest extends TestBase
{

    @Test
    public void createStudentRecord()
    {
        List<String> list = new ArrayList<>();
        list.add("Selenium Test");
        list.add("Api Testing");

        StudentPojo studentPojo =  new StudentPojo();
        studentPojo.setFirstName("Dimple");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("patel123@yahoo.com");
        studentPojo.setProgramme("Test Engineer");
        studentPojo.setCourses(list);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
