package art.aelaort;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

interface S3Client extends AutoCloseable {
	S3Parameters getParameters();

	default AmazonS3 client() {
		return client(
				getParameters().getId(),
				getParameters().getKey(),
				getParameters().getUrl(),
				getParameters().getRegion());
	}

	private AmazonS3 client(String id, String key, String url, String region) {
		BasicAWSCredentials credentials = new BasicAWSCredentials(id, key);
		AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(credentials);
		AwsClientBuilder.EndpointConfiguration configuration =
				new AmazonS3ClientBuilder.EndpointConfiguration(url, region);
		return AmazonS3ClientBuilder.standard()
				.withCredentials(provider)
				.withEndpointConfiguration(configuration)
				.build();
	}
}
