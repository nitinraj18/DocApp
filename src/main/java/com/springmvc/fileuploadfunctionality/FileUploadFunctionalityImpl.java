package com.springmvc.fileuploadfunctionality;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileUploadFunctionalityImpl implements FileUploadFunctionality{
	

	



	@Override
	public List<String> multipleFileUpload(String rootpath, String relativepath, String basepath, CommonsMultipartFile[] files) {
		// TODO Auto-generated method stub
		
		File mainFolder = new File(rootpath + File.separator + relativepath);
		
		if(!mainFolder.exists())
        {
			mainFolder.mkdirs();
			File subMainFolder = new File(rootpath + File.separator + relativepath + File.separator + basepath);
        	System.out.println("Folder path: "+subMainFolder.toString());
        	if(!subMainFolder.exists())
        	{
        		subMainFolder.mkdirs();
        		List<String> filename=coreMultipleUploadFunctionality(rootpath, relativepath, basepath, files);
        		if(!(filename.size()==0)) 
        			{
        				System.out.println("Upload successfully");
        				return filename;
        			}else 
        				{
        				System.out.println("Upload failed");
        				return null;
        				}
        		
        	}else
        	{
        		List<String> filename=coreMultipleUploadFunctionality(rootpath, relativepath, basepath, files);
        		if(!(filename.size()==0)) 
    			{
    				System.out.println("Upload successfully");
    				return filename;
    			}else 
    				{
    				System.out.println("Upload failed");
    				return null;
    				}
        	}
        	
        }else 
        {
        	File subMainFolder = new File(rootpath + File.separator + relativepath + File.separator + basepath);
        	System.out.println("Folder path: "+subMainFolder.toString());
        	if(!subMainFolder.exists())
        	{
        		subMainFolder.mkdirs();
        		List<String> filename=coreMultipleUploadFunctionality(rootpath, relativepath, basepath, files);
        		if(!(filename.size()==0)) 
    			{
    				System.out.println("Upload successfully");
    				return filename;
    			}else 
    				{
    				System.out.println("Upload failed");
    				return null;
    				}
        	}else
        	{
        		List<String> filename=coreMultipleUploadFunctionality(rootpath, relativepath, basepath, files);
        		if(!(filename.size()==0)) 
    			{
    				System.out.println("Upload successfully");
    				return filename;
    			}else 
    				{
    				System.out.println("Upload failed");
    				return null;
    				}
        	}
        }
		
		
		
		
		
		
		
	}
	
	
	
private List<String> coreMultipleUploadFunctionality(String rootpath, String relativepath, String basepath, CommonsMultipartFile[] files)
	 {
        List<String> filename=new ArrayList<String>();
	
	    for(int i=0;i<files.length;i++) 
		  {
			MultipartFile file=files[i];
			String name=files[i].getOriginalFilename();
			String fullpath=rootpath+File.separator+relativepath+File.separator+basepath+File.separator+name;
			filename.add(fullpath);
			try {
				byte[] bytes=file.getBytes();
				File mainFolder = new File(rootpath + File.separator + relativepath+File.separator+basepath);
                File serverFile=new File(mainFolder.getAbsolutePath()+File.separator+name); 
				BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("success fully uploaded");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	return filename;	
}
	
	
	

}
