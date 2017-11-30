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
	//- �U�`�A�^�ǹw�p�U�`���w�X
    //- �򥻤U�`�G�@��1��
	public int makeBet() {
		if(getCurrentChips()>1) {
			bet=1;
			return bet;
		}else {
			bet=0;
			return bet;
		}
	}
	//�]�w���P���ұo�쪺�d setter
	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard=cards;
	}
	//- �O�_�n�P�A�O�^��true�A���A�n�P�h�^��false
    //- �򥻰Ѧұ���G16�I�H�U�n�P�A17�I�H�W���n�P
    //- ���ܡG��oneRoundCard�Ӻ�
	public boolean hitMe() {
		boolean hithop =false;
		if(getTotalValue()>17) {
			return hithop;
		}else {
			hithop=true;
			return hithop;
		}
	}
	//�^�Ǧ��P���ұo���d�I�ƥ[�`
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
	//�^�Ǫ��a�{���w�X
	public int getCurrentChips() {
		return chips;
	}
	//���a�w�X�ܰʡAsetter
	public void increaseChips(int diff){
		chips+=diff;
	}
	
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
	    System.out.println("I have " + chips + " chips.");
	}
	
}
