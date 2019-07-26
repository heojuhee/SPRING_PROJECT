package com.example.project.service;

public class BoardPager {

	// 페이지당 게시글 수 -> 레코드 수
	public static final int PAGE_SCALE = 10;

	public static final int BLOCK_SCALE = 10;

	private int curPage;// 현재 페이지 수
	private int prevPage; // 이전 페이지
	private int nextPage; // 다음 페이지
	private int totPage; // 전체 페이지

	// 블럭 관련
	private int curBlock;
	private int prevBlock;
	private int nextBlock;
	private int totBlock;

	// 페이지 시작글번호 , 끝 번호
	private int pageBegin;
	private int pageEnd;
	// 블럭 시작 번호, 끝 번호
	private int blockBegin;
	private int blockEnd;

	public BoardPager(int count, int curPage) {
		curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock();
		setBlockRange();
	}

	private void setBlockRange() {
		// 현재 속해있는 블럭 계산
		curBlock = (int) Math.ceil((curPage - 1) * BLOCK_SCALE) + 1;

		// 블럭의 시작 범위
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;

		// 블럭의 골
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		// 1-10 (1block), 11~20(2block)

		if (blockEnd > totPage) {
			blockEnd = totPage;
		}

		prevPage = (curPage == 1) ? 1 : (curBlock - 1) * BLOCK_SCALE;
		nextPage = (curBlock > totBlock) ? (curBlock * BLOCK_SCALE) : (curBlock * BLOCK_SCALE) + 1;

		if (nextPage >= totPage) {
			nextPage = totPage;
		}
	}

	private void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}

	private void setTotBlock() {
		totBlock = (int) Math.ceil(totPage / BLOCK_SCALE);

	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		totPage = (int) Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	public static int getPageScale() {
		return PAGE_SCALE;
	}

	public static int getBlockSkale() {
		return BLOCK_SCALE;
	}

}
