package com.example.demo.student.controller;
import com.example.demo.student.bean.StudentBean;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Map<String, Object>> getAllStudent() {
        List<Map<String, Object>> lstAllStudent= studentService.getAllStudent();
        System.out.println(lstAllStudent);
        return studentService.getAllStudent();
    }


    @GetMapping("/getCityWiseStudent/{city_name}")
    public List<Map<String, Object>> getAllCityWiseStudent(@PathVariable("city_name")  String string) {
        List<Map<String, Object>> lstAllCityWiseStudent= studentService.getCityWiseStudent(string);
        System.out.println(lstAllCityWiseStudent);
        return studentService.getCityWiseStudent(string);
    }

    @GetMapping("/getCountOfStudentAccordingToCity")
    public List<Map<String, Object>> getCountOfStudentAccordingToCity() {
        List<Map<String, Object>> lstAllStudent= studentService.getCountOfStudentAccordingToCity();
        System.out.println(lstAllStudent);
        return studentService.getCountOfStudentAccordingToCity();
    }

    @GetMapping("/getCountOfStudentAccordingToStandard")
    public List<Map<String, Object>> getCountOfStudentAccordingToStandard() {
        List<Map<String, Object>> lstAllStudent= studentService.getCountOfStudentAccordingToStandard();
        System.out.println(lstAllStudent);
        return studentService.getCountOfStudentAccordingToStandard();
    }

    @GetMapping("/getCountOfStudentAccordingToStandardAndCity")
    public List<Map<String, Object>> getCountOfStudentAccordingToStandardAndCity() {
        List<Map<String, Object>> lstAllStudent= studentService.getCountOfStudentAccordingToStandardAndCity();
        System.out.println(lstAllStudent);
        return studentService.getCountOfStudentAccordingToStandardAndCity();
    }

    @GetMapping("/getListOfStudentThoseCity_nameStartsFromGivenAlphabet/{alphabet}")
    public List<Map<String, Object>> getListOfStudentThoseCity_nameStartsFromGivenAlphabet(@PathVariable ("alphabet") String alphabet) {
        List<Map<String, Object>> lstAllStudent= studentService.getListOfStudentThoseCity_nameStartsFromGivenAlphabet(alphabet);
        System.out.println(lstAllStudent);
        return studentService.getListOfStudentThoseCity_nameStartsFromGivenAlphabet(alphabet);
    }

    @GetMapping("/getStudentListWhoseNameIsSame")
    public List<Map<String, Object>> getStudentListWhoseNameIsSame() {
        List<Map<String, Object>> lstAllStudent= studentService. getStudentListWhoseNameIsSame();
        System.out.println(lstAllStudent);
        return studentService.getStudentListWhoseNameIsSame();
    }

    @GetMapping("/getListOfTotalFeesStandardWise")
    public List<Map<String, Object>> getListOfTotalFeesStandardWise(){
        List<Map<String, Object>> lstAllStudent= studentService.getListOfTotalFeesStandardWise();
        System.out.println(lstAllStudent);
        return studentService.getListOfTotalFeesStandardWise();
    }

    @GetMapping("/getSumOfFeesCityWiseAndStandardWise")
    public List<Map<String, Object>>getSumOfFeesCityWiseAndStandardWise(){
        List<Map<String, Object>> lstAllStudent= studentService.getSumOfFeesCityWiseAndStandardWise();
        System.out.println(lstAllStudent);
        return studentService.getSumOfFeesCityWiseAndStandardWise();
    }

    @GetMapping("/getListOfStudentWhoDoesNotPaidAnyAmount")
    public List<Map<String, Object>> getListOfStudentWhoDoesNotPaidAnyAmount(){
        List<Map<String, Object>> lstAllStudent= studentService.getListOfStudentWhoDoesNotPaidAnyAmount();
        System.out.println(lstAllStudent);
        return studentService.getListOfStudentWhoDoesNotPaidAnyAmount();
    }

    @GetMapping("/getListOfStudentWhoPaidFullFees")
    public List<Map<String, Object>> getListOfStudentWhoPaidFullFees(){
        List<Map<String, Object>> lstAllStudent = studentService.getListOfStudentWhoPaidFullFees();
        System.out.println(lstAllStudent);
        return studentService.getListOfStudentWhoPaidFullFees();
    }

    @GetMapping("/getFessPendingStudent")
    public List<Map<String, Object>> getFessPendingStudent(){
        List<Map<String, Object>> lstAllStudent = studentService.getFessPendingStudent();
        System.out.println(lstAllStudent);
        return studentService.getFessPendingStudent();
    }

    @GetMapping("/getListOfStudentWhoPaidFeesInCurrentMonth")
    public List<Map<String, Object>> getListOfStudentWhoPaidFeesInCurrentMonth(){
        List<Map<String, Object>> lstAllStudent= studentService.getListOfStudentWhoPaidFeesInCurrentMonth();
        System.out.println(lstAllStudent);
        return studentService.getListOfStudentWhoPaidFeesInCurrentMonth();
    }

    @GetMapping("/getDateWiseStandardWiseFeesCollection")
    public List<Map<String, Object>> getDateWiseStandardWiseFeesCollection(){
        List<Map<String, Object>> lstAllStudent= studentService.getDateWiseStandardWiseFeesCollection();
        System.out.println(lstAllStudent);
        return studentService.getDateWiseStandardWiseFeesCollection();
    }

    @GetMapping("/getCityWiseStandardWisePendingList")
    public List<Map<String, Object>> getCityWiseStandardWisePendingList(){
        List<Map<String, Object>> lstAllStudent= studentService.getCityWiseStandardWisePendingList();
        System.out.println(lstAllStudent);
        return studentService.getCityWiseStandardWisePendingList();
    }

    @GetMapping("/getCountNumberOfStudentWhoAreInPendingList")
    public List<Map<String, Object>> getCountNumberOfStudentWhoAreInPendingList(){
        List<Map<String, Object>> lstAllStudent= studentService.getCountNumberOfStudentWhoAreInPendingList();
        System.out.println(lstAllStudent);
        return studentService.getCountNumberOfStudentWhoAreInPendingList();
    }


    @GetMapping("/getStudentCount")
    public Map getStudentCount() {
        int iStudentCount = studentService.getStudentCount();

        Map mResult = new HashMap();
        mResult.put("count", iStudentCount);

        System.out.println(mResult);

        return mResult;
    }

    @GetMapping("/getStudentById/{studentId}")
    public Map getStudentById(@PathVariable("studentId") int studentId) {
        System.out.println("getStudentById Call");
        Map mResult = new HashMap();
        try {
            mResult = studentService.getStudentyById(studentId);
            System.out.println(mResult);
        } catch (Exception ex) {
            System.out.println("ex--" + ex.getMessage());
        }
        return mResult;
    }

    @Transactional
    @PostMapping("/insertStudentBean")
    public Map insertStudentBean(@RequestBody @Valid StudentBean studentBean) {
        System.out.println("insert Student Bean");
        System.out.println("student bean = "+studentBean.toString());
        int iRes = studentService.insertStudentBean(studentBean);
        int fRes = studentService.insertTokenFeesProcedureCalling();
        System.out.println(fRes);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "insert successfully");
        } else {
            mResult.put("msg", "insert fail");
        }
        return mResult;
    }

    @PostMapping("/updateStudent")
    public Map updateStudent(@RequestBody @Valid  StudentBean studentBean) {
        System.out.println("insert Student Bean");
        System.out.println("city bean = "+studentBean.toString());
        int iRes = studentService.updateStudent(studentBean);
        int uRes = studentService.updatingFeesWithUpdatingStudentmasterDetails(studentBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "update successfully");
        } else {
            mResult.put("msg", "update fail");
        }
        return mResult;
    }

    @PostMapping("/deleteStudent")
    public Map deleteStudent(@RequestBody StudentBean studentBean) {
        System.out.println("insert Student Bean");
        System.out.println("city bean = "+studentBean.toString());
        int iRes = studentService.deleteStudent(studentBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "delete successfully");
        } else {
            mResult.put("msg", "delete fail");
        }
        return mResult;
    }

}

