package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;
import utilities.EndPoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckTest implements EndPoints {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigurationReader.get("deckApiBaseURL");
    }

    @Test
    public void creatDeck() {
        given()
                .queryParam("jokers_enabled","true")
                .when()
                .get(NEW_DECK)
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(54));

    }

    @Test
    public void drawDeck() {
        // Initially I create first call and get the deck_id and stored in a String
       JsonPath json =
                given()
                        .queryParam("jokers_enabled","true")
                        .when()
                        .get(NEW_DECK).jsonPath();
        String cardID = json.getString("deck_id");

        given()
                .queryParam("jokers_enabled","true")
                .queryParam("count", 4)
                .pathParam("id",cardID)
                .when()
                .get("deck/{id}/draw/")
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(50));
    }
}
