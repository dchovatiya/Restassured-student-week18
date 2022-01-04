package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class StudentDeleteTest extends TestBase
{
    @Test
    public void deleteStudentRecord()
    {
        StudentPojo studentPojo=new StudentPojo();
        Response response=given()
                .header("Content-Type", "application/json")
                .pathParam("id",5)
                .body(studentPojo)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
