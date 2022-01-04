package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class StudentPutTest extends TestBase
{
    @Test
    public void updateStudentRecordWithPut()
    {
        List<String> list = new ArrayList<>();
        list.add("Manual Testing");
        list.add("API Testing");

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Param");
        studentPojo.setLastName("Shah");
        studentPojo.setEmail("prime123@yahoo.com");
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(list);
        Response response=given()
                .header("Content-Type", "application/json")
                .pathParam("id", 104)
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
