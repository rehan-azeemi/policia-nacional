package com.sistema.de.consulatas.services;


import com.sistema.de.consulatas.config.BadRequestException;
import com.sistema.de.consulatas.config.UtilService;
import com.sistema.de.consulatas.dto.SantoDomingoDto;
import com.sistema.de.consulatas.enums.Documento;
import com.sistema.de.consulatas.model.SantoDomingo;
import com.sistema.de.consulatas.repository.SantoDomingoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SantoDomingoService {
	@Autowired
	SantoDomingoRepo santoDomingoRepo;

	@Value("${file.path}")
	private String attachmentFileLocation;

	@Value("${image.path}")
	private String imageFileLocation;

	public List<SantoDomingo> findAll(){ return santoDomingoRepo.findAll(); }

	public SantoDomingo findOne(Long id){ return santoDomingoRepo.findById(id).get(); }

	public SantoDomingoDto getDto(Long id){
		SantoDomingoDto santoDomingoDto = new SantoDomingoDto();
		SantoDomingo santoDomingo = findOne(id);
		BeanUtils.copyProperties(santoDomingo,santoDomingoDto);
		return santoDomingoDto;
	}

	public void save(SantoDomingoDto santoDomingoDto, MultipartFile image, MultipartFile file) {
		SantoDomingo existSantoDomingo = new SantoDomingo();
		if(santoDomingoDto != null){
			if(santoDomingoDto.getId()!=null) {
				existSantoDomingo = findOne(santoDomingoDto.getId());
			}
			if (existSantoDomingo != null) {
				if (image!=null && !image.getOriginalFilename().isEmpty()) {
					String fileName = existSantoDomingo.getFotoPath() != null ? existSantoDomingo.getFotoPath() : System.currentTimeMillis() + "-" + image.getOriginalFilename();
					String filePath = uploadFile(image, fileName , imageFileLocation);
					existSantoDomingo.setFotoPath(filePath);
				}
				if(file!=null && !file.getOriginalFilename().isEmpty()){
					String fileName = existSantoDomingo.getAttachment() != null ? existSantoDomingo.getAttachment() : System.currentTimeMillis() + "-" + file.getOriginalFilename();
					String filePath = uploadFile(file, fileName , attachmentFileLocation);
					existSantoDomingo.setAttachment(filePath);
				}
				BeanUtils.copyProperties(santoDomingoDto, existSantoDomingo);
				santoDomingoRepo.save(existSantoDomingo);
			}
		}
	}

	public Map<String,String> getFileNameById(Long id) {
		Map<String,String> fileMap = new HashMap<>();
		 SantoDomingo santoDomingo = findOne(id);
		 fileMap.put("image",santoDomingo.getFotoPath());
		 fileMap.put("file",santoDomingo.getAttachment());
		 return fileMap;
	}

	public void delete(Long id){
		SantoDomingo santoDomingo = findOne(id);
		if(santoDomingo!=null){
			UtilService.deleteFileIfExist(imageFileLocation,santoDomingo.getFotoPath());
			UtilService.deleteFileIfExist(attachmentFileLocation,santoDomingo.getAttachment());
			santoDomingo.setIsDeleted(!santoDomingo.getIsDeleted());
			santoDomingoRepo.save(santoDomingo);
		}
	}

	public List<String> getAllDocumento(){
		ArrayList<String> documentoList = new ArrayList<String>();
		for(Documento documento:Documento.values()) {
			documentoList.add(documento.name());
		}

		return documentoList;
	}


	/**
	 * upload student image to server
	 * @param file
	 * @param fileName
	 * @return
	 */
	private String uploadFile(MultipartFile file, String fileName,String fileLocation){
		String fullFileName = fileName ;
		Boolean isFileUploaded = UtilService.uploadFile(file,fileLocation, fullFileName);
		if(!isFileUploaded) throw new BadRequestException("file.upload.error");
		return fullFileName;
	}
}
