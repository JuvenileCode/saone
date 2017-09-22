package com.bademo.action.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by
 * :upload test Service
 * @author Bin.l
 * @date 2017/9/22 23:02
 */
@Service
public class UploadFileService {

    /**
     * file upload test
     *
     * @param files
     * @return
     */
    public boolean addFile(MultipartFile[] files) {
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String type = file.getContentType();
                String name = file.getOriginalFilename();
                try {
                    file.transferTo(new File("/Users/bin_l/Music/" + name));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
