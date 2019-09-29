package com.steelgt.gavin.Controller;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.steelgt.gavin.util.Massage;
import com.steelgt.gavin.util.UtilTool;

@RestController
public class PicUploadOcrController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PicUploadOcrController.class);

	@PostMapping("/upload")
	public Object upload(MultipartFile fileUpload) {
		// 获取文件名
		String fileName = fileUpload.getOriginalFilename();
		// 获取文件后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		// 重新生成文件名
		fileName = UUID.randomUUID() + suffixName;
		// 指定本地文件夹存储图片
		String filePath = "D:/tmp/upload/";
		try {
			// 将图片保存到static文件夹里
			fileUpload.transferTo(new File(filePath + fileName));
			LOGGER.info("开始使用百度OCR识别图片中的文字");
			String result = UtilTool.ORC_BAIDU(filePath + fileName);
			return new Massage(0, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Massage(-1, "fail to upload");
		}
	}
}
