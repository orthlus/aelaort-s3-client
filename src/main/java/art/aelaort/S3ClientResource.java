package art.aelaort;

import com.amazonaws.services.s3.AmazonS3Client;

public class S3ClientResource extends AmazonS3Client implements AutoCloseable {
	private S3ClientResource() {
	}

	@Override
	public void close() throws Exception {
		client.shutdown();
	}
}
