package com.example.backend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
    "spring.datasource.url=jdbc:h2:mem:wqm",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class BackendApplicationTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    void complaintCanBeSubmittedAndRetrieved() throws Exception {
        try (var client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder(uri("/api/complaints/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("""
                    {"name":"Test Citizen","address":"Main Street","zone":"Zone 1",
                     "complaintType":"Water leakage","phoneNumber":"1234567890",
                     "emailAddress":"citizen@example.test"}
                    """))
                .build();

            var submitted = client.send(request, HttpResponse.BodyHandlers.ofString());
            assertThat(submitted.statusCode()).isEqualTo(200);
            assertThat(submitted.body()).contains("\"id\":", "Water leakage");

            var listed = client.send(
                HttpRequest.newBuilder(uri("/api/complaints/getAll")).build(),
                HttpResponse.BodyHandlers.ofString());
            assertThat(listed.statusCode()).isEqualTo(200);
            assertThat(listed.body()).contains("citizen@example.test", "Water leakage");
        }
    }

    @Test
    void openApiDocumentsComplaintRoutes() throws Exception {
        try (var client = HttpClient.newHttpClient()) {
            var response = client.send(
                HttpRequest.newBuilder(uri("/v3/api-docs")).build(),
                HttpResponse.BodyHandlers.ofString());
            assertThat(response.statusCode()).isEqualTo(200);
            assertThat(response.body()).contains("/api/complaints/add", "/api/complaints/getAll");
        }
    }

    private URI uri(String path) {
        return URI.create("http://localhost:" + port + path);
    }
}
