package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public class S3ClientResource implements AutoCloseable {
	@Delegate
	private final AmazonS3 client;

	@Override
	public void close() throws Exception {
		client.shutdown();
	}
}
