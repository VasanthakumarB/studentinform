import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import p2.UpdateBean;


public class FetchAllAction {
	Connection con=DemoCon.Meth();
	public List<UpdateBean> FetchData(){
		ResultSet rs=null;
		List<UpdateBean> list=new ArrayList<UpdateBean>();
		try{
			Statement s=con.createStatement();
			rs=s.executeQuery("select * from student_data");
			while(rs.next()){
				UpdateBean a=new UpdateBean();
				a.setName(rs.getString("name"));
				a.setAge(rs.getString("age"));
				a.setEmail(rs.getString("email"));
				a.setPhoneno(rs.getString("phoneno"));
				a.setDate(rs.getDate("doj"));
				a.setStuid(rs.getInt("stuid"));
				list.add(a);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

}
