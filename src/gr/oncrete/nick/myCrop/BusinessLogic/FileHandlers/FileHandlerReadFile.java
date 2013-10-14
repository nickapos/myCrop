/*
        myBill, bills tracking program
    Copyright (C) 2010  Nick Apostolakis

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * FileHandlerReadFile.java
 *
 * Created on 6 Ιούλιος 2005, 8:36 πμ
 */

package gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author nickapos
 */
public class FileHandlerReadFile
{
   FileHandlerOpenFile openFile;
   ArrayList fileContents;
   /** Creates a new instance of FileHandlerReadFile */
   public FileHandlerReadFile (String fileName)
   {
      if(fileName.length ()>0)
      {
         openFile = new FileHandlerOpenFile (fileName);
         fileContents = new ArrayList (3);
      }
      else
      {
         System.out.println ("Invalid file name");
         System.exit (1);
      }
   }
   
   /**
    *
    *
    *
    */
   public void readFile ()
   {
      FileReader fr= openFile.getOpenFileReader ();
      BufferedReader bfr = new BufferedReader (fr);
      try
      {
         String line="";
         while(line!=null)
         {
            line=bfr.readLine ();
            fileContents.add (line);
         }
         openFile.closeFile ();
      }
      catch(IOException ioe)
      {
         System.out.println ("An error occured during the reading of the file\n");
         System.exit (1);
      }
   }
   
   /**
    * returns the contents of the file read
    *
    *
    */
   public ArrayList returnContents ()
   {
      return fileContents;
   }
}
