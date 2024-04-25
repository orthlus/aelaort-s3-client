package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;

public abstract class S3ClientResource implements S3Client, AutoCloseable {
	private final AmazonS3 client = client();

	@Override
	public void close() throws Exception {
		client.shutdown();
	}

	public AmazonS3 getClient() {
		return client;
	}
}
