package steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("user is not logged in")
    public void user_login(){
        System.out.println("User is not logged in");
    }
    @When("user enters {string} and {string}")
    public void user_credentials_entered(String name,String password){
        System.out.println("User credentials entered : "+name+" "+password);
        boolean answer = name.equals("Ana");
    }
    @And("clicks login button")
    public void click_login_button(){
        System.out.println("Clicks login button");
    }
    @Then("user is navigated to home page")
    public void user_login_result(){
        System.out.println("User logged in");
    }
    @When("get users")
    public void get_users(){
        System.out.println("Entered wrong username and password");
    }
    @Then("user receives error message")
    public void user_login_error(){
        System.out.println("Wrong Credentials");
    }

}
