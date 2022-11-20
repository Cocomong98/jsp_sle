package com.example.dao;

import com.example.bean.BoardVO;
import com.example.bean.MemberVO;
import com.example.util.JDBCUtil;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private final String M_INSERT = "insert into member"+"(userid,username,photo,email,gender,age,detail)"
    + " values (?,?,?,?,?,?,?)";
    private final String M_SELECT = "select*from member where sid=?";
    private final String M_LIST = "select*from member order by regdate desc";
    private final String M_DELETE = "delete from member where sid=?";
    private final String M_UPDATE = "update member set userid=?, username=?, photo=?, email=?, gender=?, age=?" + "where sid=?";

    public int insertMember(MemberVO data){
        int result=0;
        conn = JDBCUtil.getConnection();
        try{
            stmt=conn.prepareStatement(M_INSERT);
            stmt.setString(1, data.getUserid());
            stmt.setString(2, data.getUsername());
            stmt.setString(3, data.getPhoto());
            stmt.setString(4, data.getEmail());
            stmt.setString(5, data.getGender());
            stmt.setInt(6, (Integer) data.getAge());
            stmt.setString(7, data.getDetail());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteMember(MemberVO vo) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_DELETE);
            stmt.setInt(1, vo.getSid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateMember(MemberVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_UPDATE);
            stmt.setString(1, vo.getUserid());
            stmt.setString(2, vo.getUsername());
            stmt.setString(3, vo.getPhoto());
            stmt.setString(4, vo.getEmail());
            stmt.setString(5, vo.getGender());
            stmt.setInt(6, (Integer) vo.getAge());
            stmt.setString(7, vo.getDetail());


            System.out.println(vo.getUserid() + "-" + vo.getUsername() + "-" + vo.getPhoto()  + "-" + vo.getEmail() + "-" + vo.getGender() + "-" + vo.getAge() + "-" + vo.getDetail());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public MemberVO selectMember(int sid) {
        MemberVO one = null;
        conn = JDBCUtil.getConnection();
        try{
            stmt = conn.prepareStatement(M_SELECT);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if (rs.next()){
                one=new MemberVO();
                one.setSid(rs.getInt("sid"));
                one.setUserid(rs.getString("userid"));
                one.setUsername(rs.getString("username"));
                one.setPhoto(rs.getString("photo"));
                one.setEmail(rs.getString("email"));
                one.setGender(rs.getString("gender"));
                one.setAge(rs.getInt("age"));
                one.setRegdate(rs.getDate("regdate"));
                one.setDetail(rs.getString("detail"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return one;
    }
    public ArrayList<MemberVO> listMember(){
        ArrayList<MemberVO> list = null;
        conn = JDBCUtil.getConnection();
        try{
            stmt = conn.prepareStatement(M_LIST);
            rs = stmt.executeQuery();
            list = new ArrayList<MemberVO>();
            MemberVO one = new MemberVO();
            while(rs.next()) {
                one=new MemberVO();
                one.setSid(rs.getInt("sid"));
                one.setUserid(rs.getString("userid"));
                one.setUsername(rs.getString("username"));
                one.setPhoto(rs.getString("photo"));
                one.setEmail(rs.getString("email"));
                one.setGender(rs.getString("gender"));
                one.setAge(rs.getInt("age"));
                one.setRegdate(rs.getDate("regdate"));
                list.add(one);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getPhotoFilename(int sid) {
        String filename = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_SELECT);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if (rs.next()) {
                filename = rs.getString("photo");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
