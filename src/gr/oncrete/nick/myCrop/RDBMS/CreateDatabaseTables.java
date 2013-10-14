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
 * CreateDatabaseTables.java
 *
 * Created on 29 Ιούλιος 2005, 6:31 μμ
 */

package gr.oncrete.nick.myCrop.RDBMS;
import gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers.FileHandlerReadFile;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author nickapos
 */
public class CreateDatabaseTables extends BasicTableOperation
{
   //String initialDataDir = cfg.getInDataSetDirName ();
   TransactionSQLOperations trans = new TransactionSQLOperations();
   String schemaFile="db_schema";
   String dropTableFile="drop_tables_sql";
   /** Creates a new instance of CreateDatabaseTables */
   public CreateDatabaseTables ()
   {
   }
   
   /**
    *This method creates all the tables
    *mentioned in schema
    *
    */
   public void createTables()
   {
      this.action (schemaFile);
   }
      
   /**
    *This method drops all the tables mentioned
    *in the drop file
    */
   public void dropTables()
   {
     this.action (dropTableFile);
   }
   
   
   /**
    *The method that does all the actual work.
    *It loads the contents of the sql file in 
    *a list an then executes it line by line
    *at the end all the actions are commited.
    */
   private void action(String actionFileName)
   {
      //create the name of the action file
      //String fileName = initialDataDir+cfg.getFileSeparator ()+actionFileName;
      String fileName = actionFileName;
      //create the reader object
      FileHandlerReadFile frf = new FileHandlerReadFile(fileName);
      frf.readFile ();
      
      ArrayList lst = frf.returnContents ();
      Iterator it = lst.iterator();
      String contentLine;
      while(it.hasNext())
      {
         contentLine = (String)it.next();
         if(contentLine!=null)
         {
            System.out.println("Executing "+contentLine);
            trans.executeUpdate (contentLine);
         }
      }
      trans.commitTransaction ();
      trans.closeConnection();
   }
}
