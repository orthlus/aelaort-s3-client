package art.aelaort;

import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

public class S3TransferManagerResource implements S3Client {
	private TransferManager transferManager = TransferManagerBuilder.standard()
			.withS3Client(client())
			.build();
	private S3Parameters s3Parameters;

	public S3TransferManagerResource(S3Parameters s3Parameters) {
		this.s3Parameters = s3Parameters;
	}

	@Override
	public void close() throws Exception {
		transferManager.shutdownNow();
	}

	public TransferManager getTransferManager() {
		return transferManager;
	}

	@Override
	public S3Parameters getParameters() {
		return s3Parameters;
	}
}
