package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;

public class S3ClientResource implements AutoCloseable {
	private final AmazonS3 client;

	S3ClientResource(AmazonS3 client) {
		this.client = client;
	}

	public AmazonS3 getClient() {
		return client;
	}

	@Override
	public void close() throws Exception {
		client.shutdown();
	}
}
