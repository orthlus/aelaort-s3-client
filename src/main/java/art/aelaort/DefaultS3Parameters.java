package art.aelaort;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DefaultS3Parameters implements S3Parameters {
	private final String id;
	private final String key;
	private final String url;
	private final String region;
}
