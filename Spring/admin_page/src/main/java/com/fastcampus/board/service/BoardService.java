package com.fastcampus.board.service;

import com.fastcampus.board.entity.Board;
import com.fastcampus.board.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    //POST
    @Transactional
    public void boardSave(Board board){
        boardRepository.save(board);
    }

    //GET ALL
    @Transactional
    public List<Board> boardList(){
        return (List<Board>) boardRepository.findAll();
    }

    //GET
    @Transactional
    public Board boardSelect(int id){
        return boardRepository.findById(id).orElseThrow(
                ()-> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );
    }

    //UPDATE
    @Transactional
    public void boardUpdate(int id, String writer, String title, String content){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );
        board.setWriter(writer);
        board.setTitle(title);
        board.setContent(content);
        board.setCnt(board.getCnt() +1);// 수정 시 CNT 1씩 증가
        System.out.println(board);
    }

    //UPDATE CNT
    @Transactional
    public void boardUpdateCNT(int id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );
        board.setCnt(board.getCnt() +1);// 수정 시 CNT 1씩 증가
        System.out.println(board.getCnt());
    }

    //DELETE
    @Transactional
    public void boardDelete(int id){
        boardRepository.deleteById(id);
    }


}
