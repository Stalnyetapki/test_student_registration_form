package pages;

import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsForm = $(".table-responsive"),
            mailInput = $("#userEmail");

    //actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setMail(String mail) {
        mailInput.setValue(mail);

        return this;
    }

    public void setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsForm.$(byText(fieldName)).parent().shouldHave(text(value));

        return this;
    }

}
