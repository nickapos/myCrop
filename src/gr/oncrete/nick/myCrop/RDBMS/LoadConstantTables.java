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
 * LoadConstantTables.java
 *
 * Created on 8 Ιούλιος 2005, 10:53 πμ
 */

package gr.oncrete.nick.myCrop.RDBMS;
import gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers.FileHandlerReadFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import gr.oncrete.nick.myCrop.BusinessLogic.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author nickapos
 */
public class LoadConstantTables extends BasicTableOperation
{
   
   /** Creates a new instance of EmptyCOnstantTables */
   public LoadConstantTables ()
   {
      //String initialDataDir= cfg.getInDataSetDirName ();
      //String fileSep = cfg.getFileSeparator ();
      ArrayList constantTables = new ArrayList ();//the collection of the constant files
      //constantTables.add (initialDataDir+fileSep+"companies_data");
      constantTables.add ("companies_data");
      //constantTables.add ("bills_data");
      
      Iterator it= constantTables.iterator ();
      ArrayList commands = new ArrayList ();//the list that will hold all the commands
      while(it.hasNext ())
      {
         String nextFile =(String)it.next ();
         FileHandlerReadFile file = new FileHandlerReadFile (nextFile);
         file.readFile ();
         ArrayList contents =file.returnContents ();
         commands.addAll (contents);
      }
      DatabaseConnection.setAutoCommitOff ();
      this.fillTable (commands);//the call of the function that will fill the commands
   }
   
   /**
    *
    *This function accepts an ArrayList that holds all the commands
    *about to be added in the database. It iterates over it and
    *fill the tables with the data.
    */
   private void fillTable (ArrayList commands)
   {
      try
      {
         Iterator it = commands.iterator ();
         while(it.hasNext ())
         {
            String next =(String)it.next ();
            System.out.println (next);
            //for some reason null values appear in the ArrayList. This is to exclude them.
            if(next !=null)
            DatabaseConnection.update (next);//execute query
         }
         DatabaseConnection.commitTransaction ();
         //DatabaseConnection.shutdown ();
      }
      catch (SQLException sqle)
      {
         DatabaseConnection.rollbackTransaction ();
         sqle.printStackTrace ();
      }
   }
}
