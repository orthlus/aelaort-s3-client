package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;

public class S3ClientResource implements AutoCloseable {
	private final AmazonS3 client;

	public S3ClientResource(S3Parameters s3Parameters) {
		client = S3ClientFactory.client(s3Parameters);
	}

	public AmazonS3 getClient() {
		return client;
	}

	@Override
	public void close() throws Exception {
		client.shutdown();
	}
}
