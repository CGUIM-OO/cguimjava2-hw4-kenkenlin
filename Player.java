import java.util.ArrayList;
public class Player {
	private String name;
	private int chips;
	private int bet;
	private ArrayList<Card> oneRoundCard;
	public Player(String inputname, int inputchips) {
		name=inputname;
		chips=inputchips;
	}

	public String getName() {
		return name;
	}
	//- 下注，回傳預計下注的籌碼
    //- 基本下注：一次1元
	public int makeBet() {
		if(getCurrentChips()>1) {
			bet=1;
			return bet;
		}else {
			bet=0;
			return bet;
		}
	}
	//設定此牌局所得到的卡 setter
	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard=cards;
	}
	//- 是否要牌，是回傳true，不再要牌則回傳false
    //- 基本參考條件：16點以下要牌，17點以上不要牌
    //- 提示：用oneRoundCard來算
	public boolean hitMe() {
		boolean hithop =false;
		if(getTotalValue()>17) {
			return hithop;
		}else {
			hithop=true;
			return hithop;
		}
	}
	//回傳此牌局所得的卡點數加總
	public int getTotalValue() {
		int Totalvalue=0;
		int ACEChoice=0;
		for (int index = 0; index < oneRoundCard.size(); index++) {
			switch (oneRoundCard.get(index).getRank()) {
			case 11:
				Totalvalue+=10;
				break;
			case 12:
				Totalvalue+=10;
				break;	
			case 13:
				Totalvalue+=10;
				break;
			default:
				Totalvalue+=oneRoundCard.get(index).getRank();
				break;
			case 1:
				ACEChoice+=1;
				break;	
			}
		}
		while(ACEChoice>0) {
			if(Totalvalue+10>21) {
				Totalvalue+=1;
			}else {
				Totalvalue+=10;
			}
			ACEChoice-=1;
		}
		return Totalvalue;
	}
	//回傳玩家現有籌碼
	public int getCurrentChips() {
		return chips;
	}
	//玩家籌碼變動，setter
	public void increaseChips(int diff){
		chips+=diff;
	}
	
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
	    System.out.println("I have " + chips + " chips.");
	}
	
}
