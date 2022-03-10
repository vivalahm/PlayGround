package com.fastcampus.board;

import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.entity.Board;
import com.fastcampus.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String createPost(@ModelAttribute("command") PostDto postDto){
        System.out.println("save " + postDto);
        Board board = new Board(postDto.getNickName(),postDto.getTitle(),postDto.getContent());
        boardService.boardSave(board);
        return "redirect:/"; // 추가 후 홈 화면으로
    }

    @RequestMapping("/")
    public String ReadAllPost(Model model){
        List<PostDto> postList = new ArrayList<>();

        for (Board board: boardService.boardList()){
            boardService.boardUpdateCNT(board.getSeq());//조회 할때 마다 조회수 1증가
            postList.add(new PostDto(board.getSeq(), board.getWriter(), board.getTitle(), board.getContent() ));
        }
        System.out.println(postList);

        model.addAttribute("postList", postList);

        return "index";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("command") PostDto postDto){
        System.out.println("update " + postDto);
        boardService.boardUpdate(postDto.getPostId(),postDto.getNickName(),postDto.getTitle(),postDto.getContent());

        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        System.out.println("삭제 " + id);
        boardService.boardDelete(id);
        return "redirect:/";
    }

    // ***************************************************************************************************
    // ******************************************* Do not edit *******************************************
    // 아래 부분은 수정 안하셔도 됩니다. (글 생성, 글 업데이트 창으로 연결하는 부분)

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new PostDto());
        return "create";
    }

    @RequestMapping(value="/updateView/{id}")
    public String ViewUpdate(@PathVariable int id, Model model){
        PostDto postDto = new PostDto();
        postDto.setPostId(id);
        model.addAttribute("command",postDto);
        return "update";
    }
}

