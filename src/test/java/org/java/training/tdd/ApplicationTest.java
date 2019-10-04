package org.java.training.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.java.training.tdd.model.StudentNames;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplateTest;

    @LocalServerPort
    private int port;
    
    private String getRootUrl() {
        return "http://localhost:" + "8089";
    }
    @Test
    public void contextLoads() {

    }
    
    @Test
    void jsonResponseAsString() {
    	
        ResponseEntity<JSONObject> response = restTemplateTest.getForEntity(getRootUrl()+"/names/getJSON", JSONObject.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println("!!!!!!!!!!!!!"+response.getBody());
       // assertThat(requireNonNull(response.getBody()).getName()).isEqualTo("prius");
       // assertThat(requireNonNull(response.getBody()).getType()).isEqualTo("hybrid");
    	/*HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        System.out.println("!!!!!!!!!  "+getRootUrl() + "/names/getJSON");
        ResponseEntity<String> response = this.restTemplateTest.getForEntity(getRootUrl() + "/names/getJSON", String.class);  
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println("!!!!!!!!!!!!!"+response.getBody());*/
    }

}
