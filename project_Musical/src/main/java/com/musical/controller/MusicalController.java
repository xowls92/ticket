package com.musical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.musical.domain.MusicalVO;
import com.musical.service.MusicalService;

@Controller
public class MusicalController {
	
	@Autowired
	private MusicalService musicalService;
	
	@RequestMapping(value="/mclistA",method=RequestMethod.GET)
	public String mclist(Model model)throws Exception{
		String url="/mc/mclistA";
		List<MusicalVO> mcList=musicalService.readMcList();
		model.addAttribute("list",mcList);
		
		return url;
	}
	
	@RequestMapping("/readMcPage")
	public void readMc(int mcno,Model model)throws Exception{
		MusicalVO mc=musicalService.readMusicalBymcno(mcno);
		model.addAttribute(mc);
	}
	@RequestMapping(value="/modifyMusical",method=RequestMethod.GET)
	public void modifyMusical(int mcno,Model model)throws Exception{
		MusicalVO mc=musicalService.readMusicalBymcno(mcno);
		model.addAttribute(mc);		
	}
	
	@RequestMapping(value="/modifyMusical",method=RequestMethod.POST)
	public String modifyMusical(MusicalVO mc,Model model)throws Exception{
		
		String url="redirect:/mc/mclistA";
		musicalService.updateMc(mc);
		return url;
	}
	@RequestMapping(value="/removeMusical",method=RequestMethod.GET)
	public String removeMusical(int mcno)throws Exception{
		String url="redirect:/mc/mclistA";
		musicalService.deleteMc(mcno);
		return url;
	}
	@RequestMapping(value="/createMusical",method=RequestMethod.GET)
	public String createMusical()throws Exception{
		String url="/mc/createMcForm";
		return url;
	}
	
	@RequestMapping(value="/createMusical",method=RequestMethod.POST)
	public String createMusical(MusicalVO mc)throws Exception{
		String url="redirect:/mc/mclistA";
		musicalService.createMc(mc);
		return url;
	}
	@RequestMapping(value="/readMcPage",method=RequestMethod.GET)
	public String readPage(@RequestParam("mcno") int mcno,Model model)throws Exception{
		String url="/mc/readMcPage";
		
		MusicalVO mc=musicalService.readMusicalBymcno(mcno);
		model.addAttribute(mc);
		
		return url;
	}
	@RequestMapping(value="/modifyPageForm",method=RequestMethod.GET)
	public String modifyPageForm(@RequestParam("mcno") int mcno, Model model)throws Exception{
		String url="/mc/modifyPage";
		MusicalVO mc=musicalService.readMusicalBymcno(mcno);
		model.addAttribute(mc);
		
		return url;
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.POST)
	public String modifyPage(MusicalVO mc,RedirectAttributes rttr)throws Exception{
		musicalService.updateMc(mc);
		
		return "redirect:/mc/modifyList";
	}
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String removeMusical(int mcno,RedirectAttributes rttr)throws Exception{
		String url="redirect:/mc/mclistA";
		musicalService.deleteMc(mcno);
		return url;
	}
	@RequestMapping(value="/createPage",method=RequestMethod.GET)
	public String createPage()throws Exception{
		String url="mc/createMcForm";
		return url;
	}
	@RequestMapping(value="/createPage",method=RequestMethod.POST)
	public String createPage(MusicalVO mc)throws Exception{
		String url="redirect:/mc/listPage";
		musicalService.createMc(mc);
		return url;
	}
}

























