package com.steelgt.gavin.util;

import java.net.URLEncoder;

import org.springframework.util.ClassUtils;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;;

public class UtilTool {
	public static String UPLOAD_RELATIVE_PAT = "/static/upload/";

	public static String getFilePath(String relativePath) {
		String absolutePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + relativePath;
		return absolutePath;
	}

	public static String ORC_BAIDU(String fileName) {
		// 手写文字识别url
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
		String result = null;
		// 本地图片路径
		try {
			byte[] imgData = FileUtil.readFileByBytes(fileName);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			 */
			String accessToken = BaiduAuthService.getAuth();
			result = HttpUtil.post(otherHost, accessToken, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
