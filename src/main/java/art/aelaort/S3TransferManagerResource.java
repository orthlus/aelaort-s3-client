package art.aelaort;

import com.amazonaws.services.s3.transfer.TransferManager;

public class S3TransferManagerResource extends TransferManager implements AutoCloseable {
	@Override
	public void close() throws Exception {
		shutdownNow();
	}
}
