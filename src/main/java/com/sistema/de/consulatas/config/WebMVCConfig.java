package com.sistema.de.consulatas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		File directory = new File (".");
		String absPath = directory.getAbsolutePath();

		String readImagePath =  String.format("%sfotos/", absPath.replace("\\", "/").replace(".", ""));
		String formatreadImagePath = readImagePath;

		String readFilePath =  String.format("%sattachments/", absPath.replace("\\", "/").replace(".", ""));
		String formattedFilePath = readFilePath;

		registry.addResourceHandler("/fotos/**").addResourceLocations(String.format("file:///%s", formatreadImagePath));
		registry.addResourceHandler("/attachments/**").addResourceLocations(String.format("file:///%s", formattedFilePath));

	}


}
