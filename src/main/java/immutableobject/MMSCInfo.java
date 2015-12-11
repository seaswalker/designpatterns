package immutableobject;

/**
 * 短信中心
 * @author skywalker
 *
 */
public final class MMSCInfo {

	private final String deviceId;
	private final String url;
	/*
	 * 附件的最大尺寸
	 */
	private final int maxAttachmentSize;
	
	public MMSCInfo(String deviceId, String url, int maxAttachmentSize) {
		this.deviceId = deviceId;
		this.url = url;
		this.maxAttachmentSize = maxAttachmentSize;
	}
	
	public MMSCInfo(MMSCInfo prototype) {
		this.deviceId = prototype.deviceId;
		this.url = prototype.url;
		this.maxAttachmentSize = prototype.maxAttachmentSize;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public String getUrl() {
		return url;
	}

	public int getMaxAttachmentSize() {
		return maxAttachmentSize;
	}
	
}
