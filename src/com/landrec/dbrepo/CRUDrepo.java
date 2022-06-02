package com.landrec.dbrepo;

import com.landrec.entity.Land_info;

import com.landrec.entity.Owned_by;
import com.landrec.entity.Owner_info;
import com.landrec.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDrepo {
    public int insertINDistrict(String id , String name, String stateUT)  {

        Connection cn = null;
        try {
            cn = DBconnection.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql = "Insert into district(dist_id,dist_name,state_or_ut) values(?,?,?)";

        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,stateUT);
            i = ps.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        System.out.println(i + " Record Inserted");
        return i;



    }
    public void insertINuser(String user_id , String name , String dist_id , String password) throws SQLException, ClassNotFoundException {
        Connection cn =  DBconnection.getConnection();

        String sql = "Insert into user(user_id,passwrd,user_name,dis_id) values(?,?,?,?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        int i;

        ps.setString(1,user_id);
        ps.setString(2,password);
        ps.setString(3,name);
        ps.setString(4,dist_id);
        i = ps.executeUpdate();
        System.out.println(i + " Record Inserted");
    }
    public User selectUser(String id) throws SQLException, ClassNotFoundException {
        Connection cn = null;
        cn = DBconnection.getConnection();
        String sql = "select * from user where user_id = ?";
        PreparedStatement ps = cn.prepareStatement(sql); ;
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        User u = new User();
        if(rs.next()==true)
        {
         String uid = rs.getString(1);
         String pass = rs.getString(2);
         String name = rs.getString(3);
         String dis = rs.getString(4);
         u.setUser_id(uid);
         u.setDis_id(dis);
         u.setName(name);
         u.setPassword(pass);

        }
        return u;

    }
     public void insertINroad(String id, String name , String type) throws SQLException, ClassNotFoundException {
         Connection cn =  DBconnection.getConnection();

         String sql = "Insert into road(road_id,road_name,road_type) values(?,?,?)";
         PreparedStatement ps = cn.prepareStatement(sql);
         int i;

         ps.setString(1,id);
         ps.setString(2,name);
         ps.setString(3,type);
         i = ps.executeUpdate();
         System.out.println(i + " Record Inserted");

     }
     public void insertINowner(Owner_info o) throws SQLException, ClassNotFoundException {
         Connection cn =  DBconnection.getConnection();

         String sql = "Insert into owner_info(owner_id,F_name,M_name,L_name,city,add_line1,add_line2) values(?,?,?,?,?,?,?)";
         PreparedStatement ps = cn.prepareStatement(sql);
         int i;


         ps.setString(1,o.getOwner_id());
         ps.setString(2,o.getF_name());
         ps.setString(3,o.getM_name());
         ps.setString(4,o.getL_name());
         ps.setString(5,o.getCity());
         ps.setString(6,o.getAdd_line1());
         ps.setString(7,o.getAdd_line2());

         i = ps.executeUpdate();
         System.out.println(i + " Record Inserted");

     }
      public void insertINland(Land_info l) throws SQLException, ClassNotFoundException {
          Connection cn =  DBconnection.getConnection();

          String sql = "Insert into land(land_id,land_name,land_status,land_size,land_type,dist_id) values(?,?,?,?,?,?)";
          PreparedStatement ps = cn.prepareStatement(sql);
          int i;
          ps.setString(1,l.getLand_id());
          ps.setString(2,l.getLand_name());
          ps.setString(3,l.getLand_status());
          ps.setInt(4,l.getLand_size());
          ps.setString(5,l.getLand_type());
          ps.setString(6,l.getDist_id());


          i = ps.executeUpdate();
          System.out.println(i + " Record Inserted");

      }
      public void insertINconnectedby(String land_id, String road_id) throws SQLException, ClassNotFoundException {
          Connection cn =  DBconnection.getConnection();

          String sql = "Insert into connected_by(land_id,road_id) values(?,?)";
          PreparedStatement ps = cn.prepareStatement(sql);
          int i;
          ps.setString(1,land_id);
          ps.setString(2,road_id);
          i = ps.executeUpdate();
          System.out.println(i + " Record Inserted");

      }
      public void transfer(String new_own_id , String old_own_id ,String land_id , String date)  {


      }
      public void insertINowned_by(String own_id , String land_id , String date) throws SQLException, ClassNotFoundException {
          Connection cn =  DBconnection.getConnection();

          String sql = "Insert into owned_by(owner_id,land_id,purchased,sold) values(?,?,?,?)";
          PreparedStatement ps = cn.prepareStatement(sql);
          int i;
          ps.setString(1,own_id);
          ps.setString(2,land_id);
          ps.setString(3,  date);
          ps.setString(4,null);
          i = ps.executeUpdate();
          System.out.println(i + " Record Inserted");

      }
      public void updateSoldDate(String own_id, String land_id, String date) throws SQLException, ClassNotFoundException {
          Connection cn =  DBconnection.getConnection();

          String sql = "update  owned_by set sold = ? where land_id = ? and owner_id =?";
          PreparedStatement ps = cn.prepareStatement(sql);
          int i;
          ps.setString(1,date);
          ps.setString(2,land_id);
          ps.setString(3, own_id);
          i = ps.executeUpdate();
          System.out.println(i + " Record Inserted");
      }



      public Owner_info GetOwnerInfo(String O_id) throws SQLException, ClassNotFoundException {
          Connection cn = null;
          cn = DBconnection.getConnection();
          String sql = "select * from owner_info where owner_id = ?";
          PreparedStatement ps = cn.prepareStatement(sql); ;
          ps.setString(1,O_id);

          ResultSet rs = ps.executeQuery();
          Owner_info o = new Owner_info();

          if(rs.next()==true)
          {
              o.setOwner_id(rs.getString(1));
              o.setF_name(rs.getString(2));
              o.setM_name(rs.getString(3));
              o.setL_name(rs.getString(4));
              o.setCity(rs.getString(5));
              o.setAdd_line1(rs.getString(6));
              o.setAdd_line2(rs.getString(7));

          }
          return o;

      }
       public Land_info GetLandInfo(String l_id) throws SQLException, ClassNotFoundException {
           Connection cn = null;
           cn = DBconnection.getConnection();
           String sql = "select * from land where land_id = ?";
           PreparedStatement ps = cn.prepareStatement(sql); ;
           ps.setString(1,l_id);

           ResultSet rs = ps.executeQuery();
           Land_info l = new Land_info();
           if (rs.next()==true)
           {
               l.setLand_id(rs.getString(1));
               l.setLand_name(rs.getString(2));
               l.setLand_status(rs.getString(3));
               l.setLand_size(rs.getInt(4));
               l.setLand_type(rs.getString(5));
               l.setDist_id(rs.getString(6));


           }
           return l;

       }










}
