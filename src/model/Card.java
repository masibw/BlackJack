package model;

public class Card {
	private int index;
	private int kind;
	private int number;

	public Card(int kind,int number,int index){
		this.kind=kind;
		this.number=number;
		this.index=index;
	}

	public void setKind(int kind) {
		this.kind=kind;
	}
	public void setNumber(int number) {
		this.number=number;
	}
	public int getIndex() {
		return this.index;
	}
	public void setIndex(int index) {
		this.index=index;
	}
	public String getKind() {
		switch (this.kind) {
		case 1: return "スペード";
		case 2: return "ハート";
		case 3: return "ダイヤ";
		case 4: return "クラブ";
		default: return "kind type error";
		}
	}

	public int getNumber() {
		return this.number;
	}
}
