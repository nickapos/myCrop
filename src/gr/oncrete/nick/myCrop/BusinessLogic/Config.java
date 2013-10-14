/*
        myCrop, crop managment program
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
package gr.oncrete.nick.myCrop.BusinessLogic;

/**
 *
 * @author  nickapos
 *
 *Class that creates or reads the configuration file
 *
 *The database directory is where the HSSQL RDBMS data files live. 
 *The initial data directory is where the initial sql scripts used
 *to create and populate most of the tables live
 *
 *The database name is the name of the database used by the application.
 *
 */
import java.io.*;
import java.text.*;
import java.util.*;

public class Config
{
   String fileName="mycropconfigfile";//configuration file name
   String home;//string to keep the home directory of the user
   String fileSep= System.getProperty ("file.separator");
   String workingDirectory=System.getProperty("user.dir");
   Properties prop=new Properties ();; //object to hold the whole thing of properties
   File cf = new File (fileName);//the file object
   
   //the database directory
   String dataDirName = "DataDir";//the key name of the database directory name
   String dataDir=workingDirectory+fileSep+"datadir"+fileSep;
   
   //the directory with the initial datasets
   String inDataDirName = "InDataSet";//the key name of the initial data directory name
   String inDataDir = workingDirectory+fileSep+"dataset"+fileSep;
   
   //the database name
   String dbNameDesc= "DatabaseName";//the key name of the database name
   String dbName="db0";
   
   //default browse directory for incoming-outgoing files
   String browseDirDesc="BrowseDir";
   String browseDir=System.getProperty ("user.home");

   //producer id
   String producerID="Producer ID";
   String prodID="0";

   /** Creates a new instance of Config */
   public Config ()
   {

         if(cf.exists ())
         {
            this.loadFile ();
         }
         else
         {
            this.setDatabaseDirName (dataDir);
            this.setInitialDataDirectoryName (inDataDir);
            this.setDatabaseName (dbName);
            this.setBrowseDir (browseDir);
            this.setProdID(prodID);
            this.saveFile ();
         }
   }
   
   
   /**
    *
    *This method is used to load the file
    *from the disc if the file exists.
    *
    */
   private void loadFile ()
   {
      try
      {
         FileInputStream fStr= new FileInputStream (cf);
         prop.load (fStr);
         fStr.close ();
      }
      catch(FileNotFoundException fnfe)
      {
         System.out.println ("File Not Found");
         fnfe.printStackTrace ();
         System.exit (1);
      }
      catch (IOException ioe)
      {
         System.out.println ("Input Output exception");
         ioe.printStackTrace ();
         System.exit (1);
      }
   }
   
   /**
    *this file is used to 
    *save the properties file to the disc.
    *
    *It is used in the constructor to create
    *a default file and afterwards to change that
    *file through the gui tool.
    */
   public void saveFile ()
   {
      try
      {
         FileOutputStream outFile = new FileOutputStream (cf);
         prop.store (outFile,"# bibliography manager config file");
         outFile.close ();
      }
      catch(FileNotFoundException fnfe)
      {
         System.out.println ("File Not Found");
         fnfe.printStackTrace ();
         System.exit (1);
      }
      catch (IOException ioe)
      {
         System.out.println ("Input Output exception");
         ioe.printStackTrace ();
         System.exit (1);
      }
   }
   
   
   /**
    *
    *With this method the user can change
    *the data directory name
    *
    */
   public void setDatabaseDirName(String dataDir)
   {
      prop.put (dataDirName,dataDir);
   }
   
   /**
    *With this method the user can change the
    *initial data directory name
    *
    */
   public void setInitialDataDirectoryName(String inDataDir)
   {
      prop.put (inDataDirName,inDataDir);
   }
   
   
   /**
    *With this method the user can 
    *change the initial database name
    */
   public void setDatabaseName(String dbName)
   {
      prop.put (dbNameDesc,dbName);
   }
   
   /**
    *With this method the user can 
    *change the browse direcrory, where usually the user
    *saves or imports files.
    */
   public void setBrowseDir(String bDir)
   {
      prop.put (browseDirDesc,bDir);
   }

   /**
    *With this method the user can
    *set the producer ID
    */
   public void setProdID(String pID)
   {
      prop.put (producerID,pID);
   }
   
   /**
    *This method returns the file separator
    *of the operatin system.
    */
   public String getFileSeparator ()
   {
      return fileSep;
   }
   
   /**
    *
    *This method returns the name of the data directory
    *
    */
   public String getDataDirName ()
   {
      return prop.getProperty (dataDirName);
   }
   
   /**
    *
    *This method returns the name of the initial data set directory
    *
    */
   public String getInDataSetDirName ()
   {
      return prop.getProperty (inDataDirName);
   }
   
   /**
    *
    *This method returns the name of the database
    *
    */
   public String getDatabaseName ()
   {
      return prop.getProperty (dbNameDesc);
   }
   
   /**
    *This method returns the browse dir
    *
    *
    */
   public String getBrowseDir()
   {
      return prop.getProperty (browseDirDesc);
   }

   /**
    *This method returns the producer id
    *
    *
    */
   public String getProdID()
   {
      return prop.getProperty (producerID);
   }
}
