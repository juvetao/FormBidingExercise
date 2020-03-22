package se.ecutb.cheng.exercises.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

import static se.ecutb.cheng.exercises.constants.messages.ValidationMessages.*;
import static se.ecutb.cheng.exercises.constants.regex.RegexStorage.*;

public class CustomerFormDto {
    @NotBlank(message = "Field email is required")
    @Email(regexp = EMAIL_REGEX, flags = Pattern.Flag.CASE_INSENSITIVE, message = EMAIL_FORMAT_MESSAGE)
    private String email;

//    @NotBlank(message = "Field reg date is required")
//    @Past(message = REG_DATE_ERROR)
//    private LocalDate regDate;
//
//    @NotBlank(message = "Field active is required")
////    @AssertTrue
//    private boolean active;

    @NotBlank(message = "Field street is required")
    private String street;

    @NotBlank(message = "Field street is required")
    @Size(min = 5, max = 5, message = ZIP_CODE_SIZE)
    private String zipCode;

    @NotBlank(message = "Field city is required")
    private String city;

    @NotBlank(message = "Field home phone is required")
    @Pattern(regexp = SWEDISH_PHONE_NUMBER_REGEX, message = SWEDISH_PHONE)
    private String homePhone;

    @NotBlank(message = "Field cell phone is required")
    @Pattern(regexp = SWEDISH_CELL_NUMBER_REGEX, message = SWEDISH_PHONE)
    private String cellPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDate getRegDate() {
//        return regDate;
//    }
//
//    public void setRegDate(LocalDate regDate) {
//        this.regDate = regDate;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }


}
