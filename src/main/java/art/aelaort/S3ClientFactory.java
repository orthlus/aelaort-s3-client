package art.aelaort;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3ClientFactory {
	public static S3ClientResource of(S3Parameters s3Parameters) {
		return (S3ClientResource) client(s3Parameters);
	}

	static AmazonS3 client(S3Parameters s3Parameters) {
		return client(
				s3Parameters.getId(),
				s3Parameters.getKey(),
				s3Parameters.getUrl(),
				s3Parameters.getRegion());
	}

	static AmazonS3 client(String id, String key, String url, String region) {
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
