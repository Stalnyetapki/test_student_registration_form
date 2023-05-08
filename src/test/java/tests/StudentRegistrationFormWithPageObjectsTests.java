package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class StudentRegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Karl";
    String lastName = "Marx";
    String mail = "karlmarx@test.ru";
    String gender = "Male";
    String phoneNumber = "9012709898";
    String dayOfBirth = "25";
    String monthOfBirth = "October";
    String yearOfBirth = "1917";
    String subject = "English";
    String hobby = "Sports";
    String nameOfPicture = "kek.png";
    String address = "Praha";
    String state = "NCR";
    String city = "Delhi";


    @Test
    @DisplayName("Verify that submitting a form and receiving a response works")
    void successFillTest() {

        //open form and input data
        step("Open form, fill and send it", () -> {
            registrationPage
                    .openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setMail(mail)
                    .setGender(gender)
                    .setBirthDate("25", "October", "1917")
                    .setPhoneNumber(phoneNumber)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .setPicture(nameOfPicture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .sendForm();
        });

        //compare input data with output data
        step("Compare input data with output data", () -> {
            registrationPage
                    .checkPopupAppearance()
                    .checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", mail)
                    .checkForm("Gender", gender)
                    .checkForm("Mobile", phoneNumber)
                    .checkForm("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkForm("Subjects", subject)
                    .checkForm("Hobbies", hobby)
                    .checkForm("Picture", nameOfPicture)
                    .checkForm("Address", address)
                    .checkForm("State and City", state + " " + city);
        });
    }
}
