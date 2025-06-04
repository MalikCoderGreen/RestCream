package restCream.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import java.util.Map;

public class DBCredentials {
    public static void main(String[] args) {
        getDBCredentials();
    }
    public static void getDBCredentials() {
        String secretName = "restcream/database/credentials";
        Region region = Region.of("us-east-1");

        // Create client for secrets manager and build the request
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);

        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        String secret = getSecretValueResponse.secretString();
        System.out.println("Secret Value: " + secret);

        try {
            // Parse the JSON for the DB credentials
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> secretMap = mapper.readValue(secret, Map.class);
            String username = secretMap.get("username");
            String password = secretMap.get("password");

            // set env vars
            System.setProperty("DB_USERNAME", username);
            System.setProperty("DB_PASSWORD", password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }
}