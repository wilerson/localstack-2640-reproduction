import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest
import java.net.URI
import kotlin.test.Test

class ReproductionTest {

    @Test
    fun `test localstack`() {
        // Variable added by gradle-docker-compose-plugin
        val host = System.getenv("LOCALSTACK_HOST")

        val sqsClient = SqsClient.builder()
                .region(Region.EU_CENTRAL_1)
                .endpointOverride(URI.create("http://$host:4576"))
                .build()

        sqsClient.createQueue(
                CreateQueueRequest.builder()
                        .queueName("test")
                        .build()
        )
    }
}
