package controllers;

import java.io.*;
import java.util.*;
import play.*;
import play.mvc.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.exceptions.COSVisitorException;


import models.*;

public class Application extends Controller {

    public static void index() {

    	PDDocument document = null;

    	try {

      	  document = new PDDocument();
    	  PDPage page = new PDPage();
		  document.addPage( page );

		  // add content
//		  PDFont font = PDType1Font.HELVETICA_BOLD;
//          PDFont font = PDTrueTypeFont.loadTTF(document, "/Library/Fonts/Osaka.ttf");
          PDFont font = PDTrueTypeFont.loadTTF(document, "/Library/Fonts/Arial.ttf");

		  PDPageContentStream contentStream = new PDPageContentStream(document, page);
		  contentStream.beginText();
		  contentStream.setFont( font, 12 );
		  contentStream.moveTextPositionByAmount( 100, 700 );
//		  contentStream.drawString( "こんにちは、世界" );
		  contentStream.drawString( "hello world." );
		  contentStream.endText();
		  contentStream.close();


		  document.save("BlankPage.pdf");
  		  document.close();
  		} catch(COSVisitorException e){
          Logger.info(e.getMessage());
    	} catch(IOException e) {
          Logger.info(e.getMessage());
    	} finally {
    	}

        render();
    }

}