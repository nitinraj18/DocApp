package com.springmvc.fileuploadfunctionality;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileUploadFunctionality {
	
	public List<String> multipleFileUpload(String rootpath,String relativepath,String basepath,CommonsMultipartFile[] file);
	

}
