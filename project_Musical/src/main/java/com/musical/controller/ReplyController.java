package com.musical.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musical.domain.Criteria;
import com.musical.domain.PageMaker;
import com.musical.domain.ReplyVO;
import com.musical.service.MusicalService;
import com.musical.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private MusicalService ms;
	@Autowired
	private ReplyService rs;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply) {
		
		System.out.println(reply);
		ResponseEntity<String> entity = null;
		try {
			rs.addReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/all/{ttr_no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("ttr_no") int ttr_no) {

		ResponseEntity<List<ReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<List<ReplyVO>>(
					rs.getReplyList(ttr_no), HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/{tr_rno}", method = { RequestMethod.PUT,
			RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("tr_rno") int tr_rno,
			@RequestBody ReplyVO reply) {

		ResponseEntity<String> entity = null;

		try {
			reply.setTr_rno(tr_rno);
			System.out.println(reply);
			rs.modifyReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{ttr_no}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("ttr_no") int ttr_no, @PathVariable("page") int page) {

		ResponseEntity<Map<String, Object>> entity = null;

		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(10);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> replyList = rs.getReplyListPage(ttr_no, cri);
			
			map.put("list",replyList);
			
			int replyCount=rs.countReply(ttr_no);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value="/{tr_rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("tr_rno")int tr_rno){
		
		ResponseEntity<String> entity=null;
		
		try {
			rs.removeReply(tr_rno);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	@RequestMapping(value="/scoreavg/{ttr_no}")
	public ResponseEntity<Double> scoreavg(@PathVariable("ttr_no")int ttr_no){
		ResponseEntity<Double> entity = null;
		try {
			double avg=ms.scoreavg(ttr_no);
			double b = Math.round(avg*100d)/100d;
			entity = new ResponseEntity<Double>(b, HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
