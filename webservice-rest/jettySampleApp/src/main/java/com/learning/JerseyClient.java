package com.learning;

import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.training.restful.Customer;

public class JerseyClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client.register(MultiPartFeature.class);
        Logger logger = Logger.getLogger("jersey-client");
        logger.addHandler(new ConsoleHandler());
        LoggingFeature loggingFeature = new LoggingFeature(logger, Level.ALL,
                LoggingFeature.Verbosity.PAYLOAD_ANY, 10000);
        client.register(loggingFeature);

        WebTarget target = client.target("http://localhost:8080/rest/services/customer?");
        Builder request = target.queryParam("key", "java-client")
                .request("application/vnd.training.v1.0+json");

        Response response = request.get();

        System.out.println(response.readEntity(String.class));

        // sendPostRequest(target);
    }

    private static void sendPostRequest(WebTarget target) {
        Builder request;
        request = target.request();
        // request.header("Content-Type", "multipart/form-data; boundary=" + UUID.randomUUID());

        MultiPart multiPart = new MultiPart();
        FormDataBodyPart formDataBodyPart = new FormDataBodyPart("name", "Given Name");
        multiPart.bodyPart(formDataBodyPart);

        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("address", new File(
                "C:\\Users\\nitesh.gupta\\learnspace\\jettySampleApp\\src\\main\\java\\Address.json"));
        multiPart.bodyPart(fileDataBodyPart);

        Response post = request.post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA));
        post.getStatus();
        System.out.println(post.readEntity(Customer.class));
    }
}
