package org.fugerit.java.fjdaogenquickstart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoadPersonTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String test = "Feanor";

    private String basePath = "/fj-daogen-quickstart/jax-rs/person";

    @Test
    void testLoadAll() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + basePath + "/load/all",
                String.class)).contains(test);
    }

    @Test
    void testLoadOne() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + basePath + "/load/id/3",
                String.class)).contains(test);
    }

    @Test
    void testLoadOneRelations() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + basePath + "/load/deep/id/3",
                String.class)).contains(test);
    }

}
