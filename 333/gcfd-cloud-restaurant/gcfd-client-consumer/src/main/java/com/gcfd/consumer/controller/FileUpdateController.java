package com.gcfd.consumer.controller;

import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.FormFileEntity;
import com.gcfd.common.util.UUIDUtil;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/consumer/scr/file")
public class FileUpdateController {

    private static final Logger logger = LoggerFactory.getLogger(FileUpdateController.class);

    @Value("${system.file.upload.maxsize}")
    private long FILE_UPLOAD_MAX_SIZIE;

    @Value("${system.file.image.mime}")
    private String FILE_IMAGE_MIME;

    @Value("${system.file.wordexcle.mime}")
    private String FILE_WORD_EXCLE_MIME;

    @Value("${system.file.baseUrl}")
    private String FILE_BASE_URL;

    @RequestMapping(value = "/fileUpdload", method = {RequestMethod.POST})
    public DataCenter<Object> fileUpdate(HttpServletRequest request) {
        List<FormFileEntity> listFfile = new ArrayList<FormFileEntity>();
        DataCenter<Object> netData = new DataCenter<Object>();
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 文件上传大小限制
        upload.setSizeMax(FILE_UPLOAD_MAX_SIZIE);
        File fileUp = null;
        try {
            // 可以上传多个文件
            FileItemIterator fileI = upload.getItemIterator(request);
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            FileItemStream fileIS = null;
            while (fileI.hasNext()) {
                fileIS = fileI.next();
                fileUp = writeToFile(fileIS);
                if (fileUp != null) {
                    listFfile.add(new FormFileEntity(fileUp.getName(), fileUp.length(), fileUp.getPath(), true));
                } else {
                    for (FormFileEntity del : listFfile) {
                        fileUp = new File(del.getFilePath());
                        fileUp.deleteOnExit();
                    }
                    listFfile = null;
                    netData.setNetCode(EnumNetCode.F1001);
                    throw new Exception();//已经出现上传失败的，直接抛出错误
                }
            }
            netData.setNetCode(EnumNetCode.F1000);
            netData.setData(listFfile);
        } catch (Exception e) {
            logger.error("---------------文件上传失败!---------------");
            netData.setNetCode(EnumNetCode.F1001);
        }
        return netData;
    }

    @RequestMapping(value = "/updloadBreakpoint", method = {RequestMethod.POST})
    public DataCenter<Object> fileUpdateBreakpoint(HttpServletRequest request) {
        List<FormFileEntity> listFfile = new ArrayList<FormFileEntity>();
        DataCenter<Object> netData = new DataCenter<Object>();
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 文件上传大小限制
        upload.setSizeMax(FILE_UPLOAD_MAX_SIZIE);
        File fileUp = null;
        try {
            // 可以上传多个文件
            FileItemIterator fileI = upload.getItemIterator(request);
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            FileItemStream fileIS = null;
            while (fileI.hasNext()) {
                fileIS = fileI.next();
                fileUp = writeToFile(fileIS);
                if (fileUp != null) {
                    listFfile.add(new FormFileEntity(fileUp.getName(), fileUp.length(), fileUp.getPath(), true));
                } else {
                    listFfile.add(new FormFileEntity(fileIS.getName(), null, null, false));
                }
            }
        } catch (Exception e) {
            logger.error("---------------文件上传失败!---------------");
        }
        return netData;
    }

    /**
     * 文件持久至磁盘
     *
     * @param fileIS
     * @return File
     * @throws Exception
     */
    public File writeToFile(FileItemStream fileIS) {
        InputStream in = null;
        OutputStream out = null;
        String fileMime = null;
        File file = null;
        // 每个月的上传文件都分开
        String filePath = FILE_BASE_URL + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        byte[] buf = new byte[1024 * 10];
        try {
            // buf
            int length = 0;
            fileMime = fileIS.getName();
            if (!fileIS.isFormField() && fileMime != null && !"".equals(fileMime)) {
                // 打开网络流，开始上传
                in = fileIS.openStream();
                // 获取文件后缀名并转成小写 <统一命名>
                fileMime = fileMime.substring(fileMime.lastIndexOf(".")).toLowerCase();
                if (fileMime.matches("^[" + FILE_IMAGE_MIME + "]{" + fileMime.length() + "}.*")) {
                    filePath += "/jpg/";
                } else if (fileMime.matches("^[" + FILE_WORD_EXCLE_MIME + "]{" + fileMime.length() + "}.*")) {
                    filePath += "/excleWord/";
                } else {
                    filePath += "/others/";
                }
                //文件夹判断补全
                file = new File(filePath);
                if (file.isDirectory()) {
                    file.mkdirs();
                }
                file = new File(filePath, UUIDUtil.getUUID36() + fileMime);
                out = new FileOutputStream(file);
                while ((length = in.read(buf)) != -1) {
                    out.write(buf, 0, length);
                    out.flush();
                }
                out.close();
                in.close();
            }
        } catch (Exception e) {
            logger.error("-----------------file :【{}】  文件上传失败！---------------------------", fileMime);
        } finally {
            try {
                buf = null; // buf 清空
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
        logger.debug("----------file :【{}】  文件上传成功！ -------------------------------", file.getPath());
        return file;
    }

}
