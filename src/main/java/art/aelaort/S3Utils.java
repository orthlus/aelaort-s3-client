package art.aelaort;

import com.amazonaws.services.s3.transfer.Transfer;

import java.util.concurrent.TimeUnit;

public class S3Utils {
	public static void transferPrintProgressAndLock(Transfer transfer, String name) {
		try {
			while (transfer.getProgress().getPercentTransferred() < 100) {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.printf("\rtransfer %s - %3.2f%%", name, transfer.getProgress().getPercentTransferred());
			}
			System.out.println();
			transfer.waitForCompletion();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
