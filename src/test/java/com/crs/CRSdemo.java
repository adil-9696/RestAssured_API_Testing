package com.crs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CRSdemo {

	public static void main(String[] args) throws IOException {

		String s = "It's CRS Automation BABY!!!!";
		String docTitle = "AVISSO_8.4.3_CCR#1382";
		String docno = "IQP-GLB-COMP-2022-0045-00003.002";

		String path = System.getProperty("user.dir") + "/src/test/resources/CRS_Template.docx";

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("CRS_Template.docx");

		XWPFDocument document = new XWPFDocument(is);
		
		

		for (int i = 0; i < document.getParagraphs().size(); i++) {

			XWPFParagraph para = document.getParagraphs().get(i);

			  String text=para.getText(); 
			if(para.getText().contains("${CCRNo}")) {
				
				System.out.println( para.getText());
                 
				   text=text.replace("${CCRNo}","CCR#123333");  
				
				for(int j=para.getRuns().size()-1;j>=0;j--)
				{
					System.out.println();
					para.removeRun(j);
				}
			
			
			para.createRun().setText(text);
			
			}
			
		}
		
		  for (int i = 0; i < document.getTables().size(); i++) {
		  
		  XWPFTable table = document.getTables().get(i);
		  
		  for (int j = 0; j < table.getRows().size(); j++) {
		  
		  XWPFTableRow row = table.getRow(j);
		  
		  
		  if (row.getTableCells().size() < 4) { continue; }
		  
		  // Example: Update IQP Row 
		  
		  if (row.getCell(0).getText().equalsIgnoreCase("IQP")) {
		  
		  row.getCell(1).removeParagraph(0); row.getCell(1).setText("Title: " +
		  docTitle + "\nDoc. No.: " + docno);
		  
		  row.getCell(2).removeParagraph(0); row.getCell(2).setText(s);
		  
		  row.getCell(3).removeParagraph(0); row.getCell(3).setText(s); }
		  
		  // Example: Update CRS Row if
		 if(row.getCell(0).getText().contains("Change Request Summary")) {
		  
		  row.getCell(1).removeParagraph(0); row.getCell(1).setText("Title: " + s +
		  "\nDoc. No.: " + s);
		  
		  row.getCell(2).removeParagraph(0); row.getCell(2).setText(s); }
		  
		  if (row.getCell(0).getText().equalsIgnoreCase("STP")) {
		  row.getCell(1).removeParagraph(0); row.getCell(1).setText(s);
		  
		  row.getCell(2).removeParagraph(0); row.getCell(2).setText(s);
		  
		  row.getCell(3).removeParagraph(0); row.getCell(3).setText(s); }
		  
		  } }
		 

		String outputPath = System.getProperty("user.dir") + "/CRS_Output.docx";

		FileOutputStream fos = new FileOutputStream(outputPath);
		document.write(fos);

		fos.close();
		is.close();
		document.close();

		System.out.println("Document generated successfully.");

		System.out.println("Location : " + outputPath);

	}

}
