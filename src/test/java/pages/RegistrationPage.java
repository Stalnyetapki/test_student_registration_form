package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
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
            mailInput = $("#userEmail"),
            genderRadiobutton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            popupTitle = $("#example-modal-sizes-title-lg");


    //actions
    @Step("Open \"/automation-practice-form\" page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    @Step("Enter First Name in input")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Enter Last Name in input")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Enter user's email ")
    public RegistrationPage setMail(String mail) {
        mailInput.setValue(mail);

        return this;
    }

    @Step("Select user's gender")
    public RegistrationPage setGender(String gender) {
        genderRadiobutton.$(byText(gender)).click();

        return this;
    }

    @Step("Enter user's phone number")
    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    @Step("Select subject")
    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Select hobby")
    public RegistrationPage setHobby(String hobby) {
        hobbiesInput.$(byText(hobby)).click();

        return this;
    }

    @Step("Upload picture")
    public RegistrationPage setPicture(String picture) {
        pictureUploadInput.uploadFromClasspath(picture);

        return this;
    }

    @Step("Enter user's address")
    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    @Step("Select user's state")
    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    @Step("Select user's city")
    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    @Step("Checking that successful sending popup has been appeared")
    public RegistrationPage checkPopupAppearance() {
        popupTitle.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Send Registration Form")
    public void sendForm() {
        submitButton.click();
    }

    @Step("Select user's birth date")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Checking if the sent data matches the data in the appeared popup")
    public RegistrationPage checkForm(String fieldName, String value) {
        resultsForm.$(byText(fieldName)).parent().shouldHave(text(value));

        return this;
    }

}
