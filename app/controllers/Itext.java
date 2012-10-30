package controllers;

import java.io.*;
import java.util.*;
import play.*;
import play.mvc.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import models.*;

public class Itext extends Controller {

  public static void index() throws IOException{
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

    // 汎用の文書オブジェクトを生成
    Document doc = new Document();
    try {
      // 出力先を指定し、文書をPDFとして出力
      PdfWriter.getInstance(doc, byteOut);
      // 出力開始
      doc.open();
      // 日本語フォントの設定
      Font font = new Font(BaseFont.createFont(
          "HeiseiKakuGo-W5",
          "UniJIS-UCS2-H",
          BaseFont.NOT_EMBEDDED));
      // 文書に要素を追加
      doc.add(new Paragraph("こんにちは、世界。", font));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    // 出力終了
    doc.close();
    
    // ブラウザへの出力
//    response.setContentType("application/pdf");
    response.contentType = "application/pdf";
//    response.setContentLength(byteOut.size());
//    response.contentLentgh = byteOut.size();
//    OutputStream out = response.getOutputStream();
//    out.write(byteOut.toByteArray());
//    out.close();
//    Logger.info("byteOut.length=%d", byteOut.size());
    InputStream bais = new ByteArrayInputStream(byteOut.toByteArray()); 
    renderBinary(bais);

//    render();
  }

}