package com.musical.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.musical.domain.Criteria;
import com.musical.domain.MemberVO;
import com.musical.domain.MusicalVO;
import com.musical.domain.PayVO;
import com.musical.domain.ReservationVO;
import com.musical.domain.Seatinfo;
import com.musical.service.MusicalService;
import com.musical.service.ReservationService;

@Controller
@RequestMapping("/res")
public class ReservationController {

	@Autowired
	private ReservationService rs;
	
	@Autowired
	private MusicalService ms;
	
	@RequestMapping(value="/resList",method=RequestMethod.GET)
	public String reslist(Model model)throws Exception{
		String url="/res/resList";
		List<ReservationVO> resList=rs.readResList();
		model.addAttribute("list",resList);
		return url;
	}
	
	/*@RequestMapping("/readRes")
	public void readRes(int ttr_no,Model model)throws Exception{
		ReservationVO res=rs.readResByno(ttr_no);
		model.addAttribute(res);		
	}*/
	@RequestMapping(value="/removeRes",method=RequestMethod.POST)
	public String removeRes(int ttr_no)throws Exception{
		String url="redirect:/res/reslist";
		rs.deletettrno(ttr_no);
		return url;
	}
	@RequestMapping(value="/createRes",method=RequestMethod.GET)
	public String createRes(@RequestParam("ttr_no") int ttr_no,Model model)throws Exception{
		String url="com/res/createRes";
		
		MusicalVO mv=ms.readMusicalBymcno(ttr_no);
		String[] seat_ids=mv.getSeat_id();
		int[] seat_cnt=new int[seat_ids.length];
		for(int i=0;i<seat_ids.length;i++){
			seat_cnt[i]=rs.countresbyseat_id(seat_ids[i]);
		}
		model.addAttribute(mv);
		model.addAttribute("seat_cnt",seat_cnt);
		return url;
	}
	@RequestMapping(value="/createRes",method=RequestMethod.POST)
	public String createRes(@RequestParam("rescheck")String[] rescheck,HttpSession session,
			MusicalVO mv,Model model)throws Exception{
		String url="redirect:/res/reslist";
		String[] seat_id=new String[rescheck.length];
		int[] res_nom=new int[rescheck.length];
		MemberVO mem=(MemberVO) session.getAttribute("loginUser");
		List<ReservationVO> reslist=new ArrayList<ReservationVO>();
		List<Seatinfo> seatlist=new ArrayList<Seatinfo>();
		int pri=0;
		for(int i=0;i<rescheck.length;i++){
			seat_id[i]=rescheck[i].split("_")[0];
			res_nom[i]=Integer.parseInt(rescheck[i].split("_")[1]);
		}
		for(int i=0;i<rescheck.length;i++){
			ReservationVO res=new ReservationVO(null,null,res_nom[i],seat_id[i],"tj",mv.getTtr_no(),null);
			reslist.add(res);
		}
		for(ReservationVO res:reslist){
			seatlist.add(ms.readseatbyseat_id(res.getSeat_id()));
		}
		for(Seatinfo seat:seatlist){
			pri+=seat.getSeat_pri();
		}
		PayVO pay=new PayVO(mv.getTtr_title(),pri,mem.getMem_mail(),mem.getMem_name(),mem.getMem_mobile(),mem.getMem_addr(),null);
		model.addAttribute("reslist",reslist);
		model.addAttribute("seatlist",seatlist);
		model.addAttribute("pay",pay);
		return url;
	}
	
	/*@RequestMapping(value="/listCri",method=RequestMethod.GET)
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
						   @RequestParam("ttr_no")int ttr_no,Model model)
						   		throws Exception{
		String url="/res/readRes";
		
		ReservationVO res=rs.readResByno(ttr_no);
		model.addAttribute(res);
		
		return url;
	}*/
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String removeRes(Criteria cri,int ttr_no,
							  RedirectAttributes rttr)throws Exception{
		String url="redirect:/res/resList";
		rs.deletettrno(ttr_no);
		rttr.addFlashAttribute("cri",cri);
		return url;
	}
	
}





























