import java.io.*;

class Voter
{
    static int tot_vote_count =0;
    boolean self_vote_status;
    private int age;

    Voter(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public boolean display_status()
    {
        if(age<18)
            self_vote_status = false;
        else
        {
            self_vote_status = true;
            tot_vote_count++;

        }
        return self_vote_status;
    }

}

public class lab07
{
    public static void main(String[] args) throws IOException,NumberFormatException
    {
        int age;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter age of the Voter 1 : ");
        age = Integer.parseInt(br.readLine());
        Voter v1 = new Voter(age);
        System.out.print("Enter age of the Voter 2 : ");
        age = Integer.parseInt(br.readLine());
        Voter v2 = new Voter(age);
        System.out.print("Enter age of the Voter 3 : ");
        age = Integer.parseInt(br.readLine());
        Voter v3 = new Voter(age);
        System.out.print("Enter age of the Voter 4 : ");
        age = Integer.parseInt(br.readLine());
        Voter v4 = new Voter(age);

        System.out.println("\nVoter Age \t\t Vote_Status \t\t Tot_Vote_Count");
        System.out.println(v1.getAge()+"\t\t\t  "+v1.display_status()+"\t\t\t\t"+Voter.tot_vote_count);
        System.out.println(v2.getAge()+"\t\t\t  "+v2.display_status()+"\t\t\t\t"+Voter.tot_vote_count);
        System.out.println(v3.getAge()+"\t\t\t  "+v3.display_status()+"\t\t\t\t"+Voter.tot_vote_count);
        System.out.println(v4.getAge()+"\t\t\t  "+v4.display_status()+"\t\t\t\t"+Voter.tot_vote_count);

    }
}