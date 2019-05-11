package com.apifront.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.apifront.pojo.API;
import com.apifront.pojo.Billing;
import com.apifront.pojo.User;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class MyPdfViewImpl extends AbstractPdfView{

	List<Billing> b;
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(b!=null)
		{
			Element e1=new Chunk("Name : "+b.get(0).getUser().getName());
			document.add(e1);

		
		
		Table table=new Table(3);
		table.addCell("Sr No.");
		table.addCell("Service/API");
		table.addCell("Cost");
		int srno=1;
		for(Billing billing:b) {
			table.addCell(srno+"");
			table.addCell(billing.getApi().getApiName());
			table.addCell("$"+billing.getCost()+"");
		}
		document.add(table);
		}
	}
	
	public MyPdfViewImpl(List<Billing> b)
	{
		this.b=b;
	}

}
