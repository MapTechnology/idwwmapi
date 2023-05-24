package tftp;

public class TFTPDefines {
	public static final int timoutTFTP= 500; // 500 ms de Timeout
	public static final int DEFAULT_TSIZE =  200 *1024 * 1024; // 200 MB
	public static final String DEFAULT_AUX = null;
	public static final int MAXIMUM_RETRANSMIT =10;	//Maximum retransmit count
	public static final int timoutSOSocket=1500;
	public static final int BLOCK_SIZE =512;
	public static final int BUFFER_SIZE =BLOCK_SIZE + 16;
	public static int TFTP_PORT =10069; //10069	
	public static final int POOL_SIZE =10;
}
