package com.example.demo.student.dao.impl;
import com.example.demo.student.bean.StudentBean;
import com.example.demo.student.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;




@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllStudent() {
        return jdbcTemplate.queryForList("select studentid,student_name,emailID,birth_date,joining_date,blood_group,mobile_number from studentmaster");
    }

    @Override
    public int getStudentCount() {
        return jdbcTemplate.queryForObject("select count(*) from studentmaster", Integer.class);
    }

    @Override
    public List<Map<String, Object>> getCityWiseStudent(String string) {
        return jdbcTemplate.queryForList("select studentid,student_name,city_name from studentmaster sm\n" +
                "inner join citymaster cm on sm.cityid = cm.cityid\n" +
                "and city_name='" + string + "'");
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToCity(){
        return jdbcTemplate.queryForList("select sm.cityid,city_name,count(*) as \"number of students\"\n" +
                "from studentmaster sm\n" +
                "inner join citymaster cm on sm.cityid=cm.cityid\n" +
                "group by cityid");
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToStandard() {
        return jdbcTemplate.queryForList("select stdm.standardid,standard_name,count(*) as \"number of students\"\n" +
                "from studentmaster sm\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "group by stdm.standardid");
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToStandardAndCity() {
        return jdbcTemplate.queryForList("select city_name,standard_name,count(studentid)\n" +
                "from studentmaster sm\n" +
                "inner join citymaster cm on cm.cityid=sm.cityid\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "group by city_name,standard_name");
    }

    @Override
    public List<Map<String, Object>> getListOfStudentThoseCity_nameStartsFromGivenAlphabet(String alphabet){
        return jdbcTemplate.queryForList("select studentid,student_name,city_name\n" +
                "from studentmaster sm \n" +
                "inner join citymaster cm on cm.cityid=sm.cityid\n" +
                "and (city_name like \"'"+  alphabet +"'%\")\n" +
                "order by city_name");
    }

    @Override
    public List<Map<String, Object>> getStudentListWhoseNameIsSame() {
        return jdbcTemplate.queryForList("select a.student_name,a.studentid\n" +
                "from studentmaster a \n" +
                "inner join studentmaster b on a.student_name=b.student_name\n" +
                "and a.studentid<>b.studentid\n" +
                "order by student_name");
    }

    @Override
    public List<Map<String, Object>> getListOfTotalFeesStandardWise(){
        return jdbcTemplate.queryForList("select standard_name,sum(amount) as \"Total fees\"\n" +
                "from studentmaster sm \n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "group by standard_name");
    }

    @Override
    public List<Map<String, Object>> getSumOfFeesCityWiseAndStandardWise(){
        return jdbcTemplate.queryForList("select city_name,standard_name,sum(amount)\n" +
                "from studentmaster sm \n" +
                "inner join citymaster cm on cm.cityid=sm.cityid\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "group by city_name,standard_name\n" +
                "order by standard_name\n");
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoDoesNotPaidAnyAmount(){
        return jdbcTemplate.queryForList("select studentid, student_name,Total_fees\n" +
                "from studentmaster sm\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "where sm.studentid not in (select studentid from fees_detail)");
    }

    @Override
    public List<Map<String, Object>> getFessPendingStudent(){
        return jdbcTemplate.queryForList("select * from\n" +
                "(select sm.studentid,student_name,Total_fees,sum(amount) as \"Paid amount\",(Total_fees-sum(amount)) as \"Remaining amount\"\n" +
                "from studentmaster sm \n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "group by studentid\n" +
                "having sum(amount)!=Total_fees\n" +
                "union all\n" +
                "select sm.studentid,student_name,Total_fees,0 \"Paid amount\", Total_fees as \"Remaining amount\"\n" +
                "from studentmaster sm \n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "where sm.studentid not in (select studentid from fees_detail)) a\n" +
                "order by studentid\n");
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoPaidFeesInCurrentMonth(){
        return jdbcTemplate.queryForList("select student_name,sm.studentid,11 payment_month\n" +
                "from studentmaster sm\n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "where month(payment_date) = month(current_date())\n");
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoPaidFullFees(){
        return jdbcTemplate.queryForList("select sm.studentid,sm.student_name,sum(amount),Total_fees\n" +
                "from studentmaster sm\n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "inner join standardmaster stdm on stdm.standardid = sm.standardid\n" +
                "group by sm.studentid\n" +
                "having sum(amount) = Total_fees\n" +
                "order by studentid");
    }

    @Override
    public List<Map<String, Object>> getDateWiseStandardWiseFeesCollection(){
        return jdbcTemplate.queryForList("select payment_date,standard_name,sum(amount)\n" +
                "from studentmaster sm\n" +
                "inner join fees_detail fd on fd.studentid=sm.studentid\n" +
                "inner join standardmaster stdm on stdm.standardid=sm.standardid\n" +
                "group by payment_date,standard_name\n" +
                "order by standard_name");
    }

    @Override
    public List<Map<String, Object>> getCityWiseStandardWisePendingList(){
        return jdbcTemplate.queryForList("select * from\n" +
                "(select stm.studentid,student_name,stdm.Total_fees,sum(amount)as 'Paid_amount',(Total_fees-sum(amount)) as 'Remaing_amount',cm.city_name,stdm.standard_name\n" +
                "from studentmaster stm\n" +
                "join fees_detail fd on fd.studentid = stm.studentid  \n" +
                "join standardmaster stdm on stdm.standardid = stm.standardid\n" +
                "join citymaster cm on cm.cityid =stm.cityid\n" +
                "group by studentid,city_name,standard_name\n" +
                "having Paid_amount != Total_fees\n" +
                "union all\n" +
                "select stm.studentid,student_name,stdm.Total_fees,0 'Paid_amount',(Total_fees) as 'Remaing_amount',cm.city_name,stdm.standard_name\n" +
                "from studentmaster stm\n" +
                "join standardmaster stdm on stdm.standardid = stm.standardid\n" +
                "join citymaster cm on cm.cityid = stm.cityid\n" +
                "where stm.studentid not in (select studentid from fees_detail)) a\n" +
                "order by studentid");
    }

    @Override
    public List<Map<String, Object>> getCountNumberOfStudentWhoAreInPendingList(){
        return jdbcTemplate.queryForList("select count(studentid),cm.city_name,stdm.standard_name from\n" +
                "(select stm.studentid,student_name,stdm.Total_fees,sum(amount)as 'Paid_amount',(Total_fees-sum(amount)) as 'Remaing_amount',stm.cityid,stm.standardid\n" +
                "from studentmaster stm\n" +
                "join fees_detail fd on fd.studentid = stm.studentid  \n" +
                "join standardmaster stdm on stdm.standardid = stm.standardid\n" +
                "group by studentid\n" +
                "having Paid_amount != Total_fees\n" +
                "union all\n" +
                "select stm.studentid,student_name,stdm.Total_fees,0 'Paid_amount',(Total_fees) as 'Remaing_amount',stm.cityid,stm.standardid\n" +
                "from studentmaster stm\n" +
                "join standardmaster stdm on stdm.standardid = stm.standardid\n" +
                "where stm.studentid not in (select studentid from fees_detail)) a, citymaster cm,standardmaster stdm\n" +
                "where a.cityid = cm.cityid\n" +
                " and a.standardid = stdm.standardid\n" +
                "group by cm.city_name,stdm.standard_name");
    }


    @Override
    public Map getStudentyById(int id) {
        System.out.println("id - " + id);
        return jdbcTemplate.queryForMap("select studentid,student_name,emailID,birth_date,joining_date,blood_group,mobile_number from studentmaster where studentid='" + id + "'");
    }

    @Override
    public int insertStudentBean(StudentBean studentBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("insert into studentmaster(student_name,emailID,birth_date,joining_date,blood_group,mobile_number,cityid,standardid) values(:student_name,:emailID,:birth_date,:joining_date,:blood_group,:mobile_number,:cityid,:standardid)",new BeanPropertySqlParameterSource(studentBean));
    }


    @Override
    public int insertTokenFeesProcedureCalling(){
        int x = jdbcTemplate.queryForObject("select max(studentid) from studentmaster", Integer.class);
        jdbcTemplate.update("call student.insert_5000_fess('"+ x +"')");
        return 0;
    }

    @Override
    public int updatingFeesWithUpdatingStudentmasterDetails(StudentBean studentBean){
        jdbcTemplate.update("call student.updating_fees_amount('"+studentBean.getStudentid()+"')");
        return 0;
    }

    @Override
    public int updateStudent(StudentBean studentBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("update studentmaster set student_name=:student_name,emailID=:emailID,birth_date=:birth_date,joining_date=:joining_date,blood_group=:blood_group,mobile_number=:mobile_number,cityid=:cityid,standardid=:standardid where studentid=:studentid",new BeanPropertySqlParameterSource(studentBean));
    }

    @Override
    public int deleteStudent(StudentBean studentBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("delete from studentmaster where studentid=:studentid",new BeanPropertySqlParameterSource(studentBean));
    }

    @Override
    public int getMaxstudentId(){
        int x = jdbcTemplate.queryForObject("select count(studentid) from studentmaster", Integer.class);
        return x;
    }



}
