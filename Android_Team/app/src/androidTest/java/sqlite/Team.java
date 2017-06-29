package sqlite;

public class Team{
	public String name;
	public int id;
	public Team(){
		name="";
		id=-1;
	}
	public Team(int id,String name){
		this.name=name;
		this.id=id;

	}
}
