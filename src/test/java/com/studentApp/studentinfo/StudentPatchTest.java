package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class StudentPatchTest extends TestBase
{
    @Test
    public void updateStudentRecordWithPatch()
    {
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setEmail("param123@yahoo.com");
        Response response=given()
                .header("Content-Type", "application/json")
                .pathParam("id", 104)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
