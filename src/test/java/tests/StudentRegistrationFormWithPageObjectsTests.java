package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class StudentRegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Karl";
    String lastName = "Marx";
    String mail = "karlmarx@test.ru";
    String gender = "Male";
    String mobile = "9012709898";
    String dayOfBirth = "25";
    String monthOfBirth = "October";
    String yearOfBirth = "1917";
    String subjects = "English";
    String hobbies = "Sports";
    String picture = "kek.png";
    String address = "Praha";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {

        //open form and input data
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMail(mail);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        registrationPage.setBirthDate("25", "October", "1917");
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //compare input data with output data
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", mail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", mobile)
                .checkForm("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", picture)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city);

    }
}
