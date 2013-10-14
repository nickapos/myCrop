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
 * EmptyConstantTables.java
 *
 * Created on 8 Ιούλιος 2005, 10:53 πμ
 */

package gr.oncrete.nick.myCrop.RDBMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nickapos
 */
public class EmptyTables extends BasicTableOperation
{
   
   /** Creates a new instance of EmptyCOnstantTables */
   public EmptyTables ()
   {
      super.initiateDBConnection();
      DatabaseConnection.setAutoCommitOff ();
      try
      {
         DatabaseConnection.update ("delete from farmfield");
         //DatabaseConnection.update ("delete from bills ");
         DatabaseConnection.commitTransaction ();
         DatabaseConnection.update ("delete from croptype");
         DatabaseConnection.update ("delete from nutrienttype");
         DatabaseConnection.update ("delete from frecipie");
         DatabaseConnection.commitTransaction ();
         
      }
      catch (SQLException sqle)
      {
         DatabaseConnection.rollbackTransaction ();
         sqle.printStackTrace ();
      }
      //DatabaseConnection.shutdown ();
   }
   
   
   
}
