package by.rymko.springlocaldynamodbtesting;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class DAOIntegrationTest {

    private static DynamoDBProxyServer dynamoDBServer;

    private static String port = "8000";

    private static AmazonDynamoDB dynamoDBClient;

    private static DynamoDB dynamoDBDocumentClient;

    @BeforeClass
    public static void setupClass() throws Exception {
        System.setProperty("sqlite4java.library.path", "native-libs");
        dynamoDBServer = ServerRunner.createServerFromCommandLineArgs(
                new String[]{"-inMemory", "-port", port});
        dynamoDBServer.start();

        dynamoDBClient = createDynamoDBClient(dynamoDBServer);
        dynamoDBDocumentClient = new DynamoDB(dynamoDBClient);
    }

    private static AmazonDynamoDB createDynamoDBClient(DynamoDBProxyServer dynamoDBServer) {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(new
                AWSStaticCredentialsProvider(new BasicAWSCredentials("x", "x")))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:" + port,
                        Regions.DEFAULT_REGION.getName())).build();
    }

    @AfterClass
    public static void teardownClass() throws Exception {
        dynamoDBServer.stop();
    }

    @Test
    public void testCase() {
        Assert.assertEquals(4, 2 + 2);
    }

    @Test
    public void dynamoDBDocumentClientShouldNotBeNull() {
        Assert.assertNotNull(dynamoDBDocumentClient);
    }

    @Test
    public void tableShouldBeCreated() throws InterruptedException {
        String tableName = "Movies";

        Table table = dynamoDBDocumentClient.createTable(tableName,
                Arrays.asList(new KeySchemaElement("year", KeyType.HASH),
                        new KeySchemaElement("title", KeyType.RANGE)),
                Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
                        new AttributeDefinition("title", ScalarAttributeType.S)),
                new ProvisionedThroughput(10L, 10L));
        table.waitForActive();
        System.out.println(table.getDescription().toString());
    }

}
