package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Component;

@Component
public class S3ClientResource implements S3Client {
	private S3Parameters s3Parameters;
	private final AmazonS3 client = client();

	public S3ClientResource(S3Parameters s3Parameters) {
		this.s3Parameters = s3Parameters;
	}

	@Override
	public void close() throws Exception {
		client.shutdown();
	}

	public AmazonS3 getClient() {
		return client;
	}

	@Override
	public S3Parameters getParameters() {
		return s3Parameters;
	}
}
