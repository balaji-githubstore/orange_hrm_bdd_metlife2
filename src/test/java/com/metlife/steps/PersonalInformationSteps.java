package com.metlife.steps;

import com.metlife.base.AutomationHooks;
import com.metlife.base.DataTrasfer;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class PersonalInformationSteps {

    private final DataTrasfer transfer;
    private AutomationHooks hooks;

    public PersonalInformationSteps(AutomationHooks hooks, DataTrasfer trasfer)
    {
        this.hooks=hooks;
        this.transfer=trasfer;
    }

    @Then("I should see the same data in personal information section")
    public void i_should_see_the_same_data_in_personal_information_section() {
        List<Map<String, String>> ls = transfer.empDatable.asMaps();

        String firstName = ls.get(0).get("firstname");
        String middleName = ls.get(0).get("middlename");
        String lastname = ls.get(0).get("lastname");
        String empId = ls.get(0).get("employee_id");
        String toggleCreateLogin = ls.get(0).get("toggle_create_login");
        String userName = ls.get(0).get("username");
        String password = ls.get(0).get("password");
        String confirmPassword = ls.get(0).get("confirm_password");
        String status = ls.get(0).get("status");
    }


}
