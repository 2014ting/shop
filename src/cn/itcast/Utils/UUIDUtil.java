package cn.itcast.Utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getuuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
