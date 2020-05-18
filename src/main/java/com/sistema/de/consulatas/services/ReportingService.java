package com.sistema.de.consulatas.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	public void printReport(SantoDomingoReport santoDomingoReport) {
		try {

			File file = ResourceUtils.getFile("santoDomingo.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			List<SantoDomingo> listSantoDomingo = santoDomingoRepo.findAll(santoDomingoReport.getFrom(),santoDomingoReport.getTo());
			ArrayList<SantoDomingoJRBean> list = new ArrayList<>();

			for (SantoDomingo santoDomingo : listSantoDomingo) {
				SantoDomingoJRBean santoDomingoJRBean = new SantoDomingoJRBean();
				santoDomingoJRBean.setFecha(santoDomingo.getFecha());
				santoDomingoJRBean.setApellidos(santoDomingo.getApellidos());
				santoDomingoJRBean.setDetalle(santoDomingo.getDetalle());
				santoDomingoJRBean.setPrimerNombre(santoDomingo.getPrimerNombre());
				santoDomingoJRBean.setSegundoNombre(santoDomingo.getSegundoNombre());
				santoDomingoJRBean.setNacionalidad(santoDomingo.getNacionalidad());
				santoDomingoJRBean.setOtros(santoDomingo.getOtros());
				santoDomingoJRBean.setOficioNumero(santoDomingo.getOficioNumero());
				santoDomingoJRBean.setFechaDeOficio(santoDomingo.getFechaDeOficio());
				santoDomingoJRBean.setDocumentoNumero(santoDomingo.getDocumentoNumero());
				santoDomingoJRBean.setDocumento(santoDomingo.getDocumento().name());
				list.add(santoDomingoJRBean);
			}
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
			Map<String, Object> map = new HashMap<String, Object>();
			JasperPrint jp = JasperFillManager.fillReport(jr, map, ds);
			if (santoDomingoReport.getType().equals("1")) {
				JasperPrintManager.printReport(jp, false);
			} else {
				JasperExportManager.exportReportToPdfFile(jp, santoDomingoReport.getFrom()+" to "+santoDomingoReport.getTo()+"-"+System.currentTimeMillis()+".pdf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
