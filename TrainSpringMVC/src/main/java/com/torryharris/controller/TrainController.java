package com.torryharris.controller;

import com.torryharris.DAO.TrainDAO;
import com.torryharris.api.Train;
import com.torryharris.mapper.TrainRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainDAO trainDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/showtrain")
    public ModelAndView showTrain(HttpServletRequest request, HttpServletResponse response)
    {
        List<Train>trainList=trainDAO.loadTrains();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("form.jsp");
        mv.addObject("trains",trainList);
        return mv;
    }
    @GetMapping("/find")
    public String bookTicket()
    {
        return "find.jsp";
    }
    @GetMapping("/take")
    public ModelAndView findTrain(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv=new ModelAndView();
        int num1 = Integer.parseInt(request.getParameter("num1"));

        List<Train>trainList= trainDAO.loadTrains(num1);
        if(trainList==null) {
            mv.setViewName("error.jsp");
        }
        else {
            mv.setViewName("book.jsp");
            mv.addObject("find", trainList);
        }
        return mv;
    }
}
