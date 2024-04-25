package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

public class TransferManagerResource extends TransferManager implements AutoCloseable {
	TransferManagerResource(AmazonS3 client) {
		super(TransferManagerBuilder.standard().withS3Client(client));
	}

	@Override
	public void close() throws Exception {
		shutdownNow();
	}
}
