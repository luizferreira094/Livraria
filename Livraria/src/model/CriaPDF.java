//package model;
//
// 
//import java.io.FileOutputStream;
// 
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
// 
//public class CriaPDF {
// 
//	public static void main(String[] arq) {
//		try {
// 
//			// Criação do objeto que será um documento PDF
//			Document documento = new Document();
//			// Faz o apontamento para o arquivo de destino
//			PdfWriter.getInstance(documento, new FileOutputStream(
//					"D:/novoPDF.pdf"));
//			// Realiza a abertura do arquivo para escrita
//			documento.open();
//			// Escreve uma mensagem no arquivo
//			
// 
//			// Fecha o arquivo após a escrita da mensagem
//			documento.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
// 
//	}
//}