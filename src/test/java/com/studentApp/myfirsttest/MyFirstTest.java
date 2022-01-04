package com.studentApp.myfirsttest;

import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class MyFirstTest extends TestBase
{
    @Test
    public void getAllStudentInformation()
    {
        Response response = given()
                .when()
                .get("http://localhost:8080/student/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
