package CloudContainers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import CloudContainers.Client;
import CloudContainers.ClientDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition{
	

	Client client2;
	Client client3;
	ResponseObject response;
	LogisticCompany lc = new LogisticCompany("Maersk",1,100);
	
	
	@Given("A none existing client")
	public void a_none_existing_client(){
	    assertFalse(lc.exist(1));
	}
	
	
	@When("Informations is entered")
	public void informations_is_entered() {
	}
	
	@Then("display success message")
	public void display_success_message() {
		response = lc.newClient("Bob1","bigman1@dtu.dk","11-02-1994","male",10101010,"1234");
		assertTrue(lc.exist(1));
		assertEquals(response.getErrorMessage(),"Client was successfully added");
	}
	
	@Given("existing client")
	public void existing_client() {
		lc.newClient("Bob1","bigman1@dtu.dk","11-04-1995","male",10101010,"1234");
		assertTrue(lc.exist(1));
	}
	
	@When("repeated information is entered")
	public void repeated_information_is_entered() {
		response = lc.newClient("Bob2","bigman1@dtu.dk","11-04-1995","male",10101010,"1234");
	}

	@Then("error message is thrown")
	public void error_message_is_thrown() {
		assertEquals(response.getErrorMessage(),"existing client");
		
	}
	
	@When("information with missing parameters")
	public void information_with_missing_parameters() {
		response = lc.newClient("Bob3","bigman3@dtu.dk","","male",10101010,"1234");
	}

	@Then("missing parameter error message is thrown")
	public void missing_parameter_error_message_is_thrown() {
		assertEquals(response.getErrorMessage(),"There is a missing parameter");
		
	}
	
	@Given("A logistic company")
	public void a_logistic_company() {
		
	}

	@When("invalid email {string} is entered")
	public void invalid_email_is_entered(String string) {
		response = lc.newClient("Bob4",string,"11-04-1995","male",10101010,"1234");
	}

	@Then("invalid email error is displayed for {string}")
	public void invalid_email_error_is_displayed_for(String string) {
		assertEquals(response.getErrorMessage(),string + " is not a valid email");
	}

	@When("invalid birthdate {string} is entered")
	public void invalid_birthdate_is_entered(String string) {
		response = lc.newClient("Bob5","bigman5@dtu.dk",string,"male",10101010,"1234");
	}

	@Then("invalid birtdate error is displayed for {string}")
	public void invalid_birtdate_error_is_displayed_for(String string) {
	    assertEquals(response.getErrorMessage(),string + " is not a valid birthdate");
	}

	
	// _________________________________________Update Info________________________________________________
	
	Client client1 = new Client("Karsten",1,"smallmoney123@gmail.com","24-05-1998","male",10101010,lc.getName(),"1234");
	@Given("A client with email {string}")
	public void a_client_with_email(String string) {
		lc.newClient("Karsten",string,"24-05-1998","male",10101010,"1234");
		
	}
	
	@When("New email entered as {string}")
	public void new_email_entered_as(String string) {
		response = lc.updateClient(client1.getEmail(),string);
	}
	
	@Then("Display email update success message")
	public void display_email_update_success_message() {
		assertEquals(response.getErrorMessage(),"Email has been updated");
	}

	@Given("A client with phone number {int}")
	public void a_client_with_phone_number(Integer int1) {
		lc.newClient("Jenny","bigstonks123@gmail.com","27-10-1987","female",int1,"1234");
	}

	@When("A client with email {string} New phone number entered as {int}")
	public void a_client_with_email_new_phone_number_entered_as(String email,Integer int1) {
		response = lc.updateClient(email, int1);
	}

	@Then("Display phonenumber update success message")
	public void display_phonenumber_update_success_message() {
		System.out.println(response.getErrorMessage());
		assertEquals(response.getErrorMessage(),"Phone number has been updated");
		
	}
	
	// _________________________________________Search Client________________________________________________

	
	Client client4;
	
	@Given("A client with the email {string}")
	public void a_client_with_the_email(String string) {
		client4 = new Client("Jenny",1,string,"02-02-1998","female",10101010,lc.getName(),"1234");
		lc.newClient("Jenny",string,"02-02-1998","female",10101010,"1234");
	}

	@When("The logistic company searches for {string}")
	public Client the_logistic_company_searches_for(String string) {
	    return lc.findClient(string);
	}

	@Then("The client is returned for {string} and a succes message is displayed")
	public void the_client_is_returned_for_and_a_succes_message_is_displayed(String string) {
		Client c = the_logistic_company_searches_for(string);
		assertTrue(lc.exist(c.getClientID()));
		c.print();
	}

	
	
	@Given("A client with the clientID {int}")
	public void a_client_with_the_clientID(Integer int1) {
		client4 = new Client("Jenny",1,"email123@mail.dk","11-10-1992","female",10101010,lc.getName(),"1234");
		lc.newClient("Jenny","email123@mail.dk","11-10-1992","female",10101010,"1234");
	}

	@When("The logistic company searches for {int}")
	public Client the_logistic_company_searches_for(Integer int1) {
		return lc.findClient(int1);
	}

	@Then("The client is returned for {int} and a succes message is displayed")
	public void the_client_is_returned_for_and_a_succes_message_is_displayed(Integer int1) {
		Client c = the_logistic_company_searches_for(int1);
		assertTrue(lc.exist(c.getClientID()));
		c.print();
	}
	
	@Given("A none existing client for email search")
	public void a_none_existing_client_for_email_search() {
	}

	@Given("A none existing client for ID search")
	public void a_none_existing_client_for_ID_search() {
	   
	}
	@When("The logistic company searches {string}")
	public void the_logistic_company_searches(String string) {
		lc.findClient(string);
	}

	@When("The logistic company searches {int}")
	public void the_logistic_company_searches(Integer int1) {
		lc.findClient(int1);
	}
	
	@Then("A failure message is returned for {int}")
	public void a_failure_message_is_returned_for(Integer int1) {
		assertTrue(lc.findClient(int1).getClientID() == 0);
	}
	@Then("A failure message is returned for {string}")
	public void a_failure_message_is_returned_for(String string) {
		assertTrue(lc.findClient(string).getClientID() == 0);
		
	}

// _________________________________________Remove Client________________________________________________
	
	
	
	@Given("A logistic company that has a client with clientID {int}")
	public void a_logistic_company_with_a_client_with_clientID(Integer int1) {
		lc.newClient("Jenny","j1@gmail.com","11-10-1998","female",12345678,"1234");
		assertTrue(lc.exist(int1));
	}

	@When("the logistic company removes a client with the clientID {int}")
	public void the_logistic_company_removes_a_client_with_the_clientID(Integer id) {
	    lc.removeClient(id);
	}
	
	@Given("A logistic company that has a client with an email {string}")
	public void a_logistic_company_that_has_a_client_with_an_email(String string) {
		lc.newClient("Jenny",string,"11-10-1998","female",12345678,"1234");
		assertTrue(lc.exist(string));
	}

	@When("the logistic company removes a client with an email {string}")
	public void the_logistic_company_removes_a_client_with_an_email(String string) {
	    lc.removeClient(string);
	}

	@Then("the client is deleted and succes message is displayed clientID {int}")
	public void the_client_is_deleted_and_succes_message_is_displayed_clientID(Integer int1) {
	    assertFalse(lc.exist(int1));
	}

	@Then("the client is deleted and succes message is displayed email {string}")
	public void the_client_is_deleted_and_succes_message_is_displayed_email(String string) {
	    assertFalse(lc.exist(string));
	}


	@Given("A none existing client for remove")
	public void a_none_existing_client_for_remove() {
	    
	}

	@When("the logistic company removes a client with clientID {int}")
	public void the_logistic_company_removes_a_client_with_clientID(Integer int1) {
	    lc.removeClient(int1);
	}
	
	@Then("A remove failure message is returned for {string}")
	public void a_remove_failure_message_is_returned_for(String string) {
	    assertFalse(lc.removeClient(string));
	}

	@Then("A remove failure message is returned for {int}")
	public void a_remove_failure_message_is_returned_for(Integer int1) {
		assertFalse(lc.removeClient(int1));
	}
	// _________________________________________Add container to journey________________________________________________
	
	Client client;
	Container container;
	@Given("a logistic company with a client")
	public void a_logistic_company_with_a_client() {
		client = new Client("Jenny",1,"email@dtu.dk","11-10-1998","female",12345678,lc.getName(),"1234");
		lc.newClient("Jenny","email@dtu.dk","11-10-1998","female",12345678,"1234");
	    assertTrue(lc.exist("email@dtu.dk"));
	}
	
	@Given("an unowned container")
	public void an_unowned_container() {
		container = lc.findFreeContainer();
		assertTrue(!container.isOwned() && container.getContainerId() != 0);
		
	}
	
	@When("a container is allocated")
	public void a_container_is_allocated() {
		response = lc.allocateContainer(1,container);
		
	    
	}

	@Then("an allocation succes message is displayed")
	public void an_allocation_succes_message_is_displayed() {
		
		assertTrue(response.getErrorMessage().equals("Container succesfully allocated"));
		
		assertTrue((lc.getContainerDatabase()).getContainer(container.getContainerId()).getClientId() == 1);		
		assertTrue(container.isOwned());

	}


	@Given("a logistic company with another client")
	public void a_logistic_company_with_another_client() {
	    client2 = new Client("Bobby",2,"slat@dtu.dk","11-12-1999","male",88888888,lc.getName(),"1234");
	    lc.newClient("Bobby","slat@dtu.dk","11-12-1999","male",88888888,"1234");
	    assertTrue(lc.exist("slat@dtu.dk"));
	}
	
	@Given("an owned container")
	public void an_owned_container() {
		container = lc.findFreeContainer();
		client1 = new Client("Jenny",1,"email@dtu.dk","11-10-1998","female",12345678,lc.getName(),"1234");
		lc.newClient("Jenny","email@dtu.dk","11-10-1998","female",12345678,"1234");
		response = lc.allocateContainer(1,container);
	    assertTrue(container.isOwned());
	}
	
	@When("a logistic company tries to allocate container")
	public void a_container_is_not_allocated() {
	    response = lc.allocateContainer(2, container);
	}

	@Then("an allocation failure message is displayed")
	public void an_allocation_failure_message_is_displayed() {
		assertTrue(response.getErrorMessage().equals("This container is already owned by a client"));
		assertTrue((lc.getContainerDatabase()).getContainer(container.getContainerId()).getClientId() == 1);		
		assertTrue(container.isOwned());
	}
	
	
	@Given("a container that does not exist")
	public void a_container_that_does_not_exist() {
	    container = new Container(0);
	}
	@When("a logistic company tries to allocate container to client")
	public void a_container_is_not_allocated_to_client() {
	    response = lc.allocateContainer(1, container);
	}
	
	@Then("an allocation failure message is displayed saying container does not exist")
	public void an_allocation_failure_message_is_displayed_saying_container_does_not_exist() {
		assertTrue(response.getErrorMessage().equals("Container does not exist"));
		assertFalse(container.isOwned());
	}
	
	@Given("a logistic company with a non-registered client")
	public void a_logistic_company_with_a_non_registered_client() {
	    client = new Client("Lizzy",0,"liz@gmail.dk","20-10-1998","female",21436587,lc.getName(),"1234");
	}

	@Then("an allocation failure message is displayed saying client does not exist")
	public void an_allocation_failure_message_is_displayed_saying_client_does_not_exist() {
		assertTrue(response.getErrorMessage().equals("Client does not exist"));
		assertFalse(container.isOwned());
	}
	
	// ____________________________________containerOnJourney____________________________________________
	Journey journey;
	@Given("a logistic company with a registered client")
	public void a_logistic_company_with_a_registered_client() {
		client = new Client("Jenny",1,"email@dtu.dk","11-10-1998","female",12345678,lc.getName(),"1234");
		lc.newClient("Jenny","email@dtu.dk","11-10-1998","female",12345678,"1234");
	    assertTrue(lc.exist(client.getEmail()));
	}

	@Given("a container owned by the client")
	public void a_container_owned_by_the_client() {
		container = lc.findFreeContainer();
		lc.allocateContainer(client.getClientID(),container);
	}

	@Given("a valid journey")
	public void a_valid_journey() {
	    journey = new Journey(1, "Texas", "Zimbabwe", lc.getName(),0);
	    lc.createJourney(journey.getPortOfOrigin(), journey.getDestination(),50);
	}

	@When("logistic company tries to put container on journey")
	public void logistic_company_tries_to_put_container_on_journey() {
	    response = lc.containerToJourney(client.getClientID(), container, journey.getJourneyID(), "Bananas");
	    
	}
	Journey journey2;
	@Then("success message is displayed")
	public void success_message_is_displayed() {
	    assertTrue(response.getErrorMessage().equals("Container successfully added to journey"));
	    assertTrue(container.isOnJourney());
	    assertTrue(container.isOwned());
	}
	

	@Given("an available container")
	public void an_available_container() {
	    container = lc.findFreeContainer();
	}

	@Then("error message displayed saying that client does not exist")
	public void error_message_displayed_saying_that_client_does_not_exist() {
	    assertTrue(response.getErrorMessage().equals("Client does not exist"));
	    assertFalse(container.isOnJourney());
	    assertFalse(container.isOwned());
	}
	
	@Given("an available container not owned by client")
	public void an_available_container_not_owned_by_client() {
		container = lc.findFreeContainer();
	}

	@Then("error message displayed saying that container does not exist")
	public void error_message_displayed_saying_that_container_does_not_exist() {
	    assertTrue(response.getErrorMessage().equals("Container does not belong to client"));
	    assertFalse(container.isOnJourney());
	    assertFalse(container.isOwned());
	}
	
	@Given("a non-registered journey")
	public void a_non_registered_journey() {
	    journey = new Journey(0,"North Korea","USA","Kim",0);
	}

	@Then("error message displayed saying that journey does not exist")
	public void error_message_displayed_saying_that_journey_does_not_exist() {
	    assertTrue(response.getErrorMessage().equals("Journey does not exist"));
	    assertFalse(container.isOnJourney());
	    assertTrue(container.isOwned());
	}
	
	// _____________________________updateJourney_____________________________________________________
	
	@Given("A logistic company with a registered journey with PoO of {string}")
	public void a_logistic_company_with_a_registered_journey_with_PoO_of(String string) {
		lc = new LogisticCompany("Maersk",1,100);
		lc.createJourney(string, "Copenhagen",50);
	}

	@When("the logistic company tries to update port of origin to {string}")
	public void the_logistic_company_tries_to_update_port_of_origin_to(String string) {
	    response = lc.updateJourneyPortOfOrigin(1, string);
	}

	@Then("success message is displayed for port of origin {string}")
	public void success_message_is_displayed_for_port_of_origin(String string) {
	    assertEquals(response.getErrorMessage(),string + " successfully updated as port of origin");
	}

	@Given("A logistic company with a registered journey with destination of {string}")
	public void a_logistic_company_with_a_registered_journey_with_destination_of(String string) {
	    lc.createJourney("Bahamas", string,50);
	}

	@When("the logistic company tries to update destination to {string}")
	public void the_logistic_company_tries_to_update_destination_to(String string) {
	    response = lc.updateJourneyDestination(1, string);
	}

	@Then("success message is displayed for destination {string}")
	public void success_message_is_displayed_for_destination(String string) {
	    assertEquals(response.getErrorMessage(),string +  " successfully updated as destination");
	}

	@Given("A logistic company with a non-registered journey with destination {string}")
	public void a_logistic_company_with_a_non_registered_journey_with_destination(String string) {
	    journey = new Journey(1,"Bahamas",string,"Hellman",0);
	    assertFalse(lc.existJ(1));
	}

	@Then("error message is displayed saying journey does not exist")
	public void error_message_is_displayed_saying_journey_does_not_exist() {
	    assertEquals(response.getErrorMessage(),"Journey does not exist");
	}

	// ______________________________filterJourney___________________________________________________
	Set<Journey> filtered;
	@Given("a journeys with port of origin {string}, {string} and {string}")
	public void a_journeys_with_port_of_origin_and(String string, String string2, String string3) {
	    lc.createJourney(string, "Copenhagen",50);
	    lc.createJourney(string2, "Copenhagen",50);
	    lc.createJourney(string3, "Copenhagen",50);
	}

	@When("journeys are filtered for {string}")
	public void journeys_are_filtered_for(String string) {
		filtered = lc.getJourneyDatabase().filterPortOfOrigin(string);
	}

	@Then("display filtered set of journeys with port of origin {string}")
	public void display_filtered_set_of_journeys_with_port_of_origin(String string) {
		for (Journey j : filtered) {
			assertTrue(j.getPortOfOrigin().equals(string));
		}
	}
	
	
	@Given("a journeys with destination {string}, {string} and {string}")
	public void a_journeys_with_destination_and(String string, String string2, String string3) {
	    lc.createJourney("Copenhagen", string,50);
	    lc.createJourney("Copenhagen", string2,50);
	    lc.createJourney("Copenhagen", string3,50);
	}
	
	@When("journeys are filtered for destination {string}")
	public void journeys_are_filtered_for_destination(String string) {
		filtered = lc.getJourneyDatabase().filterDestination(string);
	}
	
	@Then("display filtered set of journeys with destination {string}")
	public void display_filtered_set_of_journeys_with_destination(String string) {
		for (Journey j : filtered) {
			assertTrue(j.getDestination().equals(string));
		}
	}
	
	@Then("get empty set")
	public void get_empty_set() {
	    assertEquals(filtered.size(),0);
	}
	
	// ______________________________endJourney____________________________________________________
	
	@Given("a logistic company with a registered journey from {string} to {string}")
	public void a_logistic_company_with_a_registered_journey_from_to(String string, String string2) {
	    lc.createJourney(string, string2,50);
	}

	@Given("one container with {string} allocated to a client with email {string} added to the journey")
	public void one_container_with_allocated_to_a_client_with_email_is_added_to_the_journey(String string, String string2) {
	    container = lc.findFreeContainer();
	    lc.newClient("Jenny",string2,"11-10-1998","female",12345678,"1234");
	    lc.allocateContainer(1, container);
	    lc.containerToJourney(1, container, 1, string);
	}

	@When("logistic company tries to end journey")
	public void logistic_company_tries_to_end_journey() {
	    response = lc.endJourney(1);
	}

	@Then("message displayed saying journey successfully ended for {int} containers")
	public void message_displayed_saying_journey_successfully_ended_for_containers(Integer int1) {
		assertEquals(response.getErrorMessage(),"Journey successfully ended. " + int1 + " containers were set free.");
	    assertFalse(container.isOnJourney());
	}
	
	
	@Given("a logistic company with a non-registered journey")
	public void a_logistic_company_with_a_non_registered_journey() {
		journey = new Journey(1,"Bahamas","Copenhagen","Hellman",0);
	    assertFalse(lc.existJ(1));
	}
	
	@Given("a container allocated to a client is added to the journey pt2")
	public void a_container_allocated_to_a_client_is_added_to_the_journey_pt2() {
	    container = lc.findFreeContainer();
	    lc.newClient("Jenny","email@dtu.dk","11-10-1998","female",12345678,"1234");
	    lc.allocateContainer(1, container);
	    response = lc.containerToJourney(1, container, 1, "Bananas");
	    assertEquals(response.getErrorMessage(),"Journey does not exist");
	}

	@Then("error message displayed saying journey does not exist")
	public void error_message_displayed_saying_journey_does_not_exist() {
		assertEquals(response.getErrorMessage(),"No such journey exist");
	    assertFalse(container.isOnJourney());
	}
	// ____________________________freeContainer______________________________________________________
	Container container1;
	Container container2;
	Container container3;
	@Given("one container registered to the client")
	public void one_container_registered_to_the_client() {
		container1 = lc.findFreeContainer();
		lc.allocateContainer(1, container1);

		
	}

	@When("logistic company frees one container")
	public void logistic_company_frees_one_container() {
	    response = lc.freeContainer(container1.getContainerId());
	    
	}

	@Then("A succes message is displayed for freeing a container")
	public void a_succes_message_is_displayed_for_freeing_a_container() {

	    assertEquals(response.getErrorMessage(),"Container was successfully freed");
	}
	@Given("the container is put on the journey containing {string}")
	public void the_container_is_put_on_the_journey_containing(String string) {
		lc.containerToJourney(1, container1, 1, string);
	}

	@Then("A error message is displayed that container is on journey")
	public void a_error_message_is_displayed_that_container_is_on_journey() {
	    assertEquals(response.getErrorMessage(),"This container is on a journey");
	}
	@Given("one container")
	public void one_container() {
		container1 = lc.findFreeContainer();
	}
	
	@Then("A error message is displayed as container is not owned")
	public void a_error_message_is_displayed_as_container_is_not_owned() {
		assertEquals(response.getErrorMessage(),"This container does not belong to a client");
	}
	
	// ____________________________runJourney______________________________________________________

	@Given("a logistic company with a journey from {string} to {string}  with {int} hours to destination")
	public void a_logistic_company_with_a_journey_to_at_time_hours(String string1, String string2,Integer int1) {
		lc.createJourney(string1, string2,int1);
	}

	@Given("a registered client with email {string}")
	public void a_registered_client_with_email(String string1) {
		
		lc.newClient("Jenny",string1,"11-10-1998","female",12345678,"1234");
	}

	@Given("three containers registered to the client")
	public void three_containers_registered_to_the_client() {
		container1 = lc.findFreeContainer();
		lc.allocateContainer(1, container1);
		container2 = lc.findFreeContainer();
		lc.allocateContainer(1, container2);
		container3 = lc.findFreeContainer();
		lc.allocateContainer(1, container3);
	}
	@Given("the containers are put on the journey containing {string}, {string} and {string} respectively")
	public void the_containers_are_put_on_the_journey_containing_and_respectively(String string, String string2, String string3) {
		lc.containerToJourney(1, container1, 1, string);
	    lc.containerToJourney(1, container2, 1, string2);
	    lc.containerToJourney(1, container3, 1, string3);
	}
	
	
	@When("journey is started and run for {int} hours")
	public void journey_is_started_and_run_for_hours(Integer int1) {
	    response = lc.progressJourney(1,int1);
	}
	
	@Then("journey elapsed time is updated to {int} hours")
	public void journey_elapsed_time_is_updated_to_hours(Integer int1) {
	    assertTrue(lc.getJourneyDatabase().getJourney(1).getElapsedTime()==int1);
	    
	}

	@Then("data has been collected up till {int} hours")
	public void data_has_been_collected_up_till_hours(Integer int1) {
		ArrayList<statusTrackingObject> list;
		list = lc.getJourneyDatabase().getJourney(1).getStatusData();
		assertTrue(list.get(list.size()-1).getTime() == int1);
	}

	@Then("a succes response is given for journey {int} elapsed time {int}")
	public void a_succes_response_is_given_for_journey_elapsed_time(Integer int1, Integer int2) {
	    assertEquals(response.getErrorMessage(),"Your container on journey " + int1 + " has traveled " + int2 + " hours.");
	}
	@Given("a logistic company with a journey from {string} to {string} with {int} hours to destination")
	public void a_logistic_company_with_a_journey_from_to_with_hours_to_destination(String string, String string2, Integer int1) {
		lc.createJourney(string, string2,int1);
	}
	@Then("a response is returned that the journey has ended for journey {int} after {int} hours")
	public void a_response_is_returned_that_the_journey_has_ended_for_journey_after_hours(Integer int1, Integer int2) {
	    assertEquals(response.getErrorMessage(),"Your container on journey " + int1 + " has traveled " + int2 + " hours and the journey has ended.");
	}
	
	@Then("no data has been collected")
	public void no_data_has_been_collected() {
		ArrayList<statusTrackingObject> list;
		list = lc.getJourneyDatabase().getJourney(1).getStatusData();
		assertTrue(list.size() == 0);
	}

	@Then("a response is returned that the journey has no containers")
	public void a_response_is_returned_that_the_journey_has_no_containers() {
		assertEquals(response.getErrorMessage(),"No containers are on this journey");
	}
	
	
	
	@Then("a response is given for travel time too low")
	public void a_response_is_given_for_travel_time_too_low() {
	    assertEquals(response.getErrorMessage(), "Travel time has to be a more than 0");
	}
	
	// ____________________________accessData______________________________________________________
	
	@When("client {int} request the data for his container")
	public void client_request_the_data_for_his_container(Integer clientID) {
	    response = lc.accessStatus(clientID,container1.getContainerId());
	}

	@Then("the status of the container is returned")
	public void the_status_of_the_container_is_returned() {
	    assertTrue(response.getStatus().getTime() != 0);
	}

	@Then("a succes for data access is displayed")
	public void a_succes_for_data_access_is_displayed() {
	    assertEquals(response.getErrorMessage(),"This is the current status of your container");
	}
	
	@When("client {int} request the data for a container with ID {int}")
	public void client_request_the_data_for_a_container_with_ID(Integer int1, Integer int2) {
	    response = lc.accessStatus(int1, int2);
	}

	@Then("a error message is returned for data acces")
	public void a_error_message_is_returned_for_data_acces() {
	    assertEquals(response.getErrorMessage(),"You don't own this container");
	}
	@Then("a error message is returned for journey has not started")
	public void a_error_message_is_returned_for_journey_has_not_started() {
	    assertEquals(response.getErrorMessage(),"Ship's still at harbour");
	}

	
}