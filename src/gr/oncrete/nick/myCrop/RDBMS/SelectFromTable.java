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
 * SelectFromTable.java
 *
 * Created on 12 Ιούλιος 2005, 11:27 πμ
 */

package gr.oncrete.nick.myCrop.RDBMS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author nickapos
 */
public class SelectFromTable extends BasicTableOperation
{
   
   /** Creates a new instance of InsertIntoTable */
   public SelectFromTable ()
   {
      super.initiateDBConnection();
   }
   
   /**
    *
    *Executes the query and returns the result in 
    *an arraylist, one result per line (result of a query split in many lines)
    */
   public ArrayList executeQuery (String query)
   {
      ArrayList a = new ArrayList();
      try
      {
        a= DatabaseConnection.queryReturnResult (query);
        
      }
      catch (SQLException sqle)
      {
         sqle.printStackTrace ();
         a = new ArrayList();
      }
      return a;
   }

   /**
    *
    *Executes the query and returns the result in 
    *an arraylist,the results formed as a full result array per line
    */
   public ArrayList executeQueryA (String query)
   {
      ArrayList a = new ArrayList();
      try
      {
        a= DatabaseConnection.queryReturnResultA (query);
        
      }
      catch (SQLException sqle)
      {
         sqle.printStackTrace ();
         a = new ArrayList();
      }
      return a;
   }

   /**
    *
    *Executes the query and returns the result in
    *an linkedlist, the results formed as a full result array per line
    */
   public LinkedList executeQueryL (String query)
   {
      LinkedList l = new LinkedList();
      try
      {
        l= DatabaseConnection.queryReturnResultL (query);

      }
      catch (SQLException sqle)
      {
         sqle.printStackTrace ();
         l = new LinkedList();
      }
      return l;
   }
   
}
