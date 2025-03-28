package kr.co.kosmo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kosmo.mvc.dto.PageVO;
import kr.co.kosmo.mvc.dto.RecipeMemberDTO;
import kr.co.kosmo.mvc.service.RecipeMemberBoardService;

@Controller
public class MemberBoardController {

	@Autowired
	private RecipeMemberBoardService recipeMemberBoardService;

	@RequestMapping("/getBoard")
	public void getBoard(RecipeMemberDTO vo, Model m) {
		RecipeMemberDTO result = recipeMemberBoardService.getBoard(vo);
		m.addAttribute("board", result);
	}

	@RequestMapping("/getBoardList")
	public void getBoardList(RecipeMemberDTO vo, Model m) {
		m.addAttribute("boardList", recipeMemberBoardService.getBoardList(vo));
	}

	@RequestMapping(value = "/memberDetail", method = RequestMethod.GET)
	public String detail(int mem_no, Model model) {
		RecipeMemberDTO recipeMemberDTO = recipeMemberBoardService.getMemberDetail(mem_no);
		model.addAttribute("board", recipeMemberDTO);
		return "admin/memberDetail";

	}

	@RequestMapping(value = "/upupup", method = RequestMethod.POST)
	public String updateval(RecipeMemberDTO vo) {
		recipeMemberBoardService.update(vo);
		return "redirect:memberList";
	}

	
   @RequestMapping(value = "/memberList", method = RequestMethod.GET)
   public String listSearch(PageVO svo, Model model,
         @RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
         @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") String cntPerPage,
         @RequestParam(required = false) String searchType, @RequestParam(required = false) String keyword) {
      int total = recipeMemberBoardService.getTotalCount(svo);
      svo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
      System.out.print(total);
      svo.setSearchType(searchType);
      svo.setKeyword(keyword);
      model.addAttribute("paging", svo);
      model.addAttribute("list", recipeMemberBoardService.getMemberList(svo));
      return "admin/memberList";
   }

}
