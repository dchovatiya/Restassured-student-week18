package com.studentApp.studentinfo;

import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

/**
 * By Dimple Patel
 **/
public class StudentGetTest extends TestBase
{
    @Test
    public void getAllStudentsInformation()
    {
        Response response=given()
                .when()
                .get("/list"); //end point in .get
        response.then().statusCode(200); //validating in then
        response.prettyPrint();
    }
    @Test
    public void getSingleStudentInformation()
    {
        Response response=given()
                .pathParam("id",10)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void searchStudentWithParameter()
    {
        //using generic will consume more memory, use specific if you do no need general
        HashMap<String,Object> params=new HashMap<>();
        params.put("courses","Accounting");
        params.put("courses","Statistics");
        params.put("limit","3");
        Response response=given()
                .queryParams(params)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void searchStudentWithParameterOne()
    {
        //using generic will consume more memory, use specific if you do no need general
        HashMap<String,Object> params=new HashMap<>();
        params.put("programme","Computer Science");
        params.put("limit","-2");
        Response response=given()
                .queryParams(params)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
