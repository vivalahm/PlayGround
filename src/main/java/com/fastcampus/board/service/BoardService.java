package com.fastcampus.board.service;

import com.fastcampus.board.entity.Board;
import com.fastcampus.board.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    //GET
    @Transactional
    public Board boardSelect(int id){
        return boardRepository.findById(id).orElseThrow(
                ()-> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );
    }

    //UPDATE
    @Transactional
    public void boardUpdate(int id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );

        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        System.out.println(board);
    }

    //DELETE
    @Transactional
    public void boardDelete(int id){
        boardRepository.deleteById(id);
    }


}
