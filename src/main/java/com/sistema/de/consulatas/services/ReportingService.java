package com.sistema.de.consulatas.services;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;

import com.sistema.de.consulatas.dto.SantoDomingoJRBean;
import com.sistema.de.consulatas.model.SantoDomingo;
import com.sistema.de.consulatas.model.SantoDomingoReport;
import com.sistema.de.consulatas.repository.SantoDomingoRepo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportingService {

	@Autowired
	private SantoDomingoRepo santoDomingoRepo;
	
	@Autowired
	private SantoDomingoService santoDomingoService;
	
	@Value("${image.path}")
	private String imageFileLocation;

	@Autowired
	ResourceLoader resourceLoader;

	public void printReport(SantoDomingoReport santoDomingoReport) {
		try {
			File file = ResourceUtils.getFile("santoDomingo.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			List<SantoDomingo> listSantoDomingo = santoDomingoRepo.findAll(santoDomingoReport.getFrom(),santoDomingoReport.getTo());
			ArrayList<SantoDomingoJRBean> list = new ArrayList<>();

			for (SantoDomingo santoDomingo : listSantoDomingo) {
				SantoDomingoJRBean santoDomingoJRBean = new SantoDomingoJRBean();
				santoDomingoJRBean.setPrimerNombre(santoDomingo.getPrimerNombre());
				santoDomingoJRBean.setApellidos(santoDomingo.getApellidos());
				santoDomingoJRBean.setFechaDeNacimiento(santoDomingo.getFechaDeNacimiento());
				santoDomingoJRBean.setDocumentoNumero(santoDomingo.getDocumentoNumero());
				santoDomingoJRBean.setFechaDeOficio(santoDomingo.getFechaDeOficio());
				santoDomingoJRBean.setEntidadSolicitante(santoDomingo.getEntidadSolicitante());
				santoDomingoJRBean.setARequerimiento(santoDomingo.getARequerimiento());
				santoDomingoJRBean.setActive((santoDomingo.getIsDeleted())?"I":"A");
				santoDomingoJRBean.setNoDeOficio(santoDomingo.getNoDeOficio());
				list.add(santoDomingoJRBean);
			}
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
			Map<String, Object> map = new HashMap<String, Object>();
			JasperPrint jp = JasperFillManager.fillReport(jr, map, ds);
			if (santoDomingoReport.getType().equals("1")) {
				JasperPrintManager.printReport(jp, false);
			} else {
				JasperExportManager.exportReportToPdfFile(jp, "pdf-reports/"+santoDomingoReport.getFrom()+" to "+santoDomingoReport.getTo()+"-"+System.currentTimeMillis()+".pdf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printIndividualReport(Long id) {
		try {

			File file = ResourceUtils.getFile("santoDomingoIndividual.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			SantoDomingo santoDomingos = santoDomingoService.findOne(id);
			List<SantoDomingo> listSantoDomingo = santoDomingoRepo.findAllByDocumentoNumero(santoDomingos.getDocumentoNumero());
			ArrayList<SantoDomingoJRBean> list = new ArrayList<>();

			for (SantoDomingo santoDomingo : listSantoDomingo) {
				SantoDomingoJRBean santoDomingoJRBean = new SantoDomingoJRBean();
				santoDomingoJRBean.setPrimerNombre(santoDomingo.getPrimerNombre());
				santoDomingoJRBean.setSegundoNombre(santoDomingo.getSegundoNombre());
				santoDomingoJRBean.setApellidos(santoDomingo.getApellidos());
				santoDomingoJRBean.setFechaDeNacimiento(santoDomingo.getFechaDeNacimiento());
				santoDomingoJRBean.setNacionalidad(santoDomingo.getNacionalidad());
				santoDomingoJRBean.setDocumento(santoDomingo.getDocumento().name().replace("-", " "));
				santoDomingoJRBean.setDocumentoNumero(santoDomingo.getDocumentoNumero());
				santoDomingoJRBean.setEntidadSolicitante(santoDomingo.getEntidadSolicitante());
				santoDomingoJRBean.setARequerimiento(santoDomingo.getARequerimiento());
				santoDomingoJRBean.setFechaDeOficio(santoDomingo.getFechaDeOficio());
				santoDomingoJRBean.setNoDeOficio(santoDomingo.getNoDeOficio());
				santoDomingoJRBean.setOtros(santoDomingo.getOtros());
				santoDomingoJRBean.setImagePath(imageFileLocation+"/"+santoDomingo.getFotoPath());
				list.add(santoDomingoJRBean);
			}
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
			Map<String, Object> map = new HashMap<String, Object>();
			JasperPrint jp = JasperFillManager.fillReport(jr, map, ds);
//			if (santoDomingoReport.getType().equals("1")) {
//				JasperPrintManager.printReport(jp, false);
//			} else {
			JasperExportManager.exportReportToPdfFile(jp, "pdf-reports/"+santoDomingos.getDocumentoNumero()+"-"+System.currentTimeMillis()+".pdf");
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
