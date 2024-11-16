package com.dukz.blockchain;

import com.dukz.utils.StrUtil;

/**
 * 区块链Block
 * @link https://medium.com/programmers-blockchain
 *
 * @ClassName Block
 * @Author dukz
 * @Date 2022/6/8
 * @Version 1.0
 */
public class Block {

    public String hash;
    public String previousHash;
    /**
     * our data will be a simple message.
     */
    private String data;
    /**
     * as number of milliseconds since 1/1/1970.
     */
    private long timeStamp;
    private int nonce;

    /**
     * Block Constructor.
     */
    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        // Making sure we do this after we set the other values.
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StrUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }
    public void mineBlock(int difficulty) {
        //Create a string with difficulty * "0"
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
