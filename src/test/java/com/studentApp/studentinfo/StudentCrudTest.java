package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import com.studentApp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
public class StudentCrudTest extends TestBase
{
    static String firstName = "PrimUser" + TestUtils.getRandomValue();
    static String lastName = "PrimeUser" + TestUtils.getRandomValue();
    static String programme = "API Testing";
    static String email = TestUtils.getRandomValue() + "abc@gmail.com";
    static int studentId;
    @Test
    public void post()
    {
        List<String>course=new ArrayList<>();
        course.add("Python");
        course.add("Selenium");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(course);
        Response response=given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void get()
    {
        String s1="findAll{it.firstName=='";
        String s2="'}.get(0)";
        HashMap<String, Object>value=
                given()
                        .when()
                        .get("/list")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(s1+firstName+s2);
        System.out.println(value);
        studentId=(int)value.get("id");
    }
    @Test
    public void put()
    {
        String s1="findAll{it.firstName=='";
        String s2="'}.get(0)";
        firstName = firstName + "_Updated";
        List<String> courseList = new ArrayList<>();
        courseList.add("Scala");
        courseList.add("Java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);

        given()
                .header("Content-Type", "application/json")
                .pathParam("studentID", studentId)
                .body(studentPojo)
                .when()
                .put("/{studentID}")
                .then().log().all().statusCode(200);
        HashMap<String, Object> value =
                given()
                        .when()
                        .get("/list")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(s1 + firstName + s2);
        System.out.println(value);
    }
    @Test
    public void delete()
    {
        given()
                .pathParam("studentID",studentId)
                .when()
                .delete("/{studentID}")
                .then()
                .statusCode(204);
        given()
                .pathParam("studentID",studentId)
                .when()
                .get("/{studentID}")
                .then()
                .statusCode(404);
    }
}
