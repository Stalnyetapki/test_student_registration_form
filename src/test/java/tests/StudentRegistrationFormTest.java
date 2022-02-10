package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        File picture = new File("src/test/java/tests/kek.png");

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Karl");
        $("#lastName").setValue("Marx");
        $("#userEmail").setValue("karlmarx@test.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9012709898");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1917");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("kek.png");
        $("#currentAddress").setValue("Praha");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Karl Marx"),
                text("karlmarx@test.ru"),
                text("Male"),
                text("9012709898"),
                text("25 October,1917"),
                text("English"),
                text("Sports"),
                text("kek.png"),
                text("Praha"),
                text("NCR Delhi"));
    }
}
