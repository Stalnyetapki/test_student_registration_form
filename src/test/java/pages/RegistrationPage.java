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

    public RegistrationPage setGender(String gender) {
        genderRadiobutton.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesInput.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setPicture(String picture) {
        pictureUploadInput.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage checkPopupAppearance() {
        popupTitle.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public void sendForm() {
        submitButton.click();
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsForm.$(byText(fieldName)).parent().shouldHave(text(value));

        return this;
    }

}
