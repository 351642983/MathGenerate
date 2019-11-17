package math;

import java.util.ArrayList;
import java.util.List;

public class MathGenerate {
	List<String> question=new ArrayList<String>();
	public List<String> getQuestion() {
		return question;
	}
	public void setQuestion(List<String> question) {
		this.question = question;
	}
	public List<String> getAnwser() {
		return anwser;
	}
	public void setAnwser(List<String> anwser) {
		this.anwser = anwser;
	}

	List<String> anwser=new ArrayList<String>();
	public void generate(int num,int charaternum)
	{
		String []fuhao=new String[] {"+","-","*","/"};
		StringHandle sh=new StringHandle();
		for(int i=0;i<num;i++)
		{
			int anwserTemp=0;
			String result=null;
			int numa=random_num(1,100);
			result=numa+"";
			for(int j=0;j<charaternum;j++)
			{
				int charatype=random_num(1,4);
				int numb=random_num(1,100);
				int right=random_num(0,1);
				if(right==1)
				{
					if(charatype==1)
					{
						numa=numa+numb;
					}
					else if(charatype==2)
					{
						numa=numa-numb;
					}
					else if(charatype==3)
					{
						while(numb>10)
						{
							numb=random_num(2,100);
						}
						numa=numa*numb;
					}
					else if(charatype==4)
					{
						while(numa%numb!=0)
						{
							numb=random_num(1,101);
							if(numb==101)
							{
								numb=numa;
								break;
							}
						}
						numa=numa/numb;
					}
					if(charaternum>1)
						result=sh.StringAdd("("+result, "", fuhao[charatype-1]+numb+")");
					else result=sh.StringAdd(result, "", fuhao[charatype-1]+numb);
					anwserTemp=numa;
				}
				else
				{
					if(charatype==1)
					{
						numa=numb+numa;
					}
					else if(charatype==2)
					{
						numa=numb-numa;
					}
					else if(charatype==3)
					{
						while(numb>10)
						{
							numb=random_num(2,100);
						}
						numa=numb*numa;
					}
					else if(charatype==4)
					{
						while(numb%numa!=0)
						{
							numb=random_num(1,101);
							if(numb==101)
							{
								numb=numa;
								break;
							}
						}
						if(numa!=0)
							numa=numb/numa;
						else
						{
							charatype=1;
							numa=numb+numa;
						}
					}
					if(charaternum>1)
						result=sh.StringAdd(result+")", "("+numb+fuhao[charatype-1],"" );
					else result=sh.StringAdd(result, numb+fuhao[charatype-1],"" );
					anwserTemp=numa;
				}
			}
			question.add(result);
			anwser.add(anwserTemp+"");
		}
	}
	public static int random_num(int start,int end)
	{
		return start+(int) (Math.random()*(end-start+1));
	}
	
	public static void main(String args[])
	{
		MathGenerate mg=new MathGenerate();
		mg.generate(50, 1);
		for(int i=0;i<mg.getAnwser().size();i++)
		{
			System.out.println(mg.getQuestion().get(i)+"="+mg.getAnwser().get(i));
		}
	}
	
	
}
