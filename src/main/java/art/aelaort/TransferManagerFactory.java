package art.aelaort;

import com.amazonaws.services.s3.AmazonS3;

public class TransferManagerFactory {
	public static TransferManagerResource of(S3Parameters s3Parameters) {
		AmazonS3 client = S3ClientFactory.client(s3Parameters);

		return new TransferManagerResource(client);
	}
}
