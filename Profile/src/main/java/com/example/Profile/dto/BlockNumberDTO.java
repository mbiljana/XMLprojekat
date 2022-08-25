package com.example.Profile.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockNumberDTO {
    private int blockNum;

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public BlockNumberDTO(int blockNum) {
        super();
        this.blockNum = blockNum;
    }
    public BlockNumberDTO() {}
}