import java.util.Random;
import java.util.Scanner;


public class HitAndBlow {
	public static void main(String[] args) {
	String question;
	String answer;
	
	question=setQuestion();
	System.out.println("***数当てゲーム HitAndBlow***");
	System.out.println("四桁の数字に0-9までの数を入れましょう");
	System.out.println("桁と数字が同じ：Hit 答えに数字があるけれども桁が違う:Blow");
	System.out.println("");
	//System.out.println(question);

	for(int i=1;i<=10;i++) {
		System.out.print(i+"回目 ");
		answer=input();
		if(judge(question,answer))break;
	}
	System.out.println("正解:"+question);
	System.out.println("ゲームは終了しました");
	
	}
	
	public static String setQuestion() {
		String question="";		
		int[] quesnum= {-1,-1,-1,-1};
		int h=0;
		int i=0;
		boolean selected=false;
		do{
			selected=true;
			quesnum[i]=new Random().nextInt(10);
				for(h=0;h<i;h++) {
					if(quesnum[h]==quesnum[i])selected=false;
				}
			if(selected)i++;
		}while(i<4);
		for(i=0;i<4;i++) {
			question+=Integer.valueOf(quesnum[i]).toString();
		}
		return question;
	}
	public static String input() {
		String getnum="";
		boolean repeat;
		do {
		repeat=false;
		System.out.println("半角数字4桁を入力してください");
		System.out.println("(0-9)、一度使った数字は使えない　例：2222×　0123○");
		getnum=new Scanner(System.in).nextLine();
		if(getnum.matches("[0-9]{4}")) {
			for(int h=0;h<getnum.length();h++) {
				for(int i=0;i<getnum.length();i++) {
					if(getnum.charAt(h)==getnum.charAt(i) && h!=i) {
						repeat=true;
					}
				}
			}	
		}else {
			repeat=true;
		}
			
		}while(repeat==true);
		return getnum;
	}
	public static boolean judge(String question,String answer) {
		int hit=0;
		int blow=0;
		for(int i=0;i<4;i++) {
			for(int h=0;h<4;h++) {
				if(question.charAt(h)==answer.charAt(i)) {
					if(h==i) {
						hit++;
							}else {
						blow++;
					}
				}
			}
		}
		System.out.println("Hit:"+hit+" Blow:"+blow);
		if(question.equals(answer))return true;
		return false;
	}

}
