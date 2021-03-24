package biblio.utils;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Password {

	private static String sel = "lEsElCbOn!";
	private static int iterations = 10000;
	private static int keyLength = 512;
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public static void main(String[] args) {
		System.out.println(getHash("azegggeggrty"));

	}

	public static String getHash(String password) {
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), sel.getBytes(), iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return bytesToHex(res);
		} catch (Exception e) {
		}
		return null;
	}

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);

	}
	
	
}
