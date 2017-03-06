package test.com.baisc.exception;

//Exception BaseballException in throws clause of Inning.event() is not compatible with Storm.event()
public class StormyInning extends Inning implements Storm{

	public StormyInning()throws RainedOut,BaseballException{
	}
	
	public StormyInning(String s)throws Foul,BaseballException{
	}
	
	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}
	
	public void event(){
		
	}

	@Override
	public void atBat() throws Strike, Foul {
		// TODO Auto-generated method stub
		
	}

}
