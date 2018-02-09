package com.musical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.musical.domain.Criteria;
import com.musical.domain.PageMaker;
import com.musical.domain.ReservationVO;
import com.musical.service.ReservationService;

@Controller
@RequestMapping("/res")
public class ReservationController {

	@Autowired
	private ReservationService rs;
		
	@RequestMapping(value="/resList",method=RequestMethod.GET)
	public String reslist(Model model)throws Exception{
		String url="/res/resList";
		List<ReservationVO> resList=rs.readResList();
		model.addAttribute("list",resList);
		return url;
	}
	
	@RequestMapping("/readRes")
	public void readRes(String res_id,Model model)throws Exception{
		ReservationVO res=rs.readResById(res_id);
		model.addAttribute(res);		
	}
	@RequestMapping(value="/removeRes",method=RequestMethod.POST)
	public String removeRes(int ttr_no)throws Exception{
		String url="redirect:/res/reslist";
		rs.deleteRes(ttr_no);
		return url;
	}
	@RequestMapping(value="createRes",method=RequestMethod.GET)
	public String createRes()throws Exception{
		String url="res/createRes";
		return url;
	}
	@RequestMapping(value="/createRes",method=RequestMethod.POST)
	public String createRes(ReservationVO res)throws Exception{
		String url="redirect:/res/reslist";
		rs.createRes(res);
		return url;
	}
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public String listCri(Criteria cri,Model model) throws Exception{
		String url="res/reslist";
		List<ReservationVO> resList=rs.readResListCriteria(cri);
		model.addAttribute("list",resList);
		return url;
	}
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPage(@ModelAttribute("cri")Criteria cri,
			Model model)throws Exception{
		String url="res/listPage";
		List<ReservationVO> resList = rs.readResListCriteria(cri);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(rs.readResList().size());
		
		model.addAttribute("list",resList);
		model.addAttribute("pageMaker",pageMaker);
		
		return url;
	}
	@RequestMapping(value="/readRes",method=RequestMethod.GET)
	public String readRes(@ModelAttribute("cri")Criteria cri,
						   @RequestParam("res_id")String res_id,Model model)
						   		throws Exception{
		String url="/res/readRes";
		
		ReservationVO res=rs.readResById(res_id);
		model.addAttribute(res);
		
		return url;
	}
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String removeRes(Criteria cri,int ttr_no,
							  RedirectAttributes rttr)throws Exception{
		String url="redirect:/res/resList";
		rs.deleteRes(ttr_no);
		rttr.addFlashAttribute("cri",cri);
		return url;
	}
	
}





























